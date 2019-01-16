package com.sep.sep.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class RegUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String city;
	private String country;
	private String title;
	private boolean active;
	
	

	
	
	
	
	
	
	public RegUser(Long id, String username, String email, String password, String name, String surname, String city,
			String country, String title,boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
		this.title = title;
		this.active=active;
	}




	public RegUser(){
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSurname() {
		return surname;
	}




	public void setSurname(String surname) {
		this.surname = surname;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}



	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
