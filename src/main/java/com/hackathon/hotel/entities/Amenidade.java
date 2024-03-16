package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.AmenidadeDTO;
import com.hackathon.hotel.DTO.AmenidadeLocalidadeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_amenidade")
public class Amenidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_amenidade;
	private String descricao;
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_localidade", nullable = false)
	private Localidade localidade;



	public Amenidade() {
	}

	public Amenidade(Long id_amenidade, String descricao, int quantidade, Localidade localidade) {
		this.id_amenidade = id_amenidade;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.localidade = localidade;
		
	}
	
	public Amenidade(AmenidadeDTO dto) {
		this.id_amenidade = dto.getId_amenidade();
		this.descricao = dto.getDescricao();
		this.quantidade = dto.getQuantidade();
	}
	
	
	public Amenidade (AmenidadeLocalidadeDTO dto, Localidade localidade) {
		this.id_amenidade = dto.getId_amenidade();
		this.descricao = dto.getDescricao();
		this.quantidade = dto.getQuantidade();
		this.localidade = localidade;
		
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
	
	

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_amenidade == null) ? 0 : id_amenidade.hashCode());
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
		Amenidade other = (Amenidade) obj;
		if (id_amenidade == null) {
			if (other.id_amenidade != null)
				return false;
		} else if (!id_amenidade.equals(other.id_amenidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Amenidade [id_amenidade=" + id_amenidade + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ "]";
	}
	
	

}
