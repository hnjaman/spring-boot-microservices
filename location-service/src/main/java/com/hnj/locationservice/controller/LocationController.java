package com.hnj.locationservice.controller;

import com.hnj.locationservice.entities.IpLocation;
import com.hnj.locationservice.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LocationController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/location")
    public Location getLocation(){
        //return new Location(configuration.getLatitude(), configuration.getLongitude());
        return new Location(20.80, 30.56);
    }

    @GetMapping("/ip/{ip}")
    public IpLocation getUserSms(@PathVariable String ip){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("ip", ip);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<IpLocation> responseEntity = restTemplate.exchange(
                "http://ip-api.com/json/{ip}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<IpLocation>(){},
                uriVariables);

        IpLocation response = responseEntity.getBody();

        return new IpLocation(ip, response.getCountry(),
                response.getRegion(),
                response.getCity());
    }
}
