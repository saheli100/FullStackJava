package org.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.example.demo.factory.MyFactory;
import org.example.demo.model.Student;
import org.hibernate.Session;

public class StudentDaoImpl implements StudentDao {

	private Session session;

	{
		session = MyFactory.getSessionFactory().openSession();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public void deleteStudentById(int studentId) {
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("no such id found: " + studentId);
		} else {
			session.delete(s);

			System.out.println("one item deleted...");
		}
		session.getTransaction().commit();

	}

	@Override
	public void deleteAllStudents() {
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {
			session.delete(s);
		}
		session.getTransaction().commit();

	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("no such id found: " + studentId);
		} else {

			s.setFirstName(student.getFirstName());
			s.setLastName(student.getLastName());
			s.setEmail(student.getEmail());
			session.merge(s);

			System.out.println("one item updated...");
		}
		session.getTransaction().commit();
		return s;
	}

	@Override
	public List<Student> getAllStudents() {
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {
			session.get(Student.class,s.getStudentId());
		}
		session.getTransaction().commit();
		return list;
	}

	@Override
	public Student findByStudentId(int studentId) {
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);

		if (s == null) {
			System.out.println("no such id found: " + studentId);
		} else {
			session.find(Student.class, studentId);

			System.out.println("one item found...");
		}
		session.getTransaction().commit();
		return s;
	}

}