package org.example.spring_jdbc_demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     
    	try {
    		
    		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    		DataSource dataSource=context.getBean("dataSource",DriverManagerDataSource.class);
    		
    		Connection connection=dataSource.getConnection();
    		
    		System.out.println(connection);
    		System.out.println("connection succeed");
    		
    		Statement statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery("select * from customer");

    		while (resultSet.next()) {
    			System.out.println((resultSet.getInt(1)+" "+ resultSet.getString(2)+" "+ resultSet.getString(3)+" "+
    					resultSet.getString(4)));
    		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
}