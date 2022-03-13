package com.ljs.form.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ljs.form.dao.UserDao;
import com.ljs.form.dao.UserMysqlDao;
import com.ljs.form.service.AuthService;
import com.ljs.form.service.ChangePasswordService;
import com.ljs.form.service.UserRegisterService;

@Configuration
@EnableTransactionManagement
public class UserConfig {
	/*
	 * the minimum idle time of a connection is 3 minutes, and it is checked every
	 * 10 seconds.
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/form?serverTimezone=Asia/Seoul");
		dataSource.setUsername("ljs");
		dataSource.setPassword("1234");
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(100);
		dataSource.setTestWhileIdle(true);
		dataSource.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
		dataSource.setTimeBetweenEvictionRunsMillis(1000 * 10);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public UserDao userDao() {
		return new UserMysqlDao(dataSource());
	}

	@Bean
	public UserRegisterService userRegisterService() {
		return new UserRegisterService(userDao());
	}
	
	@Bean
	public AuthService authService() {
		return new AuthService(userDao());
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(userDao());
	}
	
}
