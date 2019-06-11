package com.sep.sep.controller.dto;

public class ResponseDTO {
	
	
    public String status;
	
	public String taksid;
	
	public String dotaskpath;
	
	public String magazineid;
	
	
    public ResponseDTO() {
		
	}

	public ResponseDTO(String status, String taksid) {
		this.status = status;
		this.taksid = taksid;
	}

	public ResponseDTO(String status, String taksid, String dotaskpath, String magazineid) {
		this.status = status;
		this.taksid = taksid;
		this.dotaskpath = dotaskpath;
		this.magazineid = magazineid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaksid() {
		return taksid;
	}

	public void setTaksid(String taksid) {
		this.taksid = taksid;
	}

	public String getDotaskpath() {
		return dotaskpath;
	}

	public void setDotaskpath(String dotaskpath) {
		this.dotaskpath = dotaskpath;
	}

	public String getMagazineid() {
		return magazineid;
	}

	public void setMagazineid(String magazineid) {
		this.magazineid = magazineid;
	}

	
	
}
