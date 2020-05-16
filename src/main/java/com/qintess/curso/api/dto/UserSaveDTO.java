package com.qintess.curso.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDTO {

	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@Size(min =  7, max = 99, message = "Senha deve ter no minimo {min} caracteres")
	private String password;
	
	@NotNull
	private Role role;
	
	private List<Request> requests = new ArrayList<Request>();
	
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public User tranformToUser() {
		User user = new User();
		
		user.setEmail(this.email);
		user.setName(this.name);
		user.setPassword(this.password);
		user.setRequests(this.requests);
		user.setRole(this.role);
		user.setStages(this.stages);
		
		return user;
	
	}
}
