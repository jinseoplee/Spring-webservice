package com.ljs.form.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ljs.form.command.LoginRequest;

public class LoginRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
	}

}
