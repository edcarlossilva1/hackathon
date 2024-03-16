package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Localidade;

public class LocalidadeDTO {

	private Long id_localidade;
	private String nome;

	public LocalidadeDTO() {
	}

	public LocalidadeDTO(Long id_localidade, String nome) {
		this.id_localidade = id_localidade;
		this.nome = nome;
	}
	
	// 3º Construtor para mapeamento da minha entidade para a DTO
	public LocalidadeDTO(Localidade entity) {
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


	// METODO PARA ENTIDADE
	public static Localidade toEntity(LocalidadeDTO dto) {
		return new Localidade(dto);
	}
	
	

	// METODO DA ENTIDADE
	public static LocalidadeDTO fromEntity(Localidade localidade) {
		return new LocalidadeDTO(
				localidade.getId_localidade(),
				localidade.getNome()
				
		);	
	}

    // Criando o Metodo Mapper para utilização no update 
	public static Localidade mapperDtoToEntity(LocalidadeDTO dto, Localidade entity) {
		//entity.setId(dto.getId_localidade());
		entity.setNome(dto.getNome());
	    return entity;

	}
	
}


