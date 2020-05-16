package com.qintess.curso.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.model.PageModel;
import com.qintess.curso.api.model.PageRequestModel;
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
	public ResponseEntity<PageModel<Request>> listAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size){
		
		PageRequestModel model = new PageRequestModel(page, size);
		PageModel<Request> modelPage = service.listAllOnLazzyModel(model);
		
		return ResponseEntity.ok(modelPage);
	}
	
	
	@GetMapping("{id}/stages")
	public ResponseEntity<PageModel<RequestStage>> listAllRequestsById(@PathVariable(name = "id") Long id,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size
			){
		
		PageRequestModel model = new PageRequestModel(page, size);
		
		PageModel<RequestStage> modelPage = srvStage.listAllByRequestIdLazzyModel(id, model);
		
		return ResponseEntity.ok(modelPage);
	}
	
}
