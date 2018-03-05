package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Passport {

	 @NotBlank(message="Enter your first name")
	    private String fname;
	    @NotBlank(message="Enter your last name")
	    private String lname;
	    @NotBlank(message="Enter your email")
	    @Id
	    @Email(message="Enter a valid mail")
	    private String email;
	    @Id
	    private String nid;
	    @NotBlank(message="Enter your name")
	    private String ppid;
	    @NotBlank(message="Enter your name")
	    private String birthdate;
	    
	    
	    
	    
	    
		@Override
		public String toString() {
			return "Passport [fname=" + fname + ", lname=" + lname + ", email=" + email + ", nid=" + nid + ", ppid="
					+ ppid + ", birthdate=" + birthdate + "]";
		}
		public Passport() {
			
		}
	
		
		
		
		public Passport(String fname, String lname, String email, String nid, String ppid, String birthdate) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.nid = nid;
			this.ppid = ppid;
			this.birthdate = birthdate;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
