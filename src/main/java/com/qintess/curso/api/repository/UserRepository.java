package com.qintess.curso.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.curso.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	public Optional<User> findByEmailAndPassword(String email, String password);

	
}
