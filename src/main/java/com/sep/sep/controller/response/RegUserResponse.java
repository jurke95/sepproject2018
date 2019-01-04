package com.sep.sep.controller.response;

import java.util.ArrayList;
import java.util.List;

public class RegUserResponse {
	
	
	private String username;
	private String email;
	private String name;
	private String surname;
	private String password;
	private boolean active;
	private String title;
	private String city;
	private String country;
	private List<String>areas;
	
	
	
	
	
	
	public RegUserResponse(String username, String email, String name, String surname, String password, boolean active,
			String title, String city, String country, List<String> areas) {
		super();
		this.username = username;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.active = active;
		this.title = title;
		this.city = city;
		this.country = country;
		this.areas = areas;
	}



	public RegUserResponse(){
		
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public List<String> getAreas() {
		
		if(areas==null){
			
			areas=new ArrayList<String>();
		}
		return areas;
	}



	public void setAreas(List<String> areas) {
		this.areas = areas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
