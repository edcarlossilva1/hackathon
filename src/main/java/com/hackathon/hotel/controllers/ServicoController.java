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

import com.hackathon.hotel.DTO.ServicoDTO;
import com.hackathon.hotel.service.ServicoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	// Atributo minha service
		private final ServicoService service;

		// Construtor da minha controller
		public ServicoController(ServicoService service) {
			this.service = service;
		}

		// Endpoint listar todos
		@GetMapping
		public ResponseEntity<Page<ServicoDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
				@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
			PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
			var servico = service.findAll(pageRequest);
			return ResponseEntity.ok(servico);
		}

		//Endpoint buscar por Id
		@GetMapping("/{id}")
		public ResponseEntity<ServicoDTO> findById(@PathVariable Long id) {
	         var servico = service.findById(id);
	         return ResponseEntity.ok(servico);
		}
		
		//Endpoint inserir informação
		@PostMapping
		public ResponseEntity <ServicoDTO> save (@Valid @RequestBody ServicoDTO dto ){
			var servico = service.save(dto);
			 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((servico.getId_servico())).toUri();
			 return ResponseEntity.created(uri).body(servico);
		}
		
		//Endpoint atualizar informação
		@PutMapping("/{id}")
		public ResponseEntity <ServicoDTO> update(@Valid  @RequestBody ServicoDTO dto,  @PathVariable Long id ){
			var servico = service.update(id, dto);
	        return ResponseEntity.ok(servico);
		}
		
		//Endpoint deletar informações
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
}
