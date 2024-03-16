package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.ClienteDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private final IClienteRepository repository;

	
	// Construtor do service
	public ClienteService(IClienteRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<ClienteDTO> findAll(PageRequest page) {
		var servico = repository.findAll(page);
		return servico.map(ClienteDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public ClienteDTO findById(Long id) {
		var cliente = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado"));
		return ClienteDTO.fromEntity(cliente);
	}

	// Metodo para salvar informações
	@Transactional
	public ClienteDTO save(ClienteDTO dto) {
		var entity = ClienteDTO.toEntity(dto);
		var saved = repository.save(entity);
		return ClienteDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			ClienteDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return ClienteDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Cliente não encontrado, id: " + id);

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
