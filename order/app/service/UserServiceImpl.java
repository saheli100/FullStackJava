package org.order.app.service;

import java.sql.SQLException;

import org.order.app.dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public int findUserId(int userId) throws SQLException {

		return userDao.findUserId(userId);

	}

	@Override
	public String checkPassword(String pw) throws SQLException {
		return userDao.checkPassword(pw);
	}

	@Override
	public boolean getDetails(int userId, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.getDetails(userId, password);
	}

	

}