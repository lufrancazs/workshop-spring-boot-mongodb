package com.lucasfranca.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasfranca.workshopmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
