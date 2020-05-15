package com.qintess.curso.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.RequestState;

@SpringBootTest
public class RequestStageTests {


	@Autowired private RequestStageRepository repository;
	
	@Test
	@Order(1)
	public void SaveTest() {
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request();
		request.setId(1L);
		
		RequestStage stage = new RequestStage();
		stage.setId(null);
		stage.setDescription("Comprado MacBook");
		stage.setRealizationDate( new Date());
		stage.setState(RequestState.CLOSED);
		stage.setOwner(owner);
		stage.setRequest(request);
		
		RequestStage createdStage = repository.save(stage);
		
		
		
		assertThat(createdStage.getId()).isEqualTo(1L);
		
	}
	
	@Test
	@Order(2)
	public void getByIdTest() {
		
		Optional<RequestStage> result = repository.findById(1L);
		RequestStage requestStage = result.get();
		
		assertThat(requestStage.getDescription()).isEqualTo("Comprado MacBook");
		
	}
	
	@Test
	@Order(3)
	public void listByRequestAllTest() {
		
		List<RequestStage> stages = repository.findAll(); 
		assertThat(stages.size()).isEqualTo(1);
	}
	

	@Test
	@Order(4)
	public void listByRequestByIdTest() {
		
		List<RequestStage> stages = repository.findAllByRequestId(1L);
		assertThat(stages.size()).isEqualTo(1);
		
	}
}
