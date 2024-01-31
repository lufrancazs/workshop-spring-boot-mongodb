package com.lucasfranca.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasfranca.workshopmongo.dto.AuthorDTO;
import com.lucasfranca.workshopmongo.dto.CommentDTO;
import com.lucasfranca.workshopmongo.entities.Post;
import com.lucasfranca.workshopmongo.entities.User;
import com.lucasfranca.workshopmongo.repositories.PostRepository;
import com.lucasfranca.workshopmongo.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
	

	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.parse("2019-07-17T15:21:22Z"), "Partiu Viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
		Post post2= new Post(null, Instant.parse("2019-07-22T09:45:22Z"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		CommentDTO c1 = new CommentDTO("Boa Viagem mano!", Instant.parse("2019-07-18T09:21:22Z"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", Instant.parse("2019-07-19T09:21:22Z"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2019-07-22T10:21:22Z"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
