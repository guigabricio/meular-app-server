package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class ServicoJaCadastradoException extends MeuLarException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.SERVICO_JA_CADASTRADO;
	private static String message = "Serviço já cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ServicoJaCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public ServicoJaCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
