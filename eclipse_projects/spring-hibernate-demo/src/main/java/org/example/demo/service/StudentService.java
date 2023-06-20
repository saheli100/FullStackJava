
package org.example.demo.service;

import java.util.List;

import org.example.demo.model.Student;

public interface StudentService {
	public Student createStudent(Student student);

	
	  public void deleteStudentById(int studentId);
	  
	  public void deleteAllStudents();
	  
	  public Student updateStudent(int studentId, Student student);
	  
	  public List<Student> getAllStudents();
	  
	  public Student findByStudentId(int studentid);
	 

}
