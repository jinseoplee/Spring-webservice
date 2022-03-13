package com.ljs.form.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljs.form.command.UserListRequest;
import com.ljs.form.dao.UserDao;
import com.ljs.form.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserListController {

	private final UserDao userDao;

	@RequestMapping("/user")
	public String list(UserListRequest request, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "user/userList";
		}

		if (request.getFrom() != null && request.getTo() != null) {
			List<User> userList = userDao.findByCreateDate(request.getFrom(), request.getTo());
			model.addAttribute("userList", userList);
		}
		return "user/userList";
	}

}
