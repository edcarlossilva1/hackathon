package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.PredioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_predio") 
public class Predio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_predio;
	private String nome;
	
	public Predio() {

	}

	public Predio(Long id_predio, String nome) {
		this.id_predio = id_predio;
		this.nome = nome;
	}

	public Predio(PredioDTO dto) {
		this.id_predio = dto.getId_predio();
		this.nome = dto.getNome();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_predio == null) ? 0 : id_predio.hashCode());
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
		Predio other = (Predio) obj;
		if (id_predio == null) {
			if (other.id_predio != null)
				return false;
		} else if (!id_predio.equals(other.id_predio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predio [id_predio=" + id_predio + ", nome=" + nome + "]";
	}

	
}
