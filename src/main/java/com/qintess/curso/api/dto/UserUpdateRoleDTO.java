package com.qintess.curso.api.dto;

import javax.validation.constraints.NotNull;

import com.qintess.curso.api.domain.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class UserUpdateRoleDTO {
	
	@NotNull(message = "Role não pode ser nulo")
	private Role role;

}
