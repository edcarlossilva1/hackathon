package com.hackathon.hotel.DTO;

import java.util.HashSet;
import java.util.Set;

import com.hackathon.hotel.entities.Localidade;

public class LocalidadeEnderecoDTO {

	private Long id_localidade;
	private String nome;
	private Set<EnderecoDTO> endereco;
	
	public LocalidadeEnderecoDTO() {
	}

	public LocalidadeEnderecoDTO(Long id_localidade, String nome, Set<EnderecoDTO> endereco ) {
		this.id_localidade = id_localidade;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	// 3º Construtor para mapeamento da minha entidade para a DTO
	public LocalidadeEnderecoDTO(Localidade entity) {
		this.id_localidade = entity.getId_localidade();
		this.nome = entity.getNome();
	}
	
	public Long getId_localidade() {
		return id_localidade;
	}

	public void setId_localidade(Long id_localidade) {
		this.id_localidade = id_localidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<EnderecoDTO> getEndereco() {
		return endereco;
	}


	// METODO DA ENTIDADE
		public static LocalidadeEnderecoDTO fromEntity(Localidade localidade) {
			Set<EnderecoDTO> endereco = new HashSet<>();
			if(!localidade.getEndereco().isEmpty()) {
				  localidade.getEndereco().forEach( enderecos ->{
					  endereco.add(EnderecoDTO.fromEntity(enderecos));
				 });
			}
			return new LocalidadeEnderecoDTO(
					localidade.getId_localidade(),
					localidade.getNome(),
					endereco 
					
			);	
		}


}
