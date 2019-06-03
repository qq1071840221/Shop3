package com.woniuxy.service;

import java.util.List;

import com.woniuxy.dao.IUserDao;
import com.woniuxy.dao.UserDaoImpl;
import com.woniuxy.domain.User;

public class IUserServiceImpl implements IUserService {
	private IUserDao dao= new UserDaoImpl();

	public void save(User user) {
		dao.save(user);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public void update(User user) {
		dao.update(user);		
	}

	@Override
	public List<User> find() {
		return dao.findAll();
	}

	@Override
	public User find(Integer id) {
		return dao.findById(id);
	}

}
