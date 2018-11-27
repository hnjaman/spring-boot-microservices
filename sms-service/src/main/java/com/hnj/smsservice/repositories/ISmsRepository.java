package com.hnj.smsservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.hnj.smsservice.entities.Sms;

public interface ISmsRepository  extends JpaRepository<Sms, Integer> {
    Sms findByid(Integer id);
}
