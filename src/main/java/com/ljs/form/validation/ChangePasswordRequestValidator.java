
package com.ljs.form.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ljs.form.command.ChangePasswordRequest;

public class ChangePasswordRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) target;
		
		ValidationUtils.rejectIfEmpty(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmNewPassword", "required");
		
		if(!changePasswordRequest.isNewPasswordEqualsToConfirmNewPassword()) {
			errors.rejectValue("confirmNewPassword", "notmatch");
		}
	}

}