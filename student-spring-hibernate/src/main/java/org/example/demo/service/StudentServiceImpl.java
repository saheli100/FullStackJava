package org.example.demo.service;

import java.util.List;

import org.example.demo.dao.StudentDao;
import org.example.demo.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {

		this.studentDao = studentDao;
		
	}

	@Override
	public List<Students> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Students getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}
	

	@Override
	public Students createStudent(Students student) {
		return studentDao.createStudent(student);
	}
	
	@Override
	public Students updateStudent(int studentId, Students student) {
		return studentDao.updateStudent(studentId, student);
	}
	
	@Override
	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);
	}

	@Override
	public void deleteAllStudents() {
		studentDao.deleteAllStudents();
	}

	@Override
	public Students getStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByName(studentName);
	}

	@Override
	public Students getStudentByDate(String date) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByDate(date);
	}

	@Override
	public Students updateStudentByName(String name, Students student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudentByName(name, student);
	}

}