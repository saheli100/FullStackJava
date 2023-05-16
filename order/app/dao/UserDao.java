package org.order.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.order.app.model.Users;

public interface UserDao {
	
	public boolean getDetails(int userId, String password) throws SQLException;
	
	

	public int findUserId(int userId) throws SQLException;
	
	public String checkPassword(String pw) throws SQLException;

}