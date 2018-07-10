package com.gabricio.meular.dto;

public class ServicoDto {

	private String id;
	private String descricao;

	public ServicoDto(String id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public ServicoDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
