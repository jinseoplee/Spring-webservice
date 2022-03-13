package com.ljs.form.command;

import lombok.Data;

@Data
public class ChangePasswordRequest {
	private String currentPassword;
	private String newPassword;
	private String confirmNewPassword;

	public boolean isNewPasswordEqualsToConfirmNewPassword() {
		return newPassword.equals(confirmNewPassword);
	}
}
