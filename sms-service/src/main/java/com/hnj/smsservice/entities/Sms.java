package com.hnj.smsservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Sms implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String name;

    @NotNull
    private String contact_num;

	@NotNull
   // @Size(min=20,max=160,message="Message length must be between 20 and 160")
	private String message;

	@NotNull
	private String date;

    public Sms() {
		
	}

    public Sms(@NotNull String name, @NotNull String contact_num, @NotNull String message, @NotNull String date) {
        this.name = name;
        this.contact_num = contact_num;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
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
