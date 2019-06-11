package com.sep.sep.elasticsearch;

import javax.persistence.Id;

public class Keyword {
	
	
	
	
	private String name;
	
	
	
	public Keyword(){
		
	}
	
	

	public Keyword(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
