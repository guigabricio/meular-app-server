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

import com.gabricio.meular.dto.ServicoDto;
import com.gabricio.meular.dto.WrapperDto;
import com.gabricio.meular.entities.ServicoEntity;
import com.gabricio.meular.exceptions.MeuLarException;
import com.gabricio.meular.services.ServicoService;

@RestController
@RequestMapping(path = "/servicos")
public class ServicoController {
	
	@Autowired
	WrapperDto wrapperDto;

	@Autowired
	ServicoService servicosService;

	@GetMapping
	public List<ServicoDto> listarServicos() throws MeuLarException {
		List<ServicoEntity> listarServicos = servicosService.listarServicos();
		List<ServicoDto> listaServicosDto = new ArrayList<ServicoDto>();
		listarServicos.forEach(u -> {
			listaServicosDto.add(wrapperDto.getServicoDto(u));
		});
		return listaServicosDto;
	}

	@GetMapping(value = "/{descricao}")
	public ServicoDto getServico(@PathVariable String descricao) throws MeuLarException {
		ServicoEntity servicosEntity = servicosService.getServico(descricao);
		return wrapperDto.getServicoDto(servicosEntity);
	}

	@PostMapping
	public void salvarServico(@RequestBody ServicoDto servicosDto) throws MeuLarException {
		servicosService.salvar(wrapperDto.getServicoEntity(servicosDto));
	}

	@PutMapping
	public void alterarServico(@RequestBody ServicoDto servicosDto) throws MeuLarException {
		servicosService.alterar(wrapperDto.getServicoEntity(servicosDto));
	}
}
