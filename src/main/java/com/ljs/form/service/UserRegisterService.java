package com.ljs.form.service;

import java.time.LocalDateTime;

import org.springframework.transaction.annotation.Transactional;

import com.ljs.form.command.RegisterRequest;
import com.ljs.form.dao.UserDao;
import com.ljs.form.exception.AlreadyExistUserException;
import com.ljs.form.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRegisterService {

	private final UserDao userDao;

	@Transactional
	public void register(RegisterRequest request) {
		User user = userDao.findByEmail(request.getEmail());
		if (user != null) {
			throw new AlreadyExistUserException();
		}

		User newUser = User.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.name(request.getName())
				.createDate(LocalDateTime.now())
				.build();

		userDao.save(newUser);
	}

}
