package com.qintess.curso.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.RequestStage;
import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateDTO {

	@NotBlank
	private String subject;
	
	private String description;
	
	@NotNull
	private RequestState state;
	
	@NotNull
	private User owner;
	
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public Request transformToRequestUpdate() {
		Request requestSave = new Request();
		requestSave.setOwner(this.owner);
		requestSave.setSubject(this.subject);
		requestSave.setDescription(this.description);
		requestSave.setStages(this.stages);
		requestSave.setState(this.state);
		
		return requestSave;
				
	}
	
}
