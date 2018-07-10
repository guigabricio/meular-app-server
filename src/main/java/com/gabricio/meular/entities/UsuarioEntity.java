package com.gabricio.meular.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicos")
public class UsuarioEntity {

	@Id
	private ObjectId id;
	
	@Indexed
	private String email;
	private String nome;
	private String senha;
	private TipoDeUsuario tipoDeUsuario;

	private Date dataInclusao;

	public UsuarioEntity(ObjectId id, String email, String nome, String senha, TipoDeUsuario tipoDeUsuario,
			Date dataInclusao) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.tipoDeUsuario = tipoDeUsuario;
		this.dataInclusao = dataInclusao;
	}

	public UsuarioEntity() {
		super();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
