package com.ljs.form.command;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserListRequest {
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime from;

	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime to;
}