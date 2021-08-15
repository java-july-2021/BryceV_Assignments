package com.bryce.dojoOverflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.bryce.dojoOverflow.models.Question;

@Component
public class TagValidator {
	
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Question question = (Question) target;
		
		String[] tags = question.getTagsFromForm().split(", ");
		if(tags.length > 3) {
			errors.rejectValue("tagsFromForm", "too many", "Must be 3 or less tags");
		}
		
	}
}
