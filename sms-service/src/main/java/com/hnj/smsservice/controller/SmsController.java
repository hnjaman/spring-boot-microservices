package com.hnj.smsservice.controller;


import com.hnj.smsservice.entities.Sms;
import com.hnj.smsservice.repositories.ISmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class SmsController {	// # running url->	http://localhost:8999/sms

	@Autowired
	private ISmsRepository iSmsRepository;

	@GetMapping("/sms")
    public List<Sms> getSms(){
	    return iSmsRepository.findAll();
    }

    @GetMapping("/contacts/name/{name}/sms")
	public Sms getUserSms(@PathVariable String name){

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("name", name);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Sms> responseEntity = restTemplate.exchange(
				"http://localhost:8555/contacts/name/{name}",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Sms>(){},
				uriVariables);

		Sms response = responseEntity.getBody();

		return new Sms(response.getName(), response.getContact_num(),
				"Hello "+response.getName()+", we would like to thank you for staying with us",
				"02/12/2018");
	}
}
