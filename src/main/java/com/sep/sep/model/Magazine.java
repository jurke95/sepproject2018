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
	
	
	 
	private String paymentWay;
	 
	@OneToOne
	@JoinColumn(name="maineditor_id")
	private Editor maineditor;
	
	

	public Magazine(Long id, String name, String issn, String paymentWay, Editor maineditor, Recensent recensent) {
		super();
		this.id = id;
		this.name = name;
		this.issn = issn;
		this.paymentWay = paymentWay;
		this.maineditor = maineditor;
		
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

	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Editor getMaineditor() {
		return maineditor;
	}

	public void setMaineditor(Editor maineditor) {
		this.maineditor = maineditor;
	}

	
	
	
	 

}
