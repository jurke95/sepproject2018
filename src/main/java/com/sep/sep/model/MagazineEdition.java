package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MagazineEdition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="magazine_id")
	private Magazine magazine;
	
	private String number;
	
	private String name;
	
	private String pdf;
	
	private double price;
	
	
	
	public MagazineEdition(){
		
	}




	public MagazineEdition(Long id, Magazine magazine, String number, String name, String pdf) {
		super();
		this.id = id;
		this.magazine = magazine;
		this.number = number;
		this.name = name;
		this.pdf=pdf;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Magazine getMagazine() {
		return magazine;
	}




	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}




	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPdf() {
		return pdf;
	}




	public void setPdf(String pdf) {
		this.pdf = pdf;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
	
	
	
	
	
	
}
