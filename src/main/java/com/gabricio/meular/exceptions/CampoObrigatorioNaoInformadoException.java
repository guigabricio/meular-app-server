package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public class CampoObrigatorioNaoInformadoException extends MeuLarException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.CAMPO_OBRIGATORIO_NAO_INFORMADO;
	private static String message = "Campo obrigatório naão informado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public CampoObrigatorioNaoInformadoException(String path) {
		super(message, errorCode, status, path);
	}

	public CampoObrigatorioNaoInformadoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}
}
