package com.ljs.form.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ljs.form.auth.AuthInfo;
import com.ljs.form.command.ChangePasswordRequest;
import com.ljs.form.exception.WrongIdPasswordException;
import com.ljs.form.service.ChangePasswordService;
import com.ljs.form.validation.ChangePasswordRequestValidator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChangePasswordController {

	private final ChangePasswordService changePasswordService;

	@GetMapping("/edit/changePassword")
	public String form(ChangePasswordRequest request) {
		return "edit/changePasswordForm";
	}

	@PostMapping("/edit/changePassword")
	public String submit(ChangePasswordRequest request, Errors errors, HttpSession session) {
		new ChangePasswordRequestValidator().validate(request, errors);

		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		try {
			changePasswordService.changePassword(authInfo.getEmail(), request.getCurrentPassword(),
					request.getNewPassword());
			return "edit/changedPassword";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notmatch");
			return "edit/changePasswordForm";
		}
	}

}