package com.ljs.form.model;

import java.time.LocalDateTime;

import com.ljs.form.exception.WrongIdPasswordException;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
	private int id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime createDate;

	@Builder
	public User(String email, String password, String name, LocalDateTime createDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.createDate = createDate;
	}

	public void changePassword(String currentPassword, String newPassword) {
		if (!password.equals(currentPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
}
