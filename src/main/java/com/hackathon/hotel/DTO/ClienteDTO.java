package com.hackathon.hotel.DTO;

import java.time.LocalDate;

import com.hackathon.hotel.entities.Cliente;

public class ClienteDTO {

	private Long id_cliente;
	private String pais;
	private String cpf;
	private String passaport;
	private String nome;
	private LocalDate nascimento;
	private String enderco_pais_origem;
	private String teletfone;
	private String email;

	public ClienteDTO() {

	}

	public ClienteDTO(Long id_cliente, String pais, String cpf, String passaport, String nome, LocalDate nascimento,
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
	
	public ClienteDTO(Cliente entity) {
		this.id_cliente = entity.getId_cliente();
		this.pais = entity.getPais();
		this.cpf = entity.getCpf();
		this.passaport = entity.getPassaport();
		this.nome = entity.getNome();
		this.nascimento = entity.getNascimento();
		this.enderco_pais_origem = entity.getEnderco_pais_origem();
		this.teletfone = entity.getTeletfone();
		this.email = entity.getEmail();
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
	
	// Para entidade
	public static Cliente toEntity(ClienteDTO dto) {
		return new Cliente(dto);

	}

	// Da entidade
	public static ClienteDTO fromEntity(Cliente entity) {
		return new ClienteDTO(
				entity.getId_cliente(),
				entity.getPais(),
				entity.getCpf(),
				entity.getPassaport(),
				entity.getNome(),
				entity.getNascimento(),
				entity.getEnderco_pais_origem(),
				entity.getTeletfone(),
				entity.getEmail()
				);
	}

	// Mapper para utilizar no update
	public static Cliente mapperDtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setPais(dto.getPais());
		entity.setCpf(dto.getCpf());
		entity.setPassaport(dto.getPassaport());
		entity.setNome(dto.getNome());
		entity.setNascimento(dto.getNascimento());
		entity.setEnderco_pais_origem(dto.getEnderco_pais_origem());
		entity.setTeletfone(dto.getTeletfone());
		entity.setEmail(dto.getEmail());
		return entity;
	}

}
