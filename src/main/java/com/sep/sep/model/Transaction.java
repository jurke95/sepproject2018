package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String merchant;
	
	private String buyer;
	
	private double amount;
	
	private String description;
	

	private String datetime;
	
	private String currency;
	
	private String typepayment;
	
	private String verified;
	
	private String paymentid;
	
	private String paymentcode;
	
	private String magazinename;
	
	
	
	
	public Transaction(){
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getMerchant() {
		return merchant;
	}




	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}




	public String getBuyer() {
		return buyer;
	}




	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getDatetime() {
		return datetime;
	}




	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}




	public String getCurrency() {
		return currency;
	}




	public void setCurrency(String currency) {
		this.currency = currency;
	}




	public String getTypepayment() {
		return typepayment;
	}




	public void setTypepayment(String typepayment) {
		this.typepayment = typepayment;
	}




	public String getVerified() {
		return verified;
	}




	public void setVerified(String verified) {
		this.verified = verified;
	}




	public String getPaymentid() {
		return paymentid;
	}




	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}




	public String getPaymentcode() {
		return paymentcode;
	}




	public void setPaymentcode(String paymentcode) {
		this.paymentcode = paymentcode;
	}




	public String getMagazinename() {
		return magazinename;
	}




	public void setMagazinename(String magazinename) {
		this.magazinename = magazinename;
	}
	
	
	

	
	
	
	
	
	
	
}
