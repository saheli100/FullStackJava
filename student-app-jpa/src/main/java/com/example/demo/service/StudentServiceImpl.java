package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Students;

@Service
public class StudentServiceImpl implements StudentService{

	private final StudentDao studentDao;
	
	
	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll() ;
	}

	@Override
	public Students createStudent(Students student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Optional<Students> getStudent(int theId) {
		// TODO Auto-generated method stub
		Optional<Students> student= studentDao.findById(theId);
		return student;
	}

	@Override
	public void deleteStudent(int theId) {
		// TODO Auto-generated method stub
		studentDao.deleteById(theId);
		
	}


}