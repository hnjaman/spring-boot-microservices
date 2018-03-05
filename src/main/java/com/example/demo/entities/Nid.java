package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@IdClass(Nid.class)
public class Nid implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private Long id;
	
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
		return "Nid [id=" + id + ", fname=" + fname + ", lname=" + lname + ", nid=" + nid + ", ppid=" + ppid
				+ ", birthdate=" + birthdate + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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
