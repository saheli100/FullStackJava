package org.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.demo.model.Customer;

public interface CustomerDao {
	
	public List<Customer> getAllCustomers();
	
	public Customer createCustomer(Customer customer) throws SQLException;
	
	public Customer findCustomerByid(int customerId) throws SQLException;
	
	

}