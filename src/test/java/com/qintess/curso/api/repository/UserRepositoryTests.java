package com.qintess.curso.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.Role;

@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	@Order(1)
	void saveTest() {
	
		User user = new User();
		user.setId(null);
		user.setName("marcelo");
		user.setEmail("email@email.com");
		user.setPassword("1234");
		user.setRole(Role.ADMINISTRATOR);
		user.setRequests(null);
		user.setStages(null);
		User createdUser = repository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(2)
	void updateTest() {
		User user = new User();
		user.setId(1L);
		user.setName("marcelo Silva");
		user.setEmail("email@email.com");
		user.setPassword("1234");
		user.setRole(Role.ADMINISTRATOR);
		user.setRequests(null);
		user.setStages(null);

		User updateUser = repository.save(user);
		
		assertThat(updateUser.getName()).isEqualTo("marcelo Silva");
	}
	
	@Test
	@Order(3)
	void getByIdTest() {
		Optional<User> result = repository.findById(1L);
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("1234");
	}
	
	@Test
	@Order(4)
	void listTest() {
		
		List<User> users = repository.findAll();
		
		assertThat(users.size()).isEqualTo(1);		
	}
	
	@Test
	@Order(5)
	public void loginTest() {
		
		Optional<User> result = repository.findByEmailAndPassword("email@email.com", "1234");
		User loggedUser = result.get();
		assertThat(loggedUser.getId()).isEqualTo(1L);
	}

}

