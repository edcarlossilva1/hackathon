package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.LocalidadeDTO;
import com.hackathon.hotel.DTO.LocalidadeEnderecoAmenidadeDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.ILocalidadeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LocalidadeService {

	@Autowired
	private final ILocalidadeRepository repository;

	
	// Construtor do service
	public LocalidadeService(ILocalidadeRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<LocalidadeEnderecoAmenidadeDTO> findAll(PageRequest page) {
		var localidade = repository.findAll(page);
		return localidade.map(LocalidadeEnderecoAmenidadeDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public LocalidadeEnderecoAmenidadeDTO findById(Long id) {
		var localidade = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Localidade não encontrada"));
		return LocalidadeEnderecoAmenidadeDTO.fromEntity(localidade);
	}

	// Metodo para salvar informações
	public LocalidadeDTO save(LocalidadeDTO dto) {
		var entity = LocalidadeDTO.toEntity(dto);
		var saved = repository.save(entity);
		return LocalidadeDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public LocalidadeDTO update(Long id, LocalidadeDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			LocalidadeDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return LocalidadeDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Localidade não encontrado, id: " + id);

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
