package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="CONTACTS")
public class Contact
{
	 @Id
	 @GeneratedValue
	 private int id;
	 private String firstname;
	 private String lastname;
	 private String emailid;
	 	
	public Contact() {

	}
	public Contact(String firstname,String lastname ,String email) {
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.emailid=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid=" + emailid
				+ "]";
	}
	
}