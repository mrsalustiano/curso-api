package com.qintess.curso.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

	@Email(message = "Email Inválido")
	private String email;
	
	@NotBlank(message = "Senha inválida")
	private String password;
}
