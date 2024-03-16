package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Predio;

public class PredioDTO {
	private Long id_predio;
	private String nome;

	public PredioDTO() {

	}

	public PredioDTO(Long id_predio, String nome) {
		this.id_predio = id_predio;
		this.nome = nome;
	}

	public PredioDTO(Predio entity) {
		this.id_predio = entity.getId_predio();
		this.nome = entity.getNome();
	}

	public Long getId_predio() {
		return id_predio;
	}

	public void setId_predio(Long id_predio) {
		this.id_predio = id_predio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Predio toEntity(PredioDTO dto) {
	  return new Predio(dto);
	}
	
	public static PredioDTO fromEntity(Predio entity) {
		return new PredioDTO(entity.getId_predio(),entity.getNome());
	}
	
	public static Predio mapperDtoToEntity(PredioDTO dto, Predio entity) {
		entity.setId_predio(dto.getId_predio());
		entity.setNome(dto.getNome());
		return entity;
	} 
}
