package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Passport;

public interface Ipassport extends JpaRepository<Passport, String>{

}
