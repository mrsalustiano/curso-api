package com.qintess.curso.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.qintess.curso.api.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_stage")
public class RequestStage implements Serializable {

	private static final long serialVersionUID = 2963345762685544895L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name = "realization_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(length = 20 , nullable = false)
	private RequestState state;
	
	@ManyToOne
	@JoinColumn( name = "request_id" , nullable = false)
	private Request request;
	
	
	@ManyToOne
	@JoinColumn( name = "owner_id" , nullable = false)
	private User owner;
}
