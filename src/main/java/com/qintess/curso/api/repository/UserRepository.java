package com.qintess.curso.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.domain.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	public Optional<User> findByEmailAndPassword(String email, String password);
	
	@Transactional(readOnly = false)
	@Modifying(flushAutomatically = true)
	@Query("UPDATE User SET role = ?2 where id = ?1 ")
	public int updateRole(Long id, Role role);
	

	
}
