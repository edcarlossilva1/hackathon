package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Amenidade;
import com.hackathon.hotel.entities.Localidade;

public class AmenidadeLocalidadeDTO {

	private Long id_amenidade;
	private String descricao;
	private int quantidade;
	private LocalidadeDTO localidade;

	public AmenidadeLocalidadeDTO() {
	}

	public AmenidadeLocalidadeDTO(Long id_amenidade, String descricao, int quantidade, LocalidadeDTO localidade) {
		this.id_amenidade = id_amenidade;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.localidade = localidade;
	}
	
	public AmenidadeLocalidadeDTO (Amenidade entity) {
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

	public LocalidadeDTO getLocalidade() {
		return localidade;
	}

	public void setLocalidade(LocalidadeDTO localidade) {
		this.localidade = localidade;
	}

	public static Amenidade toEntity(AmenidadeLocalidadeDTO dto, Localidade localidade) {
		return new  Amenidade(dto, localidade);
	}
	
	public static AmenidadeLocalidadeDTO fromEntity(Amenidade entity) {
		return new AmenidadeLocalidadeDTO(
				entity.getId_amenidade(),
				entity.getDescricao(),
				entity.getQuantidade(),
				entity.getLocalidade() != null ? LocalidadeDTO.fromEntity(entity.getLocalidade()): null
				);	
	}
	
	public static Amenidade mapperDtoToEntity(AmenidadeLocalidadeDTO dto, Amenidade entity, Localidade localidade) {
		entity.setDescricao(dto.getDescricao());
		entity.setQuantidade(dto.getQuantidade());
		entity.setLocalidade(localidade);
		return entity;
	}
	
	
}
