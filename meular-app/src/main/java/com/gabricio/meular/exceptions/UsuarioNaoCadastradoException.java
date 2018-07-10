package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoCadastradoException extends MeuLarException {
	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_NAO_CADASTRADO;
	private static String message = "Usuário não cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioNaoCadastradoException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioNaoCadastradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
