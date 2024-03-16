package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.ItensServicoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_servico")
public class ItensServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_item_servico;
	private String descricao;
	private double valor;
	private boolean sn_unidade;
	
	public ItensServico() {
	
	}
	public ItensServico(Long id_item_servico, String descricao, double valor, boolean sn_unidade) {
		this.id_item_servico = id_item_servico;
		this.descricao = descricao;
		this.valor = valor;
		this.sn_unidade = sn_unidade;
	}
	
	public ItensServico(ItensServicoDTO dto) {
		this.id_item_servico = dto.getId_item_servico();
		this.descricao = dto.getDescricao();
		this.valor = dto.getValor();
		this.sn_unidade = dto.isSn_unidade();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_item_servico == null) ? 0 : id_item_servico.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensServico other = (ItensServico) obj;
		if (id_item_servico == null) {
			if (other.id_item_servico != null)
				return false;
		} else if (!id_item_servico.equals(other.id_item_servico))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItensServico [id_item_servico=" + id_item_servico + ", descricao=" + descricao + ", valor=" + valor
				+ ", sn_unidade=" + sn_unidade + "]";
	}
}
