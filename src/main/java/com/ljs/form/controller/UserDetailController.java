package com.ljs.form.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ljs.form.dao.UserDao;
import com.ljs.form.exception.UserNotFoundException;
import com.ljs.form.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserDetailController {

	private final UserDao userDao;

	@GetMapping("/user/{id}")
	public String detail(@PathVariable("id") int userId, Model model) {
		User user = userDao.findById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		model.addAttribute("user", user);
		return "user/userDetail";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "user/invalid";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException() {
		return "user/noMember";
	}

}
