package model;

import java.util.ArrayList;

public class Editor {
	
	
	
	
	private String name;
	private String surname;
	private String city;
	private String country;
	private String title;
	private ArrayList<String>areas;
	private String email;
	private boolean isCritic;
	
	
	
	
	
	
	public Editor(String name, String surname, String city, String country, String title, ArrayList<String> areas,
			String email, boolean isCritic) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
		this.title = title;
		this.areas = areas;
		this.email = email;
		this.isCritic = isCritic;
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
	public ArrayList<String> getAreas() {
		return areas;
	}
	public void setAreas(ArrayList<String> areas) {
		this.areas = areas;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isCritic() {
		return isCritic;
	}

	public void setCritic(boolean isCritic) {
		this.isCritic = isCritic;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
