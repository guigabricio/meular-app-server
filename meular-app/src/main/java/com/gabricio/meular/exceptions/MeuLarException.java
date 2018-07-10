package com.gabricio.meular.exceptions;

import org.springframework.http.HttpStatus;

public abstract class MeuLarException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private HttpStatus status;
	private String path;

	public MeuLarException(String message, Throwable cause, int errorCode, HttpStatus status, String path) {
		super(message, cause);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public MeuLarException(String message, int errorCode, HttpStatus status, String path) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public MeuLarException(Throwable cause, int errorCode, HttpStatus status, String path) {
		super(cause);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public MeuLarException(String message, HttpStatus status, String path) {
		super(message);
		this.status = status;
		this.path = path;
	}

}
