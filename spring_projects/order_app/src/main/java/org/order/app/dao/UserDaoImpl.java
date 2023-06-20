package org.order.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.order.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private final DataSource dataSource;

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

public boolean getDetails(int userId, String password) throws SQLException {
		
		boolean auth_user = false;
		Connection conn = dataSource.getConnection();
//		Statement statement = conn.createStatement();
		PreparedStatement statement = conn.prepareStatement("select * from Users where user_id=?");
		statement.setInt(1, userId);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			
			if (resultset.getString("passwords").equals(password)){
				System.out.println(resultset.getString("user_id"));
				System.out.println(resultset.getString("passwords"));
				auth_user=true;
			}
			else {
				auth_user= false;
			}
		}
		return auth_user;
		
		
	}
	@Override
	public int findUserId(int userId) throws SQLException {
		Connection connection = dataSource.getConnection();
		int id=0;
		try {
			
			// String password="";
			PreparedStatement preparedStatement = connection.prepareStatement("select user_id from Users where user_id=?");
			// PreparedStatement preparedStatement1 = connection.prepareStatement("select
			// passwords from Users where passwords=?");
			preparedStatement.setInt(1, userId);
			// preparedStatement1.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(1);
				// password= resultSet.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String checkPassword(String pw) throws SQLException {
		Connection connection = dataSource.getConnection();
		String password = "";
		//int checkUserId = findUserId(userId);
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select passwords from Users where user_id=?");
			// preparedStatement.setInt(1, id);
			preparedStatement.setString(1, pw);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				password = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

}