package com.hnj.contactservice.controller;

import com.hnj.contactservice.Repository.IContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private IContact iContact;

    //-Dserver.port=8000 for custom port running on VM arguments instead of application.yml

    @GetMapping("/contacts/name/{name}")
    public List<Contact> getContacts(@PathVariable String name){
        //return new Contact("01789032651", "hnjaman", "Dhaka");
        //return iContact.findAll();
        List<Contact> contactList = new ArrayList<>();
        contactList=iContact.findByNameContaining(name);
        return contactList;
    }

    @GetMapping("/contacts/all")
    public List<Contact> getAllContacts(){
        return iContact.findAll();
    }

}
