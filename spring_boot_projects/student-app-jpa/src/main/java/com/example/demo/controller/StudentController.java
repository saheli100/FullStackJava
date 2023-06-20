package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Students;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping
	public String listStudents(Model theModel) {
		List<Students> thestudents = studentService.getAllStudents();
		theModel.addAttribute("students", thestudents);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Students thestudent = new Students();
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@PostMapping("/saveCustomer")
	public String saveStudent(@ModelAttribute("student") Students thestudent) {
		studentService.createStudent(thestudent);
		return "redirect:/";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
	Optional<Students> thestudent = studentService.getStudent(theId);
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentService.deleteStudent(theId);
		return "redirect:/";
	}
	
	
}