package com.ljs.form.service;

import com.ljs.form.auth.AuthInfo;
import com.ljs.form.command.LoginRequest;
import com.ljs.form.dao.UserDao;
import com.ljs.form.exception.WrongIdPasswordException;
import com.ljs.form.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthService {

	private final UserDao userDao;

	public AuthInfo authenticate(LoginRequest request) {
		User user = userDao.findByEmail(request.getEmail());
		if (user == null) {
			throw new WrongIdPasswordException();
		}

		if (!user.checkPassword(request.getPassword())) {
			throw new WrongIdPasswordException();
		}

		return AuthInfo.builder()
				.id(user.getId())
				.email(user.getEmail())
				.name(user.getName())
				.build();
	}

}
