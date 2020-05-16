package com.qintess.curso.api.dto;

import com.qintess.curso.api.domain.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class UserUpdateRoleDTO {
	
	private Role role;

}
