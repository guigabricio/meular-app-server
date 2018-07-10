package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioJaCadastradoException extends MeuLarException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_JA_CADASTRADO;
	private static String message = "Usuário já cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioJaCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioJaCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
