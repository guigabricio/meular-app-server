package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class NenhumServicoCadastradoException extends MeuLarException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.NENHuM_SERVICO_CADASTRADO;
	private static String message = "Nenhum serviço cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public NenhumServicoCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public NenhumServicoCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
