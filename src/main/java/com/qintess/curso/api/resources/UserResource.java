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

import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.dto.UserLoginDto;
import com.qintess.curso.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		User createdUser = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody User user){
		user.setId(id);
		User updateUser = service.update(user);
		return ResponseEntity.ok(updateUser);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") Long id){
		User user = service.getById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> listAll(){
		List<User> users = service.listAll();
		return ResponseEntity.ok(users);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDto user){
		User logged = service.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(logged);
		
	}
	
		

}
