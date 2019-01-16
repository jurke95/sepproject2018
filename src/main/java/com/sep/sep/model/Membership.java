package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Membership {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String startDate;
	private String endDate;
	private String amount;
	private String active;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private RegUser member;
	
	
	public Membership(){
		
	}
	

	public Membership(Long id, String startDate, String endDate, String amount, String active, RegUser member) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.active = active;
		this.member = member;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public RegUser getMember() {
		return member;
	}

	public void setMember(RegUser member) {
		this.member = member;
	}
	
	
	
	
	
	
	
	

}
