package com.sep.sep.controller.dto;

public class PaymentDTO {
	
	
	private String magazineid;
	
	private String editionid;
	
	private String articleid;
	
	public PaymentDTO(){
		
	}

	public PaymentDTO(String magazineid, String editionid, String articleid) {
		super();
		this.magazineid = magazineid;
		this.editionid = editionid;
		this.articleid = articleid;
	}

	public String getMagazineid() {
		return magazineid;
	}

	public void setMagazineid(String magazineid) {
		this.magazineid = magazineid;
	}

	public String getEditionid() {
		return editionid;
	}

	public void setEditionid(String editionid) {
		this.editionid = editionid;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	
	
	
	
	

}
