package com.hnj.smsservice.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.hnj.smsservice.entities.Sms;
import com.hnj.smsservice.repositories.ISmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class SmsController {	// # running url->	http://localhost:8999/sms

	@Autowired
	private ISmsRepository iSmsRepository;
	
	Map<String, String> errors;

	/*
	 * 		sms service
	 * */

	@GetMapping("/sms")
    public List<Sms> getSms(){
	    return iSmsRepository.findAll();
    }

}
