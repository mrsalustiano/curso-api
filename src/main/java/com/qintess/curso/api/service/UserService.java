package com.qintess.curso.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qintess.curso.api.domain.User;
import com.qintess.curso.api.exception.NotFoundException;
import com.qintess.curso.api.model.PageModel;
import com.qintess.curso.api.model.PageRequestModel;
import com.qintess.curso.api.repository.UserRepository;
import com.qintess.curso.api.util.HashUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash); 
		User userSaved = repository.save(user);
		return userSaved;
	}
	

	public User update(User user) {
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User userUpdate = repository.save(user);
		return userUpdate;
	}
	
	public User getById(Long id) {
		Optional<User> result = repository.findById(id);
		
		return result.orElseThrow(() -> new NotFoundException("Nao existe o ID Informado: " + id));
		
	}
	
	public List<User> listAll(){
		List<User> users = repository.findAll();
		return users;
	}
	
	
	public PageModel<User> listAllOnLazzyModel(PageRequestModel model){
		Pageable pageable = PageRequest.of(model.getPage(), model.getSize());
		Page<User> page = repository.findAll(pageable);
		
		PageModel<User> modelPage = new PageModel<User>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		return modelPage;
		
	}
	
	
	public User login(String email, String password) {
		String hash = HashUtil.getSecureHash(password);
				
		Optional<User> result = repository.findByEmailAndPassword(email, hash);
		return result.get();
	}
	
}
