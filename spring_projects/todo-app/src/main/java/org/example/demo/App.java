package org.example.demo;

import java.util.Scanner;

import javax.persistence.Query;

import org.example.demo.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Todo.class).buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();

		session.save(new Todo(101, "StudyHibernate",true ));
		System.out.println("todo created...");
		Query query = session.createQuery("FROM Todo");
		java.util.List<Todo> todos = query.getResultList();
		for (Todo s : todos) {
			System.out.println(s);
		}

		System.out.print("Enter Todo ID: ");

		int id = scanner.nextInt();

		Todo todo = session.find(Todo.class, id);

		if (todo == null) {
			System.out.println("no such id..");
		} else {
			System.out.println("Found: " + todo);
		}

		session.getTransaction().commit();
	}
}