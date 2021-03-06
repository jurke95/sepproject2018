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
	
	private String description;
	
	private String successUrl;
	
	private String clientId;
	
	private String clientSecret;
	
	private String magazinename;
	
	private String fronturl;
	
	private String bitcointoken;
	
    private String merchantid;
	
	private String merchantpassword;
	
	private String title;
	
	
	private String payermail;
	
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

	

	

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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



	public String getMagazinename() {
		return magazinename;
	}



	public void setMagazinename(String magazinename) {
		this.magazinename = magazinename;
	}



	public String getFronturl() {
		return fronturl;
	}



	public void setFronturl(String fronturl) {
		this.fronturl = fronturl;
	}



	public String getBitcointoken() {
		return bitcointoken;
	}



	public void setBitcointoken(String bitcointoken) {
		this.bitcointoken = bitcointoken;
	}



	public String getMerchantid() {
		return merchantid;
	}



	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}



	public String getMerchantpassword() {
		return merchantpassword;
	}



	public void setMerchantpassword(String merchantpassword) {
		this.merchantpassword = merchantpassword;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}







	public String getPayermail() {
		return payermail;
	}



	public void setPayermail(String payermail) {
		this.payermail = payermail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
