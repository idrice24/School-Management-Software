package org.idrice24.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.Date;

@Entity
public class Contact{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="email")
	private String email;

	@Column(name="name")
	private String name;

	@Column(name="message")
	private String message;

	public Contact(String email, String message, String name){
		this.email = email;
		this.name = name;
		this.message = message;
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
	 public void setMessage(String message){
	 	thismessage = message;
	 }

	 public String getMessage(){
	 	return message;
	 }

	 public void setId(long Id){
	 	this.id= id;
	 }

	 public long getId(){
	 	return id;
	 }

}