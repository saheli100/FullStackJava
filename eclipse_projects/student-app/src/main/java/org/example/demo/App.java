package org.example.demo;

import org.example.demo.model.Student;
import org.example.demo.service.StudentService;
import org.example.demo.service.StudentServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	StudentService studentService=new StudentServiceImpl();
    	
    	int choice =0;
		do {
			System.out.println("1. getAllStudents");
			System.out.println("2. createStudent");
			System.out.println("3. findByStudentId");
			System.out.println("4. deleteByStudentId");
			System.out.println("5. deleteAllStudents");
			System.out.println("6. updateStudent");
			
			System.out.println("Enter option:");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				List<Student> list = studentService.getAllStudents();
				for (Student s : list) {
					System.out.println(s);
				}
				break;
			case 2:
				int studentId = new Random().nextInt(1000);
				System.out.println("Enter First Name:");
				String firstName = scanner.next();
				System.out.println("Enter Last Name:");
				String lastName = scanner.next();
				System.out.println("Enter Email:");
				String email = scanner.next();
				Student newStudent= new Student(studentId,firstName,lastName,email);
				Student stud=studentService.createStudent(newStudent);
				System.out.println("New student created");
				break;
			case 3:
				System.out.println("Enter student id to find");
				int findStudentId=scanner.nextInt();
				Student findStudent=studentService.findByStudentId(findStudentId);
				System.out.println(findStudent);
				break;
			case 4:
				System.out.println("Enter student id to delete");
				int deleteStudentId=scanner.nextInt();
				studentService.deleteStudentById(deleteStudentId);
				//System.out.println(deleteStudent);
				break;
			case 5:
				studentService.deleteAllStudents();
				break;
			case 6:
				System.out.println("Enter Student Id to update:");
				int id=scanner.nextInt();
				System.out.println("Enter Student Id to be updated:");
				int id1=scanner.nextInt();
				System.out.println("Enter First Name:");
				String updateFirstName = scanner.next();
				System.out.println("Enter Last Name:");
				String updateLastName = scanner.next();
				System.out.println("Enter Email:");
				String updateEmail = scanner.next();
				Student updateStudent=new Student(id1,updateFirstName,updateLastName,updateEmail);
				Student updatedStudent=studentService.updateStudent(id, updateStudent);
				System.out.println(updatedStudent);
				break;
			case 0:
				System.out.println("BYE...");
				System.exit(1);
				break;

			default:
				System.out.println("Invalid choice try again ......");
				break;
				
			}
		}while (choice != 0);
    	
    }
}