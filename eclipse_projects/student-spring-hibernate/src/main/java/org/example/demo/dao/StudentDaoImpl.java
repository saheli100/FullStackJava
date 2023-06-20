package org.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.example.demo.model.Student;
import org.example.demo.model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Students> getAllStudents() {
		Query query = getSession().createQuery("FROM Students");
		List<Students> studentsList = query.getResultList();
		return studentsList;
	}

	@Override
	public Students getStudentById(int studentId) {
		Students student = getSession().find(Students.class, studentId);
		return student;
	}

	@Override
	public Students getStudentByName(String studentName) {
		Query query = getSession().createQuery("FROM Students");
		List<Students> studentsList = query.getResultList();
		Students newStudent = null;
		for (Students s : studentsList) {
			if (s.getName().equals(studentName)) {
				newStudent = s;
			}
		}
		return newStudent;
	}

	@Override
	public Students getStudentByDate(String date) {
		Query query = getSession().createQuery("FROM Students");
		List<Students> studentsList = query.getResultList();
		Students newStudent = null;
		for (Students s : studentsList) {
			if (s.getEnteringDate().equals(date)) {
				newStudent = s;
			}
		}
		return newStudent;
	}

	@Override
	public Students createStudent(Students student) {

		Session session = getSession();
		session.getTransaction().begin();

		session.save(student);

		session.getTransaction().commit();

		return student;
	}

	@Override
	public Students updateStudent(int studentId, Students newStudent) {
		Session session = getSession();
		session.getTransaction().begin();

		Students student = session.get(Students.class, studentId);
		if (student == null) {
			System.out.println("no student found for the id...:" + studentId);
		} else {
			student.setName(newStudent.getName());
			student.setEnteringDate(newStudent.getEnteringDate());
			student.setNationality(newStudent.getNationality());
			;
			student.setCode(newStudent.getCode());
			session.merge(student);

			System.out.println("Student has been updated...");
		}

		session.getTransaction().commit();

		return student;
	}
	@Override
	public Students updateStudentByName(String name, Students student) {
		Session session = getSession();
		session.getTransaction().begin();
		String nameUpdate=name;
		Students studentUpdate = getStudentByName(nameUpdate);
		if (studentUpdate == null) {
			System.out.println("no student found for the name...:" + nameUpdate);
		} else {
			studentUpdate.setName(student.getName());
			//studentUpdate.setId(student.getId());
			studentUpdate.setEnteringDate(student.getEnteringDate());
			studentUpdate.setNationality(student.getNationality());
			studentUpdate.setCode(student.getCode());
			session.merge(studentUpdate);

			System.out.println("Student has been updated...");
		}

		session.getTransaction().commit();

		return studentUpdate;
	}

	@Override
	public void deleteStudentById(int studentId) {
		Session session = getSession();
		session.getTransaction().begin();

		Students student = session.get(Students.class, studentId);
		if (student == null) {
			System.out.println("no student found for the id...:" + studentId);
		} else {
			session.delete(student);
			System.out.println("Student has been deleted...");
		}

		session.getTransaction().commit();
	}

	@Override
	public void deleteAllStudents() {
		Session session = getSession();
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Students");
		List<Students> studentList = query.getResultList();
		for (Students s : studentList) {
			session.delete(s);
		}

		session.getTransaction().commit();
	}

	private Session getSession() {
		return sessionFactory.openSession();
	}

	

}