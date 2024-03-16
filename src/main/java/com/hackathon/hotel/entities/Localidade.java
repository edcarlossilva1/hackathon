package com.hackathon.hotel.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import com.hackathon.hotel.DTO.LocalidadeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_localidade") 
public class Localidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_localidade;
	private String nome;
	@OneToMany(mappedBy = "localidade", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Endereco> endereco = new HashSet<>();
	
	@OneToMany(mappedBy = "localidade", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<Amenidade> amenidade = new HashSet<>();

	// Construtor vazio
	public Localidade() {

	}

	// Construtor populado
	public Localidade(Long id, String nome) {
		this.id_localidade = id;
		this.nome = nome;
	}
	
    //Construtor do meu DTO para entidade
	public Localidade(LocalidadeDTO dto) {
		this.id_localidade = dto.getId_localidade();
		this.nome = dto.getNome();
	}
	

	public Long getId_localidade() {
		return id_localidade;
	}

	public void setId_localidade(Long id_localidade) {
		this.id_localidade = id_localidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Endereco> getEndereco() {
		return endereco;
	}
	
	public Set<Amenidade> getAmenidade() {
		return amenidade;
	}

	// Equals e HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_localidade == null) ? 0 : id_localidade.hashCode());
		return result;
	}

	// To String
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		if (id_localidade == null) {
			if (other.id_localidade != null)
				return false;
		} else if (!id_localidade.equals(other.id_localidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localidade [id_localidade=" + id_localidade + ", nome=" + nome + "]";
	}
}
