package com.qintess.curso.api.dto;

import javax.validation.constraints.NotNull;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestStageSaveDTO {

	
	private String description;
	
	@NotNull
	private RequestState state;
	
	@NotNull
	private Request request;
	
	@NotNull
	private User owner;
	
	
	
	public RequestStage transforToRequestStage() {
		RequestStage stage = new RequestStage();
		
		stage.setDescription(this.description);
		stage.setOwner(this.owner);
		stage.setState(this.state);
		stage.setRequest(this.request);
		
		return stage;
		
		
	}
}
