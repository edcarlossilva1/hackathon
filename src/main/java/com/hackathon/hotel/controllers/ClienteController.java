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

import com.hackathon.hotel.DTO.ClienteDTO;
import com.hackathon.hotel.service.ClienteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	// Atributo minha service
			private final ClienteService service;

			// Construtor da minha controller
			public ClienteController(ClienteService service) {
				this.service = service;
			}

			// Endpoint listar todos
			@GetMapping
			public ResponseEntity<Page<ClienteDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
					@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
				PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
				var cliente = service.findAll(pageRequest);
				return ResponseEntity.ok(cliente);
			}

			//Endpoint buscar por Id
			@GetMapping("/{id}")
			public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		         var cliente = service.findById(id);
		         return ResponseEntity.ok(cliente);
			}
			
			//Endpoint inserir informação
			@PostMapping
			public ResponseEntity <ClienteDTO> save (@Valid @RequestBody ClienteDTO dto ){
				var cliente = service.save(dto);
				 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((cliente.getId_cliente())).toUri();
				 return ResponseEntity.created(uri).body(cliente);
			}
			
			//Endpoint atualizar informação
			@PutMapping("/{id}")
			public ResponseEntity <ClienteDTO> update(@Valid  @RequestBody ClienteDTO dto,  @PathVariable Long id ){
				var cliente = service.update(id, dto);
		        return ResponseEntity.ok(cliente);
			}
			
			//Endpoint deletar informações
			@DeleteMapping("/{id}")
			public ResponseEntity<Void> delete(@PathVariable Long id){
				service.delete(id);
				return ResponseEntity.noContent().build();
			}
	
}
