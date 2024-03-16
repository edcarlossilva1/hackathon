package com.hackathon.hotel.entities;

import java.time.LocalDate;

import com.hackathon.hotel.DTO.ClienteDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
	private String pais;
	private String cpf;
	private String passaport;
	private String nome;
	private LocalDate nascimento;
	private String enderco_pais_origem;
	private String teletfone;
	private String email;
	public Cliente() {
	
	}
	public Cliente(Long id_cliente, String pais, String cpf, String passaport, String nome, LocalDate nascimento,
			String enderco_pais_origem, String teletfone, String email) {
		this.id_cliente = id_cliente;
		this.pais = pais;
		this.cpf = cpf;
		this.passaport = passaport;
		this.nome = nome;
		this.nascimento = nascimento;
		this.enderco_pais_origem = enderco_pais_origem;
		this.teletfone = teletfone;
		this.email = email;
	}
	
	public Cliente(ClienteDTO dto) {
		this.id_cliente = dto.getId_cliente();
		this.pais = dto.getPais();
		this.cpf = dto.getCpf();
		this.passaport = dto.getPassaport();
		this.nome = dto.getNome();
		this.nascimento = dto.getNascimento();
		this.enderco_pais_origem = dto.getEnderco_pais_origem();
		this.teletfone = dto.getTeletfone();
		this.email = dto.getEmail();
	}
	
	
	
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassaport() {
		return passaport;
	}
	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getEnderco_pais_origem() {
		return enderco_pais_origem;
	}
	public void setEnderco_pais_origem(String enderco_pais_origem) {
		this.enderco_pais_origem = enderco_pais_origem;
	}
	public String getTeletfone() {
		return teletfone;
	}
	public void setTeletfone(String teletfone) {
		this.teletfone = teletfone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", pais=" + pais + ", cpf=" + cpf + ", passaport=" + passaport
				+ ", nome=" + nome + ", nascimento=" + nascimento + ", enderco_pais_origem=" + enderco_pais_origem
				+ ", teletfone=" + teletfone + ", email=" + email + "]";
	}
    
}
