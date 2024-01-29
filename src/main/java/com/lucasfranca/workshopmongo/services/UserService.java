package com.lucasfranca.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasfranca.workshopmongo.entities.User;
import com.lucasfranca.workshopmongo.repositories.UserRepository;
import com.lucasfranca.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findyById(String id) {
		Optional<User> user = repository.findById(id);		
		return user.orElseThrow( () -> new ObjectNotFoundException(id));
	}
}
