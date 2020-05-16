package com.qintess.curso.api.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestModel implements Serializable {

	private static final long serialVersionUID = -6966425935520533650L;

	private int page;
	private int size;
	
}
