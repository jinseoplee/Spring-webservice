package com.ljs.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ljs.form.controller.ChangePasswordController;
import com.ljs.form.controller.LoginController;
import com.ljs.form.controller.LogoutController;
import com.ljs.form.controller.RegisterController;
import com.ljs.form.controller.UserDetailController;
import com.ljs.form.controller.UserListController;
import com.ljs.form.dao.UserDao;
import com.ljs.form.service.AuthService;
import com.ljs.form.service.ChangePasswordService;
import com.ljs.form.service.UserRegisterService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class ControllerConfig {
	private final UserDao userDao;
	private final UserRegisterService userRegisterService;
	private final ChangePasswordService changePasswordService;
	private final AuthService authService;

	@Bean
	public RegisterController registerController() {
		return new RegisterController(userRegisterService);
	}

	@Bean
	public ChangePasswordController changePasswordController() {
		return new ChangePasswordController(changePasswordService);
	}

	@Bean
	public LoginController loginController() {
		return new LoginController(authService);
	}

	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}

	@Bean
	public UserListController userListController() {
		return new UserListController(userDao);
	}

	@Bean
	public UserDetailController userDetailController() {
		return new UserDetailController(userDao);
	}
}