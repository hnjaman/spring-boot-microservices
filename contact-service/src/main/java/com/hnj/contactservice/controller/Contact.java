package com.hnj.contactservice.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Contact implements Serializable {

    @Id
    @Column
    @NotNull
    private String contact_num;
    @Column
    @NotNull
    private String name;
    @Column
    private String address;


    public Contact() {
    }

    public Contact(String contact_num, String name, String address) {
        this.contact_num = contact_num;
        this.name = name;
        this.address = address;
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(String contact_num) {
        this.contact_num = contact_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
