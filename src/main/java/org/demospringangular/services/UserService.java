package org.demospringangular.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.demospringangular.entities.User;
import org.demospringangular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@Service
@Transactional
public class UserService {
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 60;
	 @Autowired
	 UserRepository repository;
		

	 @Autowired
	 private JavaMailSender mailSender;
	 
		public List<User> getAll() {
			System.out.println("Get all Users 11111...");
	    	return repository.findAll(Sort.by("username").ascending());	    	
	    }
		
	    public Optional<User> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(User User) {
	    	System.out.println("save  all Users 11111...");
	          return repository.save(User)
		                             .getId();	    	
	    }
	    

	    
	
	    public Optional<User> login(String name) {
	    	System.out.println(name);
	        return repository.findByUsername(name);
	    }

	    public void delete(long id) {
	        Optional<User> user = repository.findById(id);
	        user.ifPresent(repository::delete);
	    }
	    
	    
	   
		public Optional <User> findUserByEmail(String email) {
			return repository.findByEmail(email);
		}

		

		@Async
		public void sendEmail(SimpleMailMessage email) {
			mailSender.send(email);
		}
}