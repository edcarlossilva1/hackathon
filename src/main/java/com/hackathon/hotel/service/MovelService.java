package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.MovelDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IMovelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovelService {

	@Autowired
	private final IMovelRepository repository;

	
	// Construtor do service
	public MovelService(IMovelRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<MovelDTO> findAll(PageRequest page) {
		var predio = repository.findAll(page);
		return predio.map(MovelDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public MovelDTO findById(Long id) {
		var predio = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Movel não encontrado"));
		return MovelDTO.fromEntity(predio);
	}

	// Metodo para salvar informações
	public MovelDTO save(MovelDTO dto) {
		var entity = MovelDTO.toEntity(dto);
		var saved = repository.save(entity);
		return MovelDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public MovelDTO update(Long id, MovelDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			MovelDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return MovelDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Movel não encontrado, id: " + id);

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
