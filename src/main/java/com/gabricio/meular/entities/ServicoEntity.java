package com.gabricio.meular.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicos")
public class ServicoEntity {

	@Id
	private ObjectId id;
	
	@Indexed
	private String descricao;

	private Date dataInclusao;

	public ServicoEntity() {
		super();
	}

	public ServicoEntity(ObjectId id, String descricao, Date dataInclusao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
	}

	public ServicoEntity(String descricao) {
		super();
		this.descricao = descricao;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
