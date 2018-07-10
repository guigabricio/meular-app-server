package com.gabricio.meular.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabricio.meular.entities.TipoDeUsuario;
import com.gabricio.meular.entities.UsuarioEntity;
import com.gabricio.meular.exceptions.CampoObrigatorioNaoInformadoException;
import com.gabricio.meular.exceptions.NenhumUsuarioCadastradoException;
import com.gabricio.meular.exceptions.UsuarioJaCadastradoException;
import com.gabricio.meular.exceptions.UsuarioNaoCadastradoException;
import com.gabricio.meular.repositories.UsuarioRepository;
import com.gabricio.meular.util.Texto;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioEntity> listarUsuario() throws NenhumUsuarioCadastradoException {
		List<UsuarioEntity> listaUsuario = usuarioRepository.findAll();
		if (listaUsuario.isEmpty()) {
			throw new NenhumUsuarioCadastradoException("usuario");
		}
		return listaUsuario;
	}

	public UsuarioEntity getUsuario(String email) throws UsuarioNaoCadastradoException {
		Optional<UsuarioEntity> usuario = usuarioRepository.findByEmail(email);
		if (!usuario.isPresent()) {
			throw new UsuarioNaoCadastradoException("usuario.email");
		}
		return usuario.get();
	}

	public UsuarioEntity getUsuario(ObjectId id) throws UsuarioNaoCadastradoException {
		Optional<UsuarioEntity> Usuario = usuarioRepository.findById(id);
		if (!Usuario.isPresent()) {
			throw new UsuarioNaoCadastradoException("usuario.id");
		}
		return Usuario.get();
	}

	public boolean existeUsuario(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public boolean existeUsuario(ObjectId id) {
		return usuarioRepository.existsById(id);
	}

	public void salvar(UsuarioEntity UsuarioEntity) throws UsuarioJaCadastradoException, CampoObrigatorioNaoInformadoException {
		if (existeUsuario(UsuarioEntity.getEmail())) {
			throw new UsuarioJaCadastradoException("usuario.email");
		}
		validarCampos(UsuarioEntity);
		usuarioRepository.save(UsuarioEntity);
	};

	public void alterar(UsuarioEntity UsuarioEntity) throws UsuarioNaoCadastradoException, CampoObrigatorioNaoInformadoException {
		if (!existeUsuario(UsuarioEntity.getId())) {
			throw new UsuarioNaoCadastradoException("usuario.id");
		}
		validarCampos(UsuarioEntity);
		usuarioRepository.save(UsuarioEntity);
	};
	
	private void validarCampos(UsuarioEntity usuarioEntity) throws CampoObrigatorioNaoInformadoException {
		if(Texto.ehVazio(usuarioEntity.getEmail())) {
			throw new CampoObrigatorioNaoInformadoException("usuario.email");
		}
		if(Texto.ehVazio(usuarioEntity.getNome())) {
			throw new CampoObrigatorioNaoInformadoException("usuario.nome");
		}
		if(Texto.ehVazio(usuarioEntity.getSenha())) {
			throw new CampoObrigatorioNaoInformadoException("usuario.senha");
		}
		if(Texto.ehVazio(usuarioEntity.getTipoDeUsuario().toString())) {
			throw new CampoObrigatorioNaoInformadoException("usuario.tipoDeUsuario");
		}
	}
}
