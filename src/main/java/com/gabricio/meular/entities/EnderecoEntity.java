package com.gabricio.meular.entities;

public class EnderecoEntity {

	private String cep;
	private String complemento;
	private String numero;
	private String bairro;

	public EnderecoEntity(String cep, String complemento, String numero, String bairro) {
		super();
		this.cep = cep;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
