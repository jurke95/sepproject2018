package com.sep.sep.controller.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;


public class UserRegistrationDTO {
	
	
	
	private String username;
	private String email;
	private String password;
	private String password2;
	private String title;
	private String opt;
	private String name;
	private String surname;
	private String city;
	private String country;
	//@JsonValue
	//private ArrayList<String>chosenareas;
	
	
	public UserRegistrationDTO(){
		
	}
	public UserRegistrationDTO(String username, String email, String password, String password2, String title,
			String opt, String name, String surname, String city, String country) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.title = title;
		this.opt = opt;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
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
	
	
	
	
	
	
	

}
