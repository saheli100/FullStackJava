
package org.example.demo.service;

import java.util.List;

import org.example.demo.dao.StudentDao;
import org.example.demo.dao.StudentDaoImpl;
import org.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	/*
	 * { studentDao = new StudentDaoImpl(); }
	 */

	@Override public Student createStudent(Student student) { 
		// TODO  Auto-generated method stub 
		return studentDao.createStudent(student); }

	@Override
	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);

	}

	@Override public void deleteAllStudents() { // TODO Auto-generated method
  studentDao.deleteAllStudents(); 
  System.out.println("deleted all item");
  
  }

	@Override public Student updateStudent(int studentId, Student student) { //
   return studentDao.updateStudent(studentId,
  student); }

	@Override public List<Student> getAllStudents() { // TODO Auto-generated
   return studentDao.getAllStudents();
  
  }

	@Override public Student findByStudentId(int studentid) { // TODO
  return studentDao.getStudentById(studentid); }

}
