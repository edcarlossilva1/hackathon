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

import com.hackathon.hotel.DTO.QuartoDTO;
import com.hackathon.hotel.service.QuartoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/quarto")
public class QuartoController {
    
	// Atributo minha service
	private final QuartoService service;

	// Construtor da minha controller
	public QuartoController(QuartoService service) {
		this.service = service;
	}

	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<QuartoDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var predio = service.findAll(pageRequest);
		return ResponseEntity.ok(predio);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<QuartoDTO> findById(@PathVariable Long id) {
         var predio = service.findById(id);
         return ResponseEntity.ok(predio);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <QuartoDTO> save (@Valid @RequestBody QuartoDTO dto ){
		var quarto = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((quarto.getId_quarto())).toUri();
		 return ResponseEntity.created(uri).body(quarto);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <QuartoDTO> update(@Valid  @RequestBody QuartoDTO dto,  @PathVariable Long id ){
		var quarto = service.update(id, dto);
        return ResponseEntity.ok(quarto);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}  
	
