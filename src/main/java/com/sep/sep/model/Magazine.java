package com.sep.sep.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Magazine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String issn;
	
	
	 
	private boolean openaccess;
	 
	@OneToOne
	@JoinColumn(name="maineditor_id")
	private Editor maineditor;
	
	private String imgpath;
	
    private String clientId;
	
	private String clientSecret;
	
	private String bitcointoken;
	
	private String merchant_id;
	
	private String merchant_password;
	
	private double membershipfee; //euros

	
	
	public Magazine(){
		
	}



	public Magazine(Long id, String name, String issn, boolean openaccess, Editor maineditor, String imgpath,
			String clientId, String clientSecret, double membershipfee) {
		super();
		this.id = id;
		this.name = name;
		this.issn = issn;
		this.openaccess = openaccess;
		this.maineditor = maineditor;
		this.imgpath = imgpath;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.membershipfee = membershipfee;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getIssn() {
		return issn;
	}



	public void setIssn(String issn) {
		this.issn = issn;
	}



	public boolean isOpenaccess() {
		return openaccess;
	}



	public void setOpenaccess(boolean openaccess) {
		this.openaccess = openaccess;
	}



	public Editor getMaineditor() {
		return maineditor;
	}



	public void setMaineditor(Editor maineditor) {
		this.maineditor = maineditor;
	}



	public String getImgpath() {
		return imgpath;
	}



	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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



	public double getMembershipfee() {
		return membershipfee;
	}



	public void setMembershipfee(double membershipfee) {
		this.membershipfee = membershipfee;
	}



	public String getBitcointoken() {
		return bitcointoken;
	}



	public void setBitcointoken(String bitcointoken) {
		this.bitcointoken = bitcointoken;
	}



	public String getMerchant_id() {
		return merchant_id;
	}



	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}



	public String getMerchant_password() {
		return merchant_password;
	}



	public void setMerchant_password(String merchant_password) {
		this.merchant_password = merchant_password;
	}
	
	





	

	
	
	
	 

}
