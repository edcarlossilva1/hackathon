package com.hackathon.hotel.DTO;

import com.hackathon.hotel.entities.Quarto;

public class QuartoDTO {

	private Long id_quarto;
	private String tipo;
	private int total_pessoa;
	private int total_cama;
	private String banheiro;
	private double valor_diaria;
	private int quantidade_quartos;
	private boolean disponivel;

	public QuartoDTO() {

	}

	public QuartoDTO(Long id_quarto, String tipo, int total_pessoa, int total_cama, String banheiro,
			double valor_diaria, int quantidade_quartos, boolean disponivel) {
		this.id_quarto = id_quarto;
		this.tipo = tipo;
		this.total_pessoa = total_pessoa;
		this.total_cama = total_cama;
		this.banheiro = banheiro;
		this.valor_diaria = valor_diaria;
		this.quantidade_quartos = quantidade_quartos;
		this.disponivel = disponivel;
	}

	public QuartoDTO(Quarto entity) {
		this.id_quarto = entity.getId_quarto();
		this.tipo = entity.getTipo();
		this.total_pessoa = entity.getTotal_pessoa();
		this.total_cama = entity.getTotal_cama();
		this.banheiro = entity.getBanheiro();
		this.valor_diaria = entity.getValor_diaria();
		this.quantidade_quartos = entity.getQuantidade_quartos();
		this.disponivel = entity.isDisponivel();
	}

	public Long getId_quarto() {
		return id_quarto;
	}

	public void setId_quarto(Long id_quarto) {
		this.id_quarto = id_quarto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTotal_pessoa() {
		return total_pessoa;
	}

	public void setTotal_pessoa(int total_pessoa) {
		this.total_pessoa = total_pessoa;
	}

	public int getTotal_cama() {
		return total_cama;
	}

	public void setTotal_cama(int total_cama) {
		this.total_cama = total_cama;
	}

	public String getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(String banheiro) {
		this.banheiro = banheiro;
	}

	public double getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(double valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public int getQuantidade_quartos() {
		return quantidade_quartos;
	}

	public void setQuantidade_quartos(int quantidade_quartos) {
		this.quantidade_quartos = quantidade_quartos;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	// Para entidade
	public static Quarto toEntity(QuartoDTO dto) {
		return new Quarto(dto);

	}

	// Da entidade
	public static QuartoDTO fromEntity(Quarto entity) {
		return new QuartoDTO(entity.getId_quarto(), entity.getTipo(), entity.getTotal_pessoa(), entity.getTotal_cama(),
				entity.getBanheiro(), entity.getValor_diaria(), entity.getQuantidade_quartos(), entity.isDisponivel());
	}

	// Mapper para utilizar no update
	public static Quarto mapperDtoToEntity(QuartoDTO dto, Quarto entity) {
		entity.setTipo(dto.getTipo());
		entity.setTotal_pessoa(dto.getTotal_pessoa());
		entity.setTotal_cama(dto.getTotal_cama());
		entity.setBanheiro(dto.getBanheiro());
		entity.setValor_diaria(dto.getValor_diaria());
		entity.setQuantidade_quartos(dto.getQuantidade_quartos());
		entity.setDisponivel(dto.isDisponivel());
		return entity;
	}

}
