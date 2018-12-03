package com.hnj.contactservice;

import com.hnj.contactservice.Repository.IContact;
import com.hnj.contactservice.controller.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactServiceApplication implements CommandLineRunner {

    @Autowired
    private IContact iContact;

    @Override
    public void run(String... args) throws Exception {
        iContact.save( new Contact("01789032651","hnjaman", "dhaka"));
        iContact.save( new Contact("01521238635","hnjsujon", "jhenaidah"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactServiceApplication.class, args);
    }
}
