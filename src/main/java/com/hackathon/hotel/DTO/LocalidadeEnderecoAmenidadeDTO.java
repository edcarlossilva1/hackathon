package com.hackathon.hotel.DTO;

import java.util.HashSet;
import java.util.Set;

import com.hackathon.hotel.entities.Localidade;

public class LocalidadeEnderecoAmenidadeDTO {

	private Long id_localidade;
	private String nome;
	private Set<EnderecoDTO> endereco;
	private Set<AmenidadeDTO> amenidade;
	
	public LocalidadeEnderecoAmenidadeDTO() {
	}

	public LocalidadeEnderecoAmenidadeDTO(Long id_localidade, String nome, Set<EnderecoDTO> endereco, Set<AmenidadeDTO> amenidade ) {
		this.id_localidade = id_localidade;
		this.nome = nome;
		this.endereco = endereco;
		this.amenidade = amenidade;
	}
	
	// 3º Construtor para mapeamento da minha entidade para a DTO
	public LocalidadeEnderecoAmenidadeDTO(Localidade entity) {
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
	

	public Set<AmenidadeDTO> getAmenidade() {
		return amenidade;
	}

		// METODO DA ENTIDADE
		public static LocalidadeEnderecoAmenidadeDTO fromEntity(Localidade localidade) {
			Set<EnderecoDTO> endereco = new HashSet<>();
			if(!localidade.getEndereco().isEmpty()) {
				  localidade.getEndereco().forEach( enderecos ->{
					  endereco.add(EnderecoDTO.fromEntity(enderecos));
				 });
			}
			Set<AmenidadeDTO> amenidade = new HashSet<>();
			if(!localidade.getAmenidade().isEmpty()) {
				  localidade.getAmenidade().forEach( ame ->{
					  amenidade.add(AmenidadeDTO.fromEntity(ame));
				 });
			}
			return new LocalidadeEnderecoAmenidadeDTO(
					localidade.getId_localidade(),
					localidade.getNome(),
					endereco,
					amenidade
					
			);	
		}


}
