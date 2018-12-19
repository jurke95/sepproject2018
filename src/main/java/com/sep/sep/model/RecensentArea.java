package com.sep.sep.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RecensentArea {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="recensent_id")
	private Recensent recensent;
	
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="sarea_id")
	private ScienceArea sarea;
	
	
	public RecensentArea(){
		
	}

	
	
	
	
	
	

	public RecensentArea(Long id, Recensent recensent, ScienceArea sarea) {
		super();
		this.id = id;
		this.recensent = recensent;
		this.sarea = sarea;
	}








	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Recensent getRecensent() {
		return recensent;
	}


	public void setRecensent(Recensent recensent) {
		this.recensent = recensent;
	}


	public ScienceArea getSarea() {
		return sarea;
	}


	public void setSarea(ScienceArea sarea) {
		this.sarea = sarea;
	}
	

	
	
	
	
	
}
