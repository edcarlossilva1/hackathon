package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.QuartoDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IQuartoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuartoService {

	@Autowired
	private final IQuartoRepository repository;

	
	// Construtor do service
	public QuartoService(IQuartoRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<QuartoDTO> findAll(PageRequest page) {
		var localidade = repository.findAll(page);
		return localidade.map(QuartoDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public QuartoDTO findById(Long id) {
		var localidade = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Quarto não encontrado"));
		return QuartoDTO.fromEntity(localidade);
	}

	// Metodo para salvar informações
	@Transactional
	public QuartoDTO save(QuartoDTO dto) {
		var entity = QuartoDTO.toEntity(dto);
		var saved = repository.save(entity);
		return QuartoDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public QuartoDTO update(Long id, QuartoDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			QuartoDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return QuartoDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Quarto não encontrado, id: " + id);

		}
	}

	@Transactional
	// Metodo para deletar informações
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade dos dados");
		}
	}
}
