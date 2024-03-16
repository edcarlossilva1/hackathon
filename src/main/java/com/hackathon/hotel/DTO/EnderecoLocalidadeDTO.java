package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Endereco;
import com.hackathon.hotel.entities.Localidade;

public class EnderecoLocalidadeDTO {
	
	private Long id_endereco;
	private String rua;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;
	private LocalidadeDTO localidade;
	
	
	public EnderecoLocalidadeDTO() {
		
	}
	
	public EnderecoLocalidadeDTO(Long id_endereco, String rua, int numero, String cep, String cidade, String estado, LocalidadeDTO localidade) {
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.localidade = localidade;
		
	}

	public EnderecoLocalidadeDTO(Endereco entity) {
		this.id_endereco = entity.getId_endereco();
		this.rua = entity.getRua();
		this.numero = entity.getNumero();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
		this.cep = entity.getCep();
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
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	//Metodos especiais
	
	

	public LocalidadeDTO getLocalidade() {
		return localidade;
	}

	public void setLocalidade(LocalidadeDTO localidade) {
		this.localidade = localidade;
	}

	//Para entidade
	public static Endereco toEntity(EnderecoLocalidadeDTO dto, Localidade localidade) {
		return new Endereco(dto, localidade);
		
	}
	
	//Da entidade  
	public static EnderecoLocalidadeDTO fromEntity (Endereco entity) {
		return new EnderecoLocalidadeDTO(
				entity.getId_endereco(),
				entity.getRua(),
				entity.getNumero(),
				entity.getCep(),
				entity.getCidade(),
				entity.getEstado(),
				entity.getLocalidade() != null ? LocalidadeDTO.fromEntity(entity.getLocalidade()): null
				);
	}
	
	//Mapper para utilizar no update 
	public static Endereco mapperDtoToEntity(EnderecoLocalidadeDTO dto, Endereco entity, Localidade localidade) {
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setCep(dto.getCep());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setLocalidade(localidade);
		return entity;
	}
	
}
