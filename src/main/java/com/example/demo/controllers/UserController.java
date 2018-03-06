package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Nid;
import com.example.demo.entities.Passport;
import com.example.demo.entities.User;
import com.example.demo.repositories.Inid;
import com.example.demo.repositories.Ipassport;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Inid nid;
	
	@Autowired
	private Ipassport passport;
	
	

/*
 * 		Nid
 * */
	
	@GetMapping("/nids")
	public List<Nid> getNids(){
		return  nid.findAll();
	}
	@GetMapping("/nids/{id}")
	public Nid getNid(@PathVariable Long id) {
		return nid.findOne(id);
	}
	
	@PostMapping("/nid")
	public Nid createNid(@RequestBody Nid newnid) {
		return nid.save(newnid);
	}
	
	@DeleteMapping("/nids/{id}")
	public boolean deleteNid(@PathVariable Long id) {
		nid.delete(id);
		return true;
	}
	
	@PutMapping("/nid")
	public Nid updateNid(@RequestBody Nid newnid) {
		return nid.save(newnid);
	}
	
	
	
/*
 * 		Passport
 * */
	
	@GetMapping("/passports")
	public List<Passport> getPasswords(){
		return passport.findAll();
	}
	
	@GetMapping("/passports/{id}")
	public Passport getPassport(@PathVariable Long id) {
		return passport.findOne(id);
	}
	
	@PostMapping("/passport")
	public Passport createPassport(@RequestBody Passport newpassport) {
		return passport.save(newpassport);
	}
	
	@DeleteMapping("/passports/{id}")
	public boolean deletePassport(@PathVariable Long id) {
		passport.delete(id);
		return true;
	}
	
	@PutMapping("/passport")
	public Passport updatePassport(@RequestBody Passport newpassport) {
		return passport.save(newpassport);
	}
	
	

/*
 * 		User
 * */
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.delete(id);
		return true;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
