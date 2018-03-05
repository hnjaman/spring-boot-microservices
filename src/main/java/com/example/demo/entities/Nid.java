package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Nid {
    @NotBlank(message="Enter your first name")
    private String fname;
    @NotBlank(message="Enter your last name")
    private String lname;
    @Id
    private String nid;
    @NotBlank(message="Enter your name")
    private String ppid;
    @NotBlank(message="Enter your name")
    private String birthdate;
    
    
    
    
	public Nid(String fname, String lname, String nid, String ppid, String birthdate) {
		this.fname = fname;
		this.lname = lname;
		this.nid = nid;
		this.ppid = ppid;
		this.birthdate = birthdate;
	}
	
	
	
	public Nid() {
		
	}

	
	


	@Override
	public String toString() {
		return "Nid [fname=" + fname + ", lname=" + lname + ", nid=" + nid + ", ppid=" + ppid + ", birthdate="
				+ birthdate + "]";
	}



	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String getNid() {
		return nid;
	}


	public void setNid(String nid) {
		this.nid = nid;
	}
    
	
	
}
