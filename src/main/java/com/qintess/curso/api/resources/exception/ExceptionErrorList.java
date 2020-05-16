package com.qintess.curso.api.resources.exception;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class ExceptionErrorList extends ExceptionError {

	private static final long serialVersionUID = -3269663841092915084L;
	

	private List<String> errors;

	public ExceptionErrorList(int code, String msg, Date data , List<String> errors) {
		super(code, msg, data);
		this.errors = errors;
	}
}
