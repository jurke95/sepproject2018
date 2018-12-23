package com.sep.sep.validation;

import com.sep.sep.controller.dto.UserRegistrationDTO;

public class PasswordMatchesValidator {
	
	
	public PasswordMatchesValidator(){
		
	}
	
	
	public boolean isValid(Object obj){
		
		
		UserRegistrationDTO user=(UserRegistrationDTO) obj;
		
		return user.getPassword().equals(user.getPassword2());
	}

}
