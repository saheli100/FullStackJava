package org.example.demo.service;

import java.util.List;

import org.example.demo.model.Instructor;

public interface InstructorService {
	public List<Instructor> getAllInstructors();
	public Instructor getInstructorById(int instructorId);
	public Instructor createInstructor(Instructor instructor);
	public Instructor updateInstructor(int instructorId, Instructor instructor);
	public void deleteInstructorById(int instructorId);
	public void deleteAllInstructors();
}
