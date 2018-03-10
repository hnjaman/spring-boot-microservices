package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Nid;

public interface Inid extends JpaRepository<Nid, String>{

	Nid findByNid(String nid);

}
