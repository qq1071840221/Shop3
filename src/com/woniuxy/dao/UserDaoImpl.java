package com.woniuxy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.woniuxy.domain.User;
import com.woniuxy.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	public void save(User user) {
		try {
			Connection conn= JdbcUtils.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "insert into user valuse(null,?,?,?,?)";
			qr.execute(conn,sql,user.getName(),user.getBirthday(),user.getMoney(),user.getPhoto());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer id) {
		try {
			Connection conn= JdbcUtils.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "delete from user where id=?";
			qr.execute(conn,sql,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void update(User user) {
		try {
			Connection conn= JdbcUtils.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "update user set name=?,birthday=?,money=?,photo=? where id=?";
			qr.execute(conn,sql,user.getName(),user.getBirthday(),user.getMoney(),user.getPhoto(),user.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> findAll() {
		try {
			Connection conn= JdbcUtils.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "select * from user";
			List<User> list = qr.query(conn,sql, new BeanListHandler<User>(User.class));
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findById(Integer id) {
		try {
			Connection conn= JdbcUtils.getConnection();
			QueryRunner qr = new QueryRunner();
			String sql = "select * from user where id=?";
			 User user = qr.query(conn,sql, new BeanHandler<User>(User.class),id);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
