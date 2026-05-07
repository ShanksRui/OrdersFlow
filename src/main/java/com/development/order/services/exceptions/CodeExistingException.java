package com.development.order.services.exceptions;

public class CodeExistingException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CodeExistingException(String msg) {
		super(msg);
	}
}
