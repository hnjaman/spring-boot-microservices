package com.hnj.smsservice.controller;

import com.hnj.smsservice.entities.Sms;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "contact-service", url = "localhost:8555")
public interface IContactServiceProxy {
    @GetMapping("/contacts-feign/name/{name}/sms")
    Sms getUserSms(@PathVariable("name") String name);
}
