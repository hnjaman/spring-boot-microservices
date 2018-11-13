package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.entities.Nid;
import com.example.demo.entities.Passport;
import com.example.demo.entities.User;
import com.example.demo.repositories.Inid;
import com.example.demo.repositories.Ipassport;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
//@RequestMapping("/api")	// #	http://localhost:8888/nids running url
// database console url 	http://localhost:8888/user_db/login.do?jsessionid=a8d9a018c3bff6605469171e773ed030
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Inid inid;
	
	@Autowired
	private Ipassport ipassport;
	
	
	Map<String, String> errors;

	/*
	 ********************************* 		Nid
	 * */
	
	@GetMapping("/nids")
	public List<Nid> getNids(){
		return  inid.findAll();
	}
	@GetMapping("/nids/{nid}")
	public Nid getNid(@PathVariable String nid) {
		return inid.findOne(nid);
	}
	
	@PostMapping("/nid")
	public ResponseEntity<Object> createNid(@RequestBody @Valid Nid newnid, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			errors=new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
		}
		
		Nid n = inid.findByNid(newnid.getNid());
		if(n!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(inid.save(newnid),HttpStatus.OK);
	}
	
	@DeleteMapping("/nids/{nid}")
	public boolean deleteNid(@PathVariable String nid) {
		inid.delete(nid);
		return true;
	}
	
	@PutMapping("/nid")
	public Nid updateNid(@RequestBody Nid newnid) {
		return inid.save(newnid);
	}
	
	
	
	/*
	 ***************************		Passport
	 * */
	
	@GetMapping("/passports")				
	public List<Passport> getPassports(){
		return ipassport.findAll();
	}
	
	@GetMapping("/passports/{ppid}")		
	public Passport getPassport(@PathVariable String ppid) {
		return ipassport.findOne(ppid);
	}
	
	@PostMapping("/passport")				
	public ResponseEntity<Object> createPassport(@RequestBody @Valid Passport newpassport, BindingResult bindingResult) {
		
		if(bindingResult.hasFieldErrors()) {
			errors = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			
			return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
		}
		
		Passport passppid = ipassport.findByPpid(newpassport.getPpid());
		Passport passnid = ipassport.findByNid(newpassport.getNid());
		
		if(passnid != null || passppid != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(ipassport.save(newpassport),HttpStatus.OK);
 		
	}
	
	@DeleteMapping("/passports/{ppid}")		
	public boolean deletePassport(@PathVariable String ppid) {
		ipassport.delete(ppid);
		return true;
	}
	
	@PutMapping("/passport")					
	public Passport updatePassport(@RequestBody Passport newpassport) {
		
		return ipassport.save(newpassport);
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
