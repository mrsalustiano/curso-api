package com.qintess.curso.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qintess.curso.api.domain.Request;
import com.qintess.curso.api.domain.enums.RequestState;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	
	public List<Request> findAllByOwnerId(Long id);
	
	@Query("update Request set state = ?2 where id = ?1 ")
	public Request UpdateStatus(Long id, RequestState state);
	

}
