package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class NenhumUsuarioCadastradoException extends MeuLarException {
	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.NENHUM_USUARIO_CADASTRADO;
	private static String message = "Nenhum usuário cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public NenhumUsuarioCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public NenhumUsuarioCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
