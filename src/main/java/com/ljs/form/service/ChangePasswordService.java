package com.ljs.form.service;

import org.springframework.transaction.annotation.Transactional;

import com.ljs.form.dao.UserDao;
import com.ljs.form.exception.WrongIdPasswordException;
import com.ljs.form.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangePasswordService {

	private final UserDao userDao;

	@Transactional
	public void changePassword(String email, String currentPassword, String newPassword) {
		User user = userDao.findByEmail(email);
		if (user == null) {
			throw new WrongIdPasswordException();
		}

		user.changePassword(currentPassword, newPassword);

		userDao.update(user);
	}

}