package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.ItensServicoDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IItensServicoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItensServicoService {

	@Autowired
	private final IItensServicoRepository repository;

	
	// Construtor do service
	public ItensServicoService(IItensServicoRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<ItensServicoDTO> findAll(PageRequest page) {
		var itensservico = repository.findAll(page);
		return itensservico.map(ItensServicoDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public ItensServicoDTO findById(Long id) {
		var itensservico = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Item de serviço não encontrado"));
		return ItensServicoDTO.fromEntity(itensservico);
	}

	// Metodo para salvar informações
	@Transactional
	public ItensServicoDTO save(ItensServicoDTO dto) {
		var entity = ItensServicoDTO.toEntity(dto);
		var saved = repository.save(entity);
		return ItensServicoDTO.fromEntity(saved);
	}

	// Metodo para atualizar informações
	@Transactional
	public ItensServicoDTO update(Long id, ItensServicoDTO dto) {
		try {
			var entity = repository.getReferenceById(id);
			ItensServicoDTO.mapperDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return ItensServicoDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Item de servico não encontrado, id: " + id);

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
