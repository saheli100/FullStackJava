package org.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	private final DataSource dataSource;

	@Autowired
	public CustomerDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=new ArrayList<Customer>();
		try {
			Connection connection=dataSource.getConnection();
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from customer");
			while(resultSet.next())
			{
			 list.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));	
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Customer createCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=dataSource.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values(?,?,?,?)");
		preparedStatement.setInt(1, customer.getCustomerId());
		preparedStatement.setString(2, customer.getFirstName());
		preparedStatement.setString(3, customer.getLastName());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.executeUpdate();
		return customer;
	}

	@Override
	public Customer findCustomerByid(int customerId) throws SQLException {
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from customer where customer_id=?");
		preparedStatement.setInt(1, customerId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		Customer customer = null;
		if(resultSet.next())
		{
			customer=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
			
		}
	
		return customer;
	}

	

}