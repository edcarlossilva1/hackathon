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

import com.hackathon.hotel.DTO.ItensServicoDTO;
import com.hackathon.hotel.service.ItensServicoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/itensservico")
public class ItensServicoController {
   
	private final ItensServicoService service;
	
	public ItensServicoController(ItensServicoService service) {
		this.service = service;
	}
	


	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<ItensServicoDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var itensservico = service.findAll(pageRequest);
		return ResponseEntity.ok(itensservico);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<ItensServicoDTO> findById(@PathVariable Long id) {
         var itensservico = service.findById(id);
         return ResponseEntity.ok(itensservico);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <ItensServicoDTO> save (@Valid @RequestBody ItensServicoDTO dto ){
		var itensservico = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((itensservico.getId_item_servico())).toUri();
		 return ResponseEntity.created(uri).body(itensservico);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <ItensServicoDTO> update(@Valid  @RequestBody ItensServicoDTO dto,  @PathVariable Long id ){
		var itensservico = service.update(id, dto);
        return ResponseEntity.ok(itensservico);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
