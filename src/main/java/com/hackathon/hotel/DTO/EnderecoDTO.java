package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Endereco;

public class EnderecoDTO {
	
	private Long id_endereco;
	private String rua;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;
	
	
	public EnderecoDTO() {
		
	}
	
	public EnderecoDTO(Long id_endereco, String rua, int numero, String cidade, String estado, String cep) {
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public EnderecoDTO(Endereco entity) {
		this.id_endereco = entity.getId_endereco();
		this.rua = entity.getRua();
		this.numero = entity.getNumero();
		this.cep = entity.getCep();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
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
	
	//Metodos especiais
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	//Para entidade
	public static Endereco toEntity(EnderecoDTO dto) {
		return new Endereco(dto);
		
	}
	
	//Da entidade  
	public static EnderecoDTO fromEntity (Endereco entity) {
		return new EnderecoDTO(
				entity.getId_endereco(),
				entity.getRua(),
				entity.getNumero(),
				entity.getCep(),
				entity.getCidade(),
				entity.getEstado()
				);
	}
	
	//Mapper para utilizar no update 
	public static Endereco mapperDtoToEntity(EnderecoDTO dto, Endereco entity) {
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setCep(dto.getCep());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		return entity;
	}
	
}
