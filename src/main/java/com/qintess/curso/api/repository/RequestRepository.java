package com.qintess.curso.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.enums.RequestState;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	@Transactional(readOnly = true)
	public List<Request> findAllByOwnerId(Long id);
	
	@Transactional(readOnly =  false)
	@Modifying
	@Query("update Request set state = ?2 where id = ?1 ")
	public  int UpdateStatus(Long id, RequestState state);
	
 
} 
