package com.example.demo;

import com.example.demo.entities.Nid;
import com.example.demo.entities.Passport;
import com.example.demo.entities.User;
import com.example.demo.repositories.Inid;
import com.example.demo.repositories.Ipassport;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudbootangApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Ipassport passport;
	@Autowired
	private Inid nid;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudbootangApplication.class, args);
	}
//test commit
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("ABC", "XYZ"));
		
		passport.save(new Passport("dilip","kumar","dilip@gmail.com","123456789012345","asdfg123","20-12-1988"));
		
		nid.save(new Nid("dilip","kumar","444456789012345","444fg123","02-12-1988"));
		
	}
}
