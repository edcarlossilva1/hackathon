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

import com.hackathon.hotel.DTO.MovelDTO;
import com.hackathon.hotel.service.MovelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movel")
public class MovelController {

	// Atributo minha service
	private final MovelService service;

	// Construtor da minha controller
	public MovelController(MovelService service) {
		this.service = service;
	}

	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<MovelDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var predio = service.findAll(pageRequest);
		return ResponseEntity.ok(predio);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<MovelDTO> findById(@PathVariable Long id) {
         var predio = service.findById(id);
         return ResponseEntity.ok(predio);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <MovelDTO> save (@Valid @RequestBody MovelDTO dto ){
		var movel = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((movel.getId_movel())).toUri();
		 return ResponseEntity.created(uri).body(movel);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <MovelDTO> update(@Valid  @RequestBody MovelDTO dto,  @PathVariable Long id ){
		var movel = service.update(id, dto);
        return ResponseEntity.ok(movel);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}  
	
