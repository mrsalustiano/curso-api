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
import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.RequestState;

@SpringBootTest
public class RequestRepositoryTests {

	@Autowired
	private RequestRepository repository;
	

	
	
	@Test
	@Order(1)
	public void saveTest() {
		User user = new User();
		user.setId(1L);
		Request request = new Request(null, "Novo Notebook DELL", "Atualizacao de Note", new Date() , RequestState.OPEN, user, null);

		Request createdRequest = repository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		User user2 = new User();
		user2.setId(1L);
		Request requestUpdate = new Request(1L, "MacBook", "Atualizacao de Note", null , RequestState.OPEN, user2, null);
		Request UpdateRequest = repository.save(requestUpdate);
		
		assertThat(UpdateRequest.getSubject()).isEqualTo("MacBook");
	}
	
	@Test
	@Order(3)
	public void getByIdTest() {
		Optional<Request> result2 = repository.findById(1L);
		Request request2 = result2.get();
		
		assertThat(request2.getSubject()).isEqualTo("MacBook");
	}
	
	@Test
	@Order(4)
	public void listTest() {
		
		List<Request> requests = repository.findAll();
		
		assertThat(requests.size()).isEqualTo(1);		
	}
	
	
	@Test
	@Order(5)
	public void listByOwnerId() {
		
		List<Request> owner = repository.findAllByOwnerId(1L);
		
		assertThat(owner.size()).isEqualTo(1);		
	}


	@Test
	@Order(6)
	public void updateStatusTest() {
		
		int linhasAfetadas = repository.UpdateStatus(1L, RequestState.IN_PROGRESS);
		
		assertThat(linhasAfetadas).isEqualTo(1);		
	}
	
	
	
}

