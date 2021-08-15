package com.bryce.loginreg.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.bryce.loginreg.models.User;
import com.bryce.loginreg.repositories.UserRepository;

@Component
public class Validator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Passwords do not match");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Sorry, that email is taken.");
		}
		if(user.getPassword().length()<5) {
			errors.rejectValue("password", "length", "Password must be 5 characters long");
		}
	}
}
