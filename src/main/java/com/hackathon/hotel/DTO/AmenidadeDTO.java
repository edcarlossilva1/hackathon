package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Amenidade;

public class AmenidadeDTO {

	private Long id_amenidade;
	private String descricao;
	private int quantidade;

	public AmenidadeDTO() {
	}

	public AmenidadeDTO(Long id_amenidade, String descricao, int quantidade) {
		this.id_amenidade = id_amenidade;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	
	public AmenidadeDTO (Amenidade entity) {
		this.id_amenidade = entity.getId_amenidade();
		this.descricao = entity.getDescricao();
		this.quantidade = entity.getQuantidade();
	}

	public Long getId_amenidade() {
		return id_amenidade;
	}

	public void setId_amenidade(Long id_amenidade) {
		this.id_amenidade = id_amenidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static Amenidade toEntity(AmenidadeDTO dto) {
		return new  Amenidade(dto);
	}
	
	public static AmenidadeDTO fromEntity(Amenidade entity) {
		return new AmenidadeDTO(
				entity.getId_amenidade(),
				entity.getDescricao(),
				entity.getQuantidade()
				);	
	}
	
	public static Amenidade mapperDtoToEntity(AmenidadeDTO dto, Amenidade entity) {
		entity.setDescricao(dto.getDescricao());
		entity.setQuantidade(dto.getQuantidade());
		return entity;
	}
	
	
}
