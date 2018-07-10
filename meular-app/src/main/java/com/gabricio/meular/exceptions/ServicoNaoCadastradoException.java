package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class ServicoNaoCadastradoException extends MeuLarException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.SERVICO_NAO_CADASTRADO;
	private static String message = "Serviço não cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ServicoNaoCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public ServicoNaoCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
