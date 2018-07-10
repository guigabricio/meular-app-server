package com.gabricio.meular.dto;

import java.util.Calendar;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.gabricio.meular.entities.ServicoEntity;
import com.gabricio.meular.entities.UsuarioEntity;

@Service
public class WrapperDto {

	public ServicoDto getServicoDto(ServicoEntity servicosEntity) {
		return new ServicoDto(servicosEntity.getId().toString(), servicosEntity.getDescricao());
	}

	public ServicoEntity getServicoEntity(ServicoDto servicosDto) {
		return new ServicoEntity(new ObjectId(servicosDto.getId()), servicosDto.getDescricao(),
				Calendar.getInstance().getTime());
	}

	public UsuarioDto getUsuarioDto(UsuarioEntity usuarioEntity) {
		return new UsuarioDto(usuarioEntity.getId().toString(), usuarioEntity.getEmail(), usuarioEntity.getNome(),
				usuarioEntity.getSenha(), usuarioEntity.getTipoDeUsuario());
	}

	public UsuarioEntity getUsuarioEntity(UsuarioDto usuarioDto) {
		return new UsuarioEntity(new ObjectId(usuarioDto.getId()), usuarioDto.getEmail(), usuarioDto.getNome(),
				usuarioDto.getSenha(), usuarioDto.getTipoDeUsuario(), Calendar.getInstance().getTime());
	}

}
