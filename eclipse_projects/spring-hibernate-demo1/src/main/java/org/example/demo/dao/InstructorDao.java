package org.example.demo.dao;

import java.util.List;

import org.example.demo.model.Instructor;

public interface InstructorDao {
	public List<Instructor> getAllInstructors();
	public Instructor getInstructorById(int instructorId);
	public Instructor createInstructor(Instructor instructor);
	public Instructor updateInstructor(int instructorId, Instructor instructor);
	public void deleteInstructorById(int instructorId);
	public void deleteAllInstructors();
}
