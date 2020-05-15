package com.qintess.curso.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.domain.enums.RequestState;
import com.qintess.curso.api.exception.NotFoundException;
import com.qintess.curso.api.repository.RequestRepository;
import com.qintess.curso.api.repository.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository repo;
	
	@Autowired
	private RequestRepository repoRequest;
	
	
	public RequestStage save(RequestStage requestStage) {
		requestStage.setRealizationDate(new Date());
		
		RequestStage createStage = repo.save(requestStage);
		
		Long requestId = requestStage.getId();
		RequestState state = requestStage.getState();
		
		repoRequest.updateStatus(requestId, state);
		
		
		return createStage;
		
	}

	public RequestStage getById(Long id) {
		Optional<RequestStage> result = repo.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Nao existe o ID Informado: " + id));
		
	}
	
	public List<RequestStage> listAllByRequestId(Long id){
		List<RequestStage> lista = repo.findAllByRequestId(id);
		return lista;	
	}

	
}