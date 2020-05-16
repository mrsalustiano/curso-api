package com.qintess.curso.api.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.dto.RequestStageSaveDTO;
import com.qintess.curso.api.service.RequestStageService;

@RestController
@RequestMapping(value = "stages")
public class RequestStageResource {

	@Autowired
	private RequestStageService service;
	
	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody @Valid RequestStageSaveDTO requestdto){
		RequestStage requestStage = requestdto.transforToRequestStage();
		RequestStage createdStage = service.save(requestStage);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id){
		RequestStage stage = service.getById(id);
		return ResponseEntity.ok(stage);
	}
	
	
}
