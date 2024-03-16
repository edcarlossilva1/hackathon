package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.ServicoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_servico;
	private String descricao;
	private double valor;
	private boolean sn_por_pessoa;

	public Servico() {

	}

	public Servico(Long id_servico, String descricao, double valor, boolean sn_por_pessoa) {
		this.id_servico = id_servico;
		this.descricao = descricao;
		this.valor = valor;
		this.sn_por_pessoa = sn_por_pessoa;
	}

	public Servico(ServicoDTO dto) {
		this.id_servico = dto.getId_servico();
		this.descricao = dto.getDescricao();
		this.valor = dto.getValor();
		this.sn_por_pessoa = dto.isSn_por_pessoa();
	}

	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
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

	public boolean isSn_por_pessoa() {
		return sn_por_pessoa;
	}

	public void setSn_por_pessoa(boolean sn_por_pessoa) {
		this.sn_por_pessoa = sn_por_pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_servico == null) ? 0 : id_servico.hashCode());
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
		Servico other = (Servico) obj;
		if (id_servico == null) {
			if (other.id_servico != null)
				return false;
		} else if (!id_servico.equals(other.id_servico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servico [id_servico=" + id_servico + ", descricao=" + descricao + ", valor=" + valor
				+ ", sn_por_pessoa=" + sn_por_pessoa + "]";
	}

}
