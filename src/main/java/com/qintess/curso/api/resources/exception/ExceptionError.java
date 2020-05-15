package com.qintess.curso.api.resources.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionError implements Serializable{

	private static final long serialVersionUID = 7386413629597579945L;

	private int code;
	private String msg;
	private Date data;

	
}
