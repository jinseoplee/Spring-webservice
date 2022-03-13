package com.ljs.form.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthInfo {
	private int id;
	private String email;
	private String name;

	@Builder
	public AuthInfo(int id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
}
