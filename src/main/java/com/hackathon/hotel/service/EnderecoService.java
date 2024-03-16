package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.EnderecoLocalidadeDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IEnderecoRepository;
import com.hackathon.hotel.repository.ILocalidadeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private final IEnderecoRepository repository;
	private final ILocalidadeRepository localidadeRepository;

	
	// Construtor do service
	public EnderecoService(IEnderecoRepository repository, ILocalidadeRepository localidadeRepository) {
		this.repository = repository;
		this.localidadeRepository = localidadeRepository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<EnderecoLocalidadeDTO> findAll(PageRequest page) {
		var localidade = repository.findAll(page);
		return localidade.map(EnderecoLocalidadeDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public EnderecoLocalidadeDTO findById(Long id) {
		var endereco = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Endereco não encontrada"));
		return EnderecoLocalidadeDTO.fromEntity(endereco);
	}
    
	@Transactional
	// Metodo para salvar informações
	public EnderecoLocalidadeDTO save(EnderecoLocalidadeDTO dto) {
		try {
		var localidade = localidadeRepository.getReferenceById(dto.getLocalidade().getId_localidade());
		var entity = EnderecoLocalidadeDTO.toEntity(dto, localidade);
		var saved = repository.save(entity);
		return EnderecoLocalidadeDTO.fromEntity(saved);
	} catch(DataIntegrityViolationException e) {
		throw new DatabaseException("Localidade não encontrada");
	}
}
	// Metodo para atualizar informações
	@Transactional
	public EnderecoLocalidadeDTO update(Long id, EnderecoLocalidadeDTO dto) {
		try {
			var localidade = localidadeRepository.getReferenceById(dto.getLocalidade().getId_localidade());
			var entity = repository.getReferenceById(id);
			EnderecoLocalidadeDTO.mapperDtoToEntity(dto, entity, localidade);
			entity = repository.save(entity);
			return EnderecoLocalidadeDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Localidade/Endereco não encontrado");

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
