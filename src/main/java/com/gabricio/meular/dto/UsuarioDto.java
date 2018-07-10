package com.gabricio.meular.dto;

import com.gabricio.meular.entities.TipoDeUsuario;

public class UsuarioDto {

	private String id;
	private String email;
	private String nome;
	private String senha;
	private TipoDeUsuario tipoDeUsuario;

	public UsuarioDto() {
		super();
	}

	public UsuarioDto(String id, String email, String nome, String senha, TipoDeUsuario tipoDeUsuario) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

}
