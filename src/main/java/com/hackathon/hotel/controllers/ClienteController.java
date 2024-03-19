package com.hackathon.hotel.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hackathon.hotel.DTO.ClienteDTO;
import com.hackathon.hotel.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

//@Controller
//@RequestMapping("/cliente")
@RestController
@RequestMapping(value = "/cliente",produces = {"application/json"})
@Tag(name = "API CLIENTE")
public class ClienteController {

	// Atributo minha service
			private final ClienteService service;

			// Construtor da minha controller
			public ClienteController(ClienteService service) {
				this.service = service;
			}

			// Endpoint listar todos
		 @Operation(summary = "Retorna lista de cliente paginada podendo ser filtrada por marca,modelo,matriculaa",method = "GET")
		    @ApiResponses(value = {
		            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso "),
		            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
		            @ApiResponse(responseCode = "401", description = "Usuário não autenticado"),
		            @ApiResponse(responseCode = "404", description = "Person not found"),
		            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
		            @ApiResponse(responseCode = "500", description = "Erro ao realizar o serviço")})
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
