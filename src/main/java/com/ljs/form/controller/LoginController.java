package com.ljs.form.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ljs.form.auth.AuthInfo;
import com.ljs.form.command.LoginRequest;
import com.ljs.form.exception.WrongIdPasswordException;
import com.ljs.form.service.AuthService;
import com.ljs.form.validation.LoginRequestValidator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {

	private final AuthService authService;

	@GetMapping("/login")
	public String form(LoginRequest request, @CookieValue(value = "REMEMBER", required = false) Cookie cookie) {
		if (cookie != null) {
			request.setEmail(cookie.getValue());
			request.setRememberEmail(true);
		}

		return "login/loginForm";
	}

	@PostMapping("/login")
	public String submit(LoginRequest request, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginRequestValidator().validate(request, errors);

		if (errors.hasErrors()) {
			return "login/loginForm";
		}

		try {
			AuthInfo authInfo = authService.authenticate(request);

			session.setAttribute("authInfo", authInfo);

			Cookie cookie = new Cookie("REMEMBER", request.getEmail());
			cookie.setPath("/");
			if (request.isRememberEmail()) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);

			return "index";
		} catch (WrongIdPasswordException e) {
			errors.reject("wrongIdPassword");
			return "login/loginForm";
		}
	}

}