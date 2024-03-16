package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Movel;
import com.hackathon.hotel.entities.Predio;

public class MovelDTO {
	private Long id_movel;
	private String descricao;

	public MovelDTO() {

	}

	public MovelDTO(Long id_predio, String descricao) {
		this.id_movel = id_predio;
		this.descricao = descricao;
	}

	public MovelDTO(Predio entity) {
		this.id_movel = entity.getId_predio();
		this.descricao = entity.getNome();
	}

	
	
	public Long getId_movel() {
		return id_movel;
	}

	public void setId_movel(Long id_movel) {
		this.id_movel = id_movel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Movel toEntity(MovelDTO dto) {
	  return new Movel(dto);
	}
	
	public static MovelDTO fromEntity(Movel entity) {
		return new MovelDTO(entity.getId_movel(),entity.getDescricao());
	}
	
	public static Movel mapperDtoToEntity(MovelDTO dto, Movel entity) {
		entity.setId_movel(dto.getId_movel());
		entity.setDescricao(dto.getDescricao());
		return entity;
	} 
}
