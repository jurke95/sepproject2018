package com.sep.sep.controller.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import com.sep.sep.model.Magazine;
import com.sep.sep.model.MagazineEdition;
import com.sep.sep.model.ScienceArea;

public class SWorkDTO {

	private String name;
	private List<String> coauthors;
	private List<String> keywords;
	private String abstractt;
 	private String area;
	private Long magid;
	private String pdf;
	private String taskid;
	
	
	public SWorkDTO(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public String getAbstractt() {
		return abstractt;
	}
	public void setAbstractt(String abstractt) {
		this.abstractt = abstractt;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public Long getMagid() {
		return magid;
	}
	public void setMagid(Long magid) {
		this.magid = magid;
	}
	public List<String> getCoauthors() {
		return coauthors;
	}
	public void setCoauthors(List<String> coauthors) {
		this.coauthors = coauthors;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	
	
	
	
	
}
