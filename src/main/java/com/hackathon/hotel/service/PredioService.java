package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.PredioDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IPredioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PredioService {

	@Autowired
	private final IPredioRepository repository;

	
	// Construtor do service
	public PredioService(IPredioRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<PredioDTO> findAll(PageRequest page) {
		var predio = repository.findAll(page);
		return predio.map(PredioDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public PredioDTO findById(Long id) {
		var predio = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Predio não encontrado"));
		return PredioDTO.fromEntity(predio);
	}

	// Metodo para salvar informações
	public PredioDTO save(PredioDTO dto) {
		var entity = PredioDTO.toEntity(dto);
		var saved = repository.save(entity);
		return PredioDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public PredioDTO update(Long id, PredioDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			PredioDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return PredioDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Predio não encontrado, id: " + id);

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
