package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.ServicoDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IServicoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private final IServicoRepository repository;

	
	// Construtor do service
	public ServicoService(IServicoRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<ServicoDTO> findAll(PageRequest page) {
		var servico = repository.findAll(page);
		return servico.map(ServicoDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public ServicoDTO findById(Long id) {
		var servico = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Serviço não encontrado"));
		return ServicoDTO.fromEntity(servico);
	}

	// Metodo para salvar informações
	@Transactional
	public ServicoDTO save(ServicoDTO dto) {
		var entity = ServicoDTO.toEntity(dto);
		var saved = repository.save(entity);
		return ServicoDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public ServicoDTO update(Long id, ServicoDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			ServicoDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return ServicoDTO.fromEntity(entity);
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
