package com.lucasfranca.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasfranca.workshopmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
