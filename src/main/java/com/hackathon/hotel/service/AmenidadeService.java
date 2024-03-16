package com.hackathon.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.hotel.DTO.AmenidadeLocalidadeDTO;
import com.hackathon.hotel.exception.ControllerNotFoundException;
import com.hackathon.hotel.exception.DatabaseException;
import com.hackathon.hotel.repository.IAmenidadeRepository;
import com.hackathon.hotel.repository.ILocalidadeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AmenidadeService {

	@Autowired
	private final IAmenidadeRepository repository;
	private final ILocalidadeRepository localidadeRepository;

	
	// Construtor do service
	public AmenidadeService(IAmenidadeRepository repository, ILocalidadeRepository localidadeRepository) {
		this.repository = repository;
		this.localidadeRepository = localidadeRepository;
	}

	@Transactional(readOnly = true)
	// Metodo para listar todos os itens
	public Page<AmenidadeLocalidadeDTO> findAll(PageRequest page) {
		var amenidade = repository.findAll(page);
		return amenidade.map(AmenidadeLocalidadeDTO::fromEntity);

	}

	@Transactional(readOnly = true)
	// Metodo para lista os itens por id
	public AmenidadeLocalidadeDTO findById(Long id) {
		var amenidade = repository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Amenidade não encontrada"));
		return AmenidadeLocalidadeDTO.fromEntity(amenidade);
	}

	@Transactional
	// Metodo para salvar informações
	public AmenidadeLocalidadeDTO save(AmenidadeLocalidadeDTO dto) {
		try {
	   var localidade = localidadeRepository.getReferenceById(dto.getLocalidade().getId_localidade());
		var entity = AmenidadeLocalidadeDTO.toEntity(dto, localidade);
		var saved = repository.save(entity);
		return AmenidadeLocalidadeDTO.fromEntity(saved);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Localidade não encontrada");
	}
	}

	// Metodo para atualizar informações
	@Transactional
	public AmenidadeLocalidadeDTO update(Long id, AmenidadeLocalidadeDTO dto) {
		try {
			var localidade = localidadeRepository.getReferenceById(dto.getLocalidade().getId_localidade());
			var entity = repository.getReferenceById(id);
			AmenidadeLocalidadeDTO.mapperDtoToEntity(dto, entity, localidade);
			entity = repository.save(entity);
			return AmenidadeLocalidadeDTO.fromEntity(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Amenidade não encontrada, id: " + id);

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
