package com.hackathon.hotel.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hackathon.hotel.DTO.AmenidadeLocalidadeDTO;
import com.hackathon.hotel.service.AmenidadeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/amenidade")
public class AmenidadeController {

	// Atributo minha service
	private final AmenidadeService service;

	// Construtor da minha controller
	public AmenidadeController(AmenidadeService service) {
		this.service = service;
	}

	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<AmenidadeLocalidadeDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var amenidade = service.findAll(pageRequest);
		return ResponseEntity.ok(amenidade);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<AmenidadeLocalidadeDTO> findById(@PathVariable Long id) {
         var amenidade = service.findById(id);
         return ResponseEntity.ok(amenidade);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <AmenidadeLocalidadeDTO> save (@Valid @RequestBody AmenidadeLocalidadeDTO dto ){
		var amenidade = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((amenidade.getId_amenidade())).toUri();
		 return ResponseEntity.created(uri).body(amenidade);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <AmenidadeLocalidadeDTO> update(@Valid  @RequestBody AmenidadeLocalidadeDTO dto,  @PathVariable Long id ){
		var amenidade = service.update(id, dto);
        return ResponseEntity.ok(amenidade);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}  
	
