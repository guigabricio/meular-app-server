package com.gabricio.meular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabricio.meular.dto.UsuarioDto;
import com.gabricio.meular.dto.WrapperDto;
import com.gabricio.meular.entities.UsuarioEntity;
import com.gabricio.meular.exceptions.MeuLarException;
import com.gabricio.meular.services.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	
	@Autowired
	WrapperDto wrapperDto;

	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDto> listarUsuarios() throws MeuLarException {
		List<UsuarioEntity> listarUsuarios = usuarioService.listarUsuario();
		List<UsuarioDto> listaUsuarioDto = new ArrayList<UsuarioDto>();
		listarUsuarios.forEach(u -> {
			listaUsuarioDto.add(wrapperDto.getUsuarioDto(u));
		});
		return listaUsuarioDto;
	}

	@GetMapping(value = "/{email}")
	public UsuarioDto getUsuario(@PathVariable String email) throws MeuLarException {
		UsuarioEntity UsuariosEntity = usuarioService.getUsuario(email);
		return wrapperDto.getUsuarioDto(UsuariosEntity);
	}

	@PostMapping
	public void salvarUsuario(@RequestBody UsuarioDto usuarioDto) throws MeuLarException {
		usuarioService.salvar(wrapperDto.getUsuarioEntity(usuarioDto));
	}

	@PutMapping
	public void alterarUsuario(@RequestBody UsuarioDto usuarioDto) throws MeuLarException {
		usuarioService.alterar(wrapperDto.getUsuarioEntity(usuarioDto));
	}
}
