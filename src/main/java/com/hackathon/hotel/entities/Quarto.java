package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.QuartoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_quarto")
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_quarto;
	private String tipo;
	private int total_pessoa;
	private int total_cama;
	private String banheiro;
	private double valor_diaria;
	private int quantidade_quartos;
	private boolean disponivel;

	public Quarto() {
	}

	public Quarto(Long id_quarto, String tipo, int total_pessoa, int total_cama, String banheiro, double valor_diaria,
			int quantidade_quartos, boolean disponivel) {
		this.id_quarto = id_quarto;
		this.tipo = tipo;
		this.total_pessoa = total_pessoa;
		this.total_cama = total_cama;
		this.banheiro = banheiro;
		this.valor_diaria = valor_diaria;
		this.quantidade_quartos = quantidade_quartos;
		this.disponivel = disponivel;
	}

	public Quarto(QuartoDTO dto) {
		this.id_quarto = dto.getId_quarto();
		this.tipo = dto.getTipo();
		this.total_pessoa = dto.getTotal_pessoa();
		this.total_cama = dto.getTotal_cama();
		this.banheiro = dto.getBanheiro();
		this.valor_diaria = dto.getValor_diaria();
		this.quantidade_quartos = dto.getQuantidade_quartos();
		this.disponivel = dto.isDisponivel();

	}

	public Long getId_quarto() {
		return id_quarto;
	}

	public void setId_quarto(Long id_quarto) {
		this.id_quarto = id_quarto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTotal_pessoa() {
		return total_pessoa;
	}

	public void setTotal_pessoa(int total_pessoa) {
		this.total_pessoa = total_pessoa;
	}

	public int getTotal_cama() {
		return total_cama;
	}

	public void setTotal_cama(int total_cama) {
		this.total_cama = total_cama;
	}

	public String getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(String banheiro) {
		this.banheiro = banheiro;
	}

	public double getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(double valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public int getQuantidade_quartos() {
		return quantidade_quartos;
	}

	public void setQuantidade_quartos(int quantidade_quartos) {
		this.quantidade_quartos = quantidade_quartos;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_quarto == null) ? 0 : id_quarto.hashCode());
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
		Quarto other = (Quarto) obj;
		if (id_quarto == null) {
			if (other.id_quarto != null)
				return false;
		} else if (!id_quarto.equals(other.id_quarto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quarto [id_quarto=" + id_quarto + ", tipo=" + tipo + ", total_pessoa=" + total_pessoa + ", total_cama="
				+ total_cama + ", banheiro=" + banheiro + ", disponivel=" + disponivel + ", valor_diaria=" + valor_diaria + ", quantidade_quartos="
				+ quantidade_quartos + "]";
	}

}