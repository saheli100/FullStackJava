package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Students;

public interface StudentService {

public List<Students> getAllStudents();
	
	public Students createStudent(Students customer);
	
	public Optional<Students> getStudent(int theId);

	public void deleteStudent(int theId);
}