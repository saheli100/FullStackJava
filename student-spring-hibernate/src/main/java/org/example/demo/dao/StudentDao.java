package org.example.demo.dao;

import java.util.List;

import org.example.demo.model.Students;

public interface StudentDao {
	
	public List<Students> getAllStudents();
	public Students getStudentById(int studentId);

	public Students getStudentByName(String studentName);
	public Students getStudentByDate(String date);
	public Students createStudent(Students student);
	public Students updateStudent(int studentId, Students student);
	public Students updateStudentByName(String name, Students student);
	public void deleteStudentById(int studentId);
	public void deleteAllStudents();

}