package org.example.demo;

import java.util.Scanner;

import javax.persistence.Query;

import org.example.demo.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args )
    {
        SessionFactory factory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
        Session session=factory.openSession();
        session.getTransaction().begin();
        /*session.save(new Customer(201, "Marry", "Kom", "marry@email.com"));
		
		 * System.out.println("customer created..."); Query
		 * query=session.createQuery("FROM Customer"); java.util.List<Customer>
		 * customers= query.getResultList(); for(Customer s:customers) {
		 * System.out.println(s); }
		 */
System.out.print("Enter Customer ID: ");
        
        int id=scanner.nextInt();
        
        Customer customer=session.find(Customer.class, id);
        
        if(customer==null)
        {
        	System.out.println("no such id..");
        }
        else
        {
        	System.out.println("Found: "+customer);
        }
        
        session.getTransaction().commit();
    }
}