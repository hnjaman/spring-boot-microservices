package com.hnj.smsservice.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
@Entity
//@Table(name="sms")
public class Sms implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	//@NotBlank(message="Message can't be empty")
    @Size(min=20,max=160,message="Message length must be between 20 and 160")
	private String message;

	//@NotBlank(message="Enter your Date of Birth")
	private String date;

	//private String mobile_number;
    
	public Sms(String message, String date) {
		this.message = message;
		this.date = date;
	}

//    public Sms(String message, String date, String mobile_number) {
//        this.message = message;
//        this.date = date;
//        this.mobile_number = mobile_number;
//    }

	
	public Sms() {
		
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
