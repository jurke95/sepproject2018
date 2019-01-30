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
	
	
	
	private double amount;
	
	private String title;
	
	private String successUrl;
	
	private String clientId;
	
	private String clientSecret;
	
    public Payment(){
		
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



	public String getSuccessUrl() {
		return successUrl;
	}



	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}



	public String getClientId() {
		return clientId;
	}



	public void setClientId(String clientId) {
		this.clientId = clientId;
	}



	public String getClientSecret() {
		return clientSecret;
	}



	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
