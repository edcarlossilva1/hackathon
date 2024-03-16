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

import com.hackathon.hotel.DTO.LocalidadeDTO;
import com.hackathon.hotel.DTO.LocalidadeEnderecoAmenidadeDTO;
import com.hackathon.hotel.service.LocalidadeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/localidade")
public class LocalidadeController {

	// Atributo minha service
	private final LocalidadeService service;

	// Construtor da minha controller
	public LocalidadeController(LocalidadeService service) {
		this.service = service;
	}

	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<LocalidadeEnderecoAmenidadeDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var localidade = service.findAll(pageRequest);
		return ResponseEntity.ok(localidade);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<LocalidadeEnderecoAmenidadeDTO> findById(@PathVariable Long id) {
         var localidade = service.findById(id);
         return ResponseEntity.ok(localidade);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <LocalidadeDTO> save (@Valid @RequestBody LocalidadeDTO dto ){
		var localidade = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((localidade.getId_localidade())).toUri();
		 return ResponseEntity.created(uri).body(localidade);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <LocalidadeDTO> update(@Valid  @RequestBody LocalidadeDTO dto,  @PathVariable Long id ){
		var localidade = service.update(id, dto);
        return ResponseEntity.ok(localidade);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}  
	
