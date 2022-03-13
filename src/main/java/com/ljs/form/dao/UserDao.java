package com.ljs.form.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.ljs.form.model.User;

public interface UserDao {

	void save(User user);
	
	User findById(int id);

	User findByEmail(String email);

	List<User> findAll();

	List<User> findByCreateDate(LocalDateTime from, LocalDateTime to);

	int count();

	void update(User user);

}
