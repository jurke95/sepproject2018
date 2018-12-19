package com.sep.sep.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Editor {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	private String city;
	private String country;
	private String title;
	private String password;
	private String username;
	
	
	// @OneToMany(cascade = CascadeType.ALL,mappedBy="editor")
	 
	//    private List<ScienceArea> areas;
	
	
	private String email;
	private boolean isRecensent;
	
	
	public Editor(){
		
	}
	
	
	
	
	
	public Editor(Long id, String name, String surname, String city, String country, String title,String password,String username,
			String email, boolean isRecensent) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.country = country;
		this.title = title;
		this.password=password;
	//	this.areas = areas;
		this.email = email;
		this.isRecensent = isRecensent;
		this.username=username;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isRecensent() {
		return isRecensent;
	}
	public void setRecensent(boolean isRecensent) {
		this.isRecensent = isRecensent;
	}
	/*public List<ScienceArea> getAreas() {
		
		
		if(areas==null){
			
			areas=new ArrayList<ScienceArea>();
		}
		
		
		return areas;
	}
	public void setAreas(List<ScienceArea> areas) {
		this.areas = areas;
	}

*/



	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
