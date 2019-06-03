package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.User;

public interface IUserService {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> find();
	User find(Integer id);
}
