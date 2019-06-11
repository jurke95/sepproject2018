package com.sep.sep.controller.response;



public class LoginTokenResponse {
	
	
	
	private String jwt;

	
	
	public LoginTokenResponse(){
		
		
		
	}

	


	public LoginTokenResponse(String jwt) {
		super();
		this.jwt = jwt;
	}




	public String getJwt() {
		return jwt;
	}



	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	
	
	


	




	
	
	
	
	
}
