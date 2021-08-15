package com.bryce.thoughts.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.bryce.thoughts.models.User;
import com.bryce.thoughts.repositories.UserRepository;

@Component
public class Validator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPw())) {
			errors.rejectValue("password", "Match", "Passwords do not match");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Sorry, that email is taken");
		}
		if(user.getPassword().length()<8) {
			errors.rejectValue("password", "length", "Password must be 8 characters long");
		}
		if(user.getFirstName().length()<2) {
			errors.rejectValue("firstName", "length", "First Name must be at least 2 characters long");
		}
		if(user.getLastName().length()<2) {
			errors.rejectValue("lastName", "length", "Last Name must be at least 2 characters long");
		}
	}
}
