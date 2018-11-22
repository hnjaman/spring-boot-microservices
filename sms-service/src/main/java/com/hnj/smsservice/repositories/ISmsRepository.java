package com.hnj.smsservice.repositories;

import com.hnj.smsservice.entities.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmsRepository  extends JpaRepository<Sms, Integer>{
    //Sms findByid(Integer id);
}
