package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.ItensServico;

public class ItensServicoDTO {

	private Long id_item_servico;
	private String descricao;
	private double valor;
	private boolean sn_unidade;

	public ItensServicoDTO() {

	}

	public ItensServicoDTO(Long id_item_servico, String descricao, double valor, boolean sn_unidade) {
		this.id_item_servico = id_item_servico;
		this.descricao = descricao;
		this.valor = valor;
		this.sn_unidade = sn_unidade;
	}

	public ItensServicoDTO(ItensServico entity) {
		this.id_item_servico = entity.getId_item_servico();
		this.descricao = entity.getDescricao();
		this.valor = entity.getValor();
		this.sn_unidade = entity.isSn_unidade();
	}

	public Long getId_item_servico() {
		return id_item_servico;
	}

	public void setId_item_servico(Long id_item_servico) {
		this.id_item_servico = id_item_servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isSn_unidade() {
		return sn_unidade;
	}

	public void setSn_unidade(boolean sn_unidade) {
		this.sn_unidade = sn_unidade;
	}
	
	// Para entidade
		public static ItensServico toEntity(ItensServicoDTO dto) {
			return new ItensServico(dto);

		}

		// Da entidade
		public static ItensServicoDTO fromEntity(ItensServico entity) {
			return new ItensServicoDTO(
					entity.getId_item_servico(),
					entity.getDescricao(),
					entity.getValor(),
					entity.isSn_unidade()
					);
		}

		// Mapper para utilizar no update
		public static ItensServico mapperDtoToEntity(ItensServicoDTO dto, ItensServico entity) {
			entity.setDescricao(dto.getDescricao());
			entity.setValor(dto.getValor());
			entity.setSn_unidade(dto.isSn_unidade());
			return entity;
		}
	
}
