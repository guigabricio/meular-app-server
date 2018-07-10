package com.gabricio.meular.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabricio.meular.entities.ServicoEntity;
import com.gabricio.meular.entities.UsuarioEntity;
import com.gabricio.meular.exceptions.CampoObrigatorioNaoInformadoException;
import com.gabricio.meular.exceptions.NenhumServicoCadastradoException;
import com.gabricio.meular.exceptions.ServicoJaCadastradoException;
import com.gabricio.meular.exceptions.ServicoNaoCadastradoException;
import com.gabricio.meular.repositories.ServicoRepository;
import com.gabricio.meular.util.Texto;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicosRepository;

	public List<ServicoEntity> listarServicos() throws NenhumServicoCadastradoException {
		List<ServicoEntity> listaServicos = servicosRepository.findAll();
		if (listaServicos.isEmpty()) {
			throw new NenhumServicoCadastradoException("servicos");
		}
		return listaServicos;
	}

	public ServicoEntity getServico(String descricao) throws ServicoNaoCadastradoException {
		Optional<ServicoEntity> servico = servicosRepository.findByDescricao(descricao);
		if (!servico.isPresent()) {
			throw new ServicoNaoCadastradoException("servicos.descricao");
		}
		return servico.get();
	}

	public ServicoEntity getServico(ObjectId id) throws ServicoNaoCadastradoException {
		Optional<ServicoEntity> servico = servicosRepository.findById(id);
		if (!servico.isPresent()) {
			throw new ServicoNaoCadastradoException("servicos.id");
		}
		return servico.get();
	}

	public boolean existeServico(String descricao) {
		return servicosRepository.existsByDescricao(descricao);
	}

	public boolean existeServico(ObjectId id) {
		return servicosRepository.existsById(id);
	}

	public void salvar(ServicoEntity servicosEntity) throws ServicoJaCadastradoException {
		if (existeServico(servicosEntity.getDescricao())) {
			throw new ServicoJaCadastradoException("servicos.descricao");
		}
		servicosRepository.save(servicosEntity);
	};

	public void alterar(ServicoEntity servicosEntity) throws ServicoNaoCadastradoException {
		if (!existeServico(servicosEntity.getId())) {
			throw new ServicoNaoCadastradoException("servicos.descricao");
		}
		servicosRepository.save(servicosEntity);
	};
}
