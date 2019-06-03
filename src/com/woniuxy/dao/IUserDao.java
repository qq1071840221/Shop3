package com.woniuxy.dao;

import java.util.List;

import com.woniuxy.domain.User;

public interface IUserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> findAll();
	User findById(Integer id);
}
