package org.example.demo;

import java.util.List;
import java.util.Random;

import org.example.demo.config.SpringConfig;
import org.example.demo.model.Customer;
import org.example.demo.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	
        	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
			
        	//CustomerDao customerDao=context.getBean("customerDao",CustomerDao.class);
        	//List<Customer> list=customerDao.getAllCustomers();
        	CustomerService customerService =context.getBean("customerService",CustomerService.class);
			/*
			 * List<Customer> list=customerService.getAllCustomers();
			 * 
			 * Customer customer = customerService .createCustomer(new Customer(new
			 * Random().nextInt(1000), "Marry", "Kom", "marry.kom@gmail.com"));
			 * 
			 * System.out.println("Customer Created: " + customer);
			 * 
			 * for(Customer c:list) { System.out.println(c); }
			 */
        	
			
			  Customer customer= customerService.findCustomerByid(5690); if(customer
			  ==null) { System.out.println("No such customer present"); }else {
			  System.out.println(customer.getCustomerId()+" "+customer.getFirstName()+" "
			  +customer.getLastName()+" "+customer.getEmail()); }
			 
        	
        	
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}