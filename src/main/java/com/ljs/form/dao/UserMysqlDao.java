package com.ljs.form.dao;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ljs.form.model.User;

public class UserMysqlDao implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private RowMapper<User> userRowMapper = (rs, rowNum) -> {
		User user = User.builder().email(rs.getString("EMAIL")).password(rs.getString("PASSWORD"))
				.name(rs.getString("NAME")).createDate(rs.getTimestamp("CREATEDATE").toLocalDateTime()).build();
		user.setId(rs.getInt("ID"));
		return user;
	};

	public UserMysqlDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(User user) {
		jdbcTemplate.update(con -> {
			PreparedStatement pstmt = con
					.prepareStatement("insert into USER(EMAIL, PASSWORD, NAME, CREATEDATE) values(?,?,?,?)");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setTimestamp(4, Timestamp.valueOf(user.getCreateDate()));
			return pstmt;
		});
	}

	@Override
	public User findById(int id) {
		List<User> userList = jdbcTemplate.query("select * from USER where id = ?", userRowMapper, id);
		return userList.isEmpty() ? null : userList.get(0);
	}

	@Override
	public User findByEmail(String email) {
		List<User> userList = jdbcTemplate.query("select * from USER where EMAIL = ?", userRowMapper, email);
		return userList.isEmpty() ? null : userList.get(0);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = jdbcTemplate.query("select * from USER", userRowMapper);
		return userList;
	}

	@Override
	public List<User> findByCreateDate(LocalDateTime from, LocalDateTime to) {
		List<User> userList = jdbcTemplate.query(
				"select * from USER where CREATEDATE between ? and ? order by CREATEDATE desc", userRowMapper, from,
				to);
		return userList;
	}

	@Override
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select (*) from USER", Integer.class);
		return count;
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("update USER set PASSWORD = ? where EMAIL = ?", user.getPassword(), user.getEmail());
	}

}
