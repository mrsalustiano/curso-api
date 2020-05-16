package com.qintess.curso.api.resources.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qintess.curso.api.exception.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionError> handlerNotFoundException(NotFoundException ex){
		ExceptionError error = new ExceptionError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		List<String> erros = new ArrayList<String>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			erros.add(error.getDefaultMessage());
		} );

		String defaultMessage = "Campo(s) Invalido(s)";
		
		ExceptionErrorList error = new ExceptionErrorList(HttpStatus.BAD_REQUEST.value(), defaultMessage, new Date(), erros);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	
	
	
	
	
	
}
