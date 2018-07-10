package com.gabricio.meular;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.gabricio.meular.entities.ServicoEntity;
import com.gabricio.meular.exceptions.ServicoJaCadastradoException;
import com.gabricio.meular.services.ServicoService;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ServicoService servicosService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		ServicoEntity servicos = new ServicoEntity();
		servicos.setDescricao("Pedreiro");
		servicos.setDataInclusao(new Date());
		
		try {
			if(!servicosService.existeServico(servicos.getDescricao())){
				servicosService.salvar(servicos);
			}
		} catch (ServicoJaCadastradoException e) {
			e.printStackTrace();
		}
	}
}
