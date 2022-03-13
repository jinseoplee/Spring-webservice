package com.ljs.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ljs.form.command.RegisterRequest;
import com.ljs.form.exception.AlreadyExistUserException;
import com.ljs.form.service.UserRegisterService;
import com.ljs.form.validation.RegisterRequestValidator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RegisterController {

	private final UserRegisterService userRegisterService;

	@GetMapping("/register")
	public String form(RegisterRequest request) {
		return "register/registerForm";
	}

	@PostMapping("/register")
	public String submit(RegisterRequest request, Errors errors) {
		new RegisterRequestValidator().validate(request, errors);
		if (errors.hasErrors()) {
			return "register/registerForm";
		}

		try {
			userRegisterService.register(request);
			return "/register/registerSuccess";
		} catch (AlreadyExistUserException e) {
			errors.rejectValue("email", "existing");
			return "register/registerForm";
		}
	}

}
