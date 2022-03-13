package com.ljs.form.command;

import lombok.Data;

@Data
public class LoginRequest {
	private String email;
	private String password;
	private boolean rememberEmail;
}