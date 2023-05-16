package org.order.app.service;

import java.sql.SQLException;

public interface UserService {

	public boolean getDetails(int userId, String password) throws SQLException;
	
	public int findUserId(int userId) throws SQLException;

	public String checkPassword(String pw) throws SQLException;
}