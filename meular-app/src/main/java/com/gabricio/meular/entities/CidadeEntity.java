package com.gabricio.meular.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cidades")
public class CidadeEntity {

	@Id
	private ObjectId id;

	@Indexed
	private String estado;

	@Indexed
	private String cidade;

	public CidadeEntity(ObjectId id, String estado, String cidade) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
