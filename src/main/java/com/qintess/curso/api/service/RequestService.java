package com.qintess.curso.api.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.enums.RequestState;
import com.qintess.curso.api.repository.RequestRepository;

@Service
public class RequestService {

	private RequestRepository repository;
	
	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCreationDate(new Date());
		
		Request savedRequest = repository.save(request);
		return savedRequest;
	}
	
	public Request update(Request request) {
		Request updateRequest = repository.save(request);
		return updateRequest;
	}
	
	
	
	
}
