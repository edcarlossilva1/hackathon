package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.MovelDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movel") 
public class Movel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_movel;
	private String descricao;
	
	public Movel() {

	}

	public Movel(Long id_movel, String descricao) {
		this.id_movel = id_movel;
		this.descricao = descricao;
	}

	public Movel(MovelDTO dto) {
		this.id_movel = dto.getId_movel();
		this.descricao = dto.getDescricao();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_movel == null) ? 0 : id_movel.hashCode());
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
		Movel other = (Movel) obj;
		if (id_movel == null) {
			if (other.id_movel != null)
				return false;
		} else if (!id_movel.equals(other.id_movel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predio [id_movel=" + id_movel + ", descricao=" + descricao + "]";
	}

	
}
