package com.sep.sep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScientificWork {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String coauthors;
	private String keywords;
	private String abstractt;
	@OneToOne
    @JoinColumn(name = "area_id")
 	private ScienceArea area;
	private String pdf;
	private String version;
	@OneToOne
	private Magazine magazine;
	
	public ScientificWork(){
		
	}
	
	public ScientificWork(Long id, String name, String coauthors, String keywords, String abstractt, ScienceArea area,
			String pdf, String version) {
		super();
		this.id = id;
		this.name = name;
		this.coauthors = coauthors;
		this.keywords = keywords;
		this.abstractt = abstractt;
		this.area = area;
		this.pdf = pdf;
		this.version = version;
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
	public String getCoauthors() {
		return coauthors;
	}
	public void setCoauthors(String coauthors) {
		this.coauthors = coauthors;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getAbstractt() {
		return abstractt;
	}
	public void setAbstractt(String abstractt) {
		this.abstractt = abstractt;
	}
	public ScienceArea getArea() {
		return area;
	}
	public void setArea(ScienceArea area) {
		this.area = area;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
