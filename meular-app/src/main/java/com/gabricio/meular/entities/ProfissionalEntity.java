package com.gabricio.meular.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profissionais")
public class ProfissionalEntity {

	@Id
	private ObjectId id;

	private ObjectId idUsuario;

	@Indexed
	private String email;

	@Indexed
	private String nome;

	private List<CidadeEntity> locaisDeTrabalho;

	private List<ServicoEntity> servicosPrestados;
	private List<ContatoEntity> contatos;

	private EnderecoEntity endereco;

	public ProfissionalEntity(ObjectId id, ObjectId idUsuario, String email, String nome,
			List<CidadeEntity> locaisDeTrabalho, List<ServicoEntity> servicosPrestados, List<ContatoEntity> contatos,
			EnderecoEntity endereco) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.email = email;
		this.nome = nome;
		this.locaisDeTrabalho = locaisDeTrabalho;
		this.servicosPrestados = servicosPrestados;
		this.contatos = contatos;
		this.endereco = endereco;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(ObjectId idUsuario) {
		this.idUsuario = idUsuario;
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

	public List<CidadeEntity> getLocaisDeTrabalho() {
		return locaisDeTrabalho;
	}

	public void setLocaisDeTrabalho(List<CidadeEntity> locaisDeTrabalho) {
		this.locaisDeTrabalho = locaisDeTrabalho;
	}

	public List<ServicoEntity> getServicosPrestados() {
		return servicosPrestados;
	}

	public void setServicosPrestados(List<ServicoEntity> servicosPrestados) {
		this.servicosPrestados = servicosPrestados;
	}

	public List<ContatoEntity> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoEntity> contatos) {
		this.contatos = contatos;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

}
