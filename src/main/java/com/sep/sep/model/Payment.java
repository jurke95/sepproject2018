package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne
	private RegUser customer;
	
	
	@ManyToOne
	private Magazine merchant;
	
	
	
	
	public Payment(){
		
	}
	
	
	

	private double amount;
	
	private String title;
	
	
	
	public Payment(Long id, RegUser customer, Magazine merchant, double amount, String title) {
		super();
		this.id = id;
		this.customer = customer;
		this.merchant = merchant;
		this.amount = amount;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegUser getCustomer() {
		return customer;
	}

	public void setCustomer(RegUser customer) {
		this.customer = customer;
	}

	public Magazine getMerchant() {
		return merchant;
	}

	public void setMerchant(Magazine merchant) {
		this.merchant = merchant;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
