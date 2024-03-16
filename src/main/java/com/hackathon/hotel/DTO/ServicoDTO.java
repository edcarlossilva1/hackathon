package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Servico;

public class ServicoDTO {

	private Long id_servico;
	private String descricao;
	private double valor;
	private boolean sn_por_pessoa;
	
	public ServicoDTO() {
	}

	public ServicoDTO(Long id_servico, String descricao, double valor, boolean sn_por_pessoa) {
		this.id_servico = id_servico;
		this.descricao = descricao;
		this.valor = valor;
		this.sn_por_pessoa = sn_por_pessoa;
	}
	
	public ServicoDTO(Servico entity) {
		this.id_servico = entity.getId_servico();
		this.descricao = entity.getDescricao();
		this.valor = entity.getValor();
		this.sn_por_pessoa = entity.isSn_por_pessoa();
				}

	public Long getId_servico() {
		return id_servico;
	}

	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isSn_por_pessoa() {
		return sn_por_pessoa;
	}

	public void setSn_por_pessoa(boolean sn_por_pessoa) {
		this.sn_por_pessoa = sn_por_pessoa;
	}

	

	public static Servico toEntity(ServicoDTO dto) {
		return new Servico(dto);
		
	}
	
	//Da entidade  
	public static ServicoDTO fromEntity (Servico entity) {
		return new ServicoDTO(
				entity.getId_servico(),
				entity.getDescricao(),
				entity.getValor(),
				entity.isSn_por_pessoa()
				);
	}
	
	//Mapper para utilizar no update 
	public static Servico mapperDtoToEntity(ServicoDTO dto, Servico entity) {
		entity.setId_servico(dto.getId_servico());
		entity.setDescricao(dto.getDescricao());
		entity.setValor(dto.getValor());
		entity.setSn_por_pessoa(dto.isSn_por_pessoa());
		return entity;
	}
	
	
}
