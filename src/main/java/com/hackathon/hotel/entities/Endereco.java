package com.hackathon.hotel.entities;

import com.hackathon.hotel.DTO.EnderecoDTO;
import com.hackathon.hotel.DTO.EnderecoLocalidadeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Faz o mapeamento da entidade com o banco de dados

@Table(name = "tb_endereco") // Faz referencias da entidade para tabela do banco de dados
public class Endereco {

	// referencça do id_endereco da tabema e primarkey
	@Id
	// Auto incremental no banco
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	private String rua;
	private int numero;
	private String cep; 
	private String cidade;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_localidade", nullable = false)
	private Localidade localidade;

	public Endereco() {

	}

	public Endereco(Long id_endereco, String rua, int numero, String cidade, String estado, String cep) {
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public Endereco (EnderecoDTO dto) {
		this.id_endereco = dto.getId_endereco();
		this.rua = dto.getRua();
		this.numero = dto.getNumero();
		this.cidade = dto.getCidade();
		this.estado = dto.getEstado();
		this.cep = dto.getCep();
	}
	
	public Endereco (EnderecoLocalidadeDTO dto, Localidade localidade) {
		this.id_endereco = dto.getId_endereco();
		this.rua = dto.getRua();
		this.numero = dto.getNumero();
		this.cep = dto.getCep();
		this.cidade = dto.getCidade();
		this.estado = dto.getEstado();
		this.localidade = localidade;
		
	}

	public Long getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Long id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", rua=" + rua + ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}

}