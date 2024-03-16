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

import com.hackathon.hotel.DTO.EnderecoLocalidadeDTO;
import com.hackathon.hotel.service.EnderecoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	// Atributo minha service
	private final EnderecoService service;

	// Construtor da minha controller
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	// Endpoint listar todos
	@GetMapping
	public ResponseEntity<Page<EnderecoLocalidadeDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "LinesPerPage", defaultValue = "10") Integer LinesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, LinesPerPage);
		var localidade = service.findAll(pageRequest);
		return ResponseEntity.ok(localidade);
	}

	//Endpoint buscar por Id
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoLocalidadeDTO> findById(@PathVariable Long id) {
         var localidade = service.findById(id);
         return ResponseEntity.ok(localidade);
	}
	
	//Endpoint inserir informação
	@PostMapping
	public ResponseEntity <EnderecoLocalidadeDTO> save (@Valid @RequestBody EnderecoLocalidadeDTO dto ){
		var endereco = service.save(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((endereco.getId_endereco())).toUri();
		 return ResponseEntity.created(uri).body(endereco);
	}
	
	//Endpoint atualizar informação
	@PutMapping("/{id}")
	public ResponseEntity <EnderecoLocalidadeDTO> update(@Valid  @RequestBody EnderecoLocalidadeDTO dto,  @PathVariable Long id ){
		var endereco = service.update(id, dto);
        return ResponseEntity.ok(endereco);
	}
	
	//Endpoint deletar informações
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}  
	
