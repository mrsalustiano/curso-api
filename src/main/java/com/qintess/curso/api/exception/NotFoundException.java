package com.qintess.curso.api.exception;


public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1643146755891212347L;

	public NotFoundException(String msg) {
		super(msg);
	}
	
}
