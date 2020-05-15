package com.qintess.curso.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.service.RequestService;
import com.qintess.curso.api.service.RequestStageService;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

	@Autowired
	private RequestService service;
	
	@Autowired
	private RequestStageService srvStage;
	
	@PostMapping
	public ResponseEntity<Request> save(@RequestBody Request request){
		Request createdRequest = service.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Request> update(@PathVariable(name = "id") Long id, @RequestBody Request request){
		request.setId(id);
		Request updateRequest = service.update(request);
		return ResponseEntity.ok(updateRequest);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
		Request request = service.getById(id);
		return ResponseEntity.ok(request);
	}
	
	@GetMapping
	public ResponseEntity<List<Request>> listAll(){
		List<Request> requests = service.listAll();
		return ResponseEntity.ok(requests);
	}
	
	@GetMapping("{id}/stages")
	public ResponseEntity<List<RequestStage>> listAllRequestsById(@PathVariable(name = "id") Long id){
		List<RequestStage> requestStages = srvStage.listAllByRequestId(id);
		return ResponseEntity.ok(requestStages);
	}
	
}
