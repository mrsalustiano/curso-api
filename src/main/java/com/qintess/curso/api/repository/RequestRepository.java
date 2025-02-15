package com.qintess.curso.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	
	public Page<Request> findAllByOwnerId(Long id, Pageable pageable);
	
	@Transactional(readOnly = false) 
	@Modifying 
	@Query("UPDATE Request r SET r.state = ?2 WHERE r.id = ?1") 
	public int updateStatus(Long id, RequestState state);
 
} 
