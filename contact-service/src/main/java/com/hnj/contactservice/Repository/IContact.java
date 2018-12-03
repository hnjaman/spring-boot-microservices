package com.hnj.contactservice.Repository;

import com.hnj.contactservice.controller.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContact extends JpaRepository<Contact,String> {
//    @Query("SELECT all FROM Contact WHERE name LIKE %?1%")
//    List<Contact> findByName(String name);
    List<Contact> findByNameContaining(String name);
    Contact findByName(String name);
}
