package org.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.example.demo.config.SpringConfig;
import org.example.demo.model.Students;
import org.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("******STUDENT APP******");
		processStudent();
	}

	private static void processStudent() {
		int choice = 0;
		try {
			do {

				ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
				StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);

				System.out.println("1. getAllStudents");
				System.out.println("2. getStudentById");
				System.out.println("3. createStudent");
				System.out.println("4. updateStudent");
				System.out.println("5. deleteStudentById");
				System.out.println("6. deleteAllStudents");

				System.out.println("7. getStudentByName");
				System.out.println("8. getStudentByDate");
				System.out.println("9. updateStudentByName");

				System.out.println("Enter option:");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					java.util.List<Students> studentsList = studentService.getAllStudents();

					if (studentsList.isEmpty()) {
						System.out.println("No students found .....");
					}
					for (Students s : studentsList) {
						System.out.println(s);
					}
					break;

				case 2:

					System.out.println("Enter Student Id :");
					int studentId = scanner.nextInt();

					Students student = studentService.getStudentById(studentId);
					if (student == null) {
						System.out.println("No student found for the id .....:" + studentId);
					} else {
						System.out.println(student);
					}

					break;

				case 3:
					studentId = new Random().nextInt(1000);

					System.out.println("Enter Student  Name:");
					String studentName = scanner.next();

					System.out.println("Enter Date:");
					String date = scanner.next();
					// Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);

					System.out.println("Enter Student nationality:");
					String nationality = scanner.next();

					System.out.println("Enter Student code:");
					String code = scanner.next();

					student = new Students(studentName, date, nationality, code);
					studentService.createStudent(student);

					System.out.println("Student has been created:" + student);

					break;

				case 4:

					System.out.println("Enter Student Id to update:");
					studentId = scanner.nextInt();

					System.out.println("Enter Student  Name:");
					studentName = scanner.next();

					System.out.println("Enter Date:");
					date = scanner.next();
					// Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);

					System.out.println("Enter Student nationality:");
					nationality = scanner.next();

					System.out.println("Enter Student code:");
					code = scanner.next();

					student = new Students(studentName, date, nationality, code);
					studentService.updateStudent(studentId, student);

					System.out.println("Student has been updated:" + student);

					break;

				case 5:
					System.out.println("Enter Student Id to delete :");
					studentId = scanner.nextInt();

					studentService.deleteStudentById(studentId);

					break;

				case 6:

					studentService.deleteAllStudents();

					System.out.println("All student have been deleted...");

					break;
				case 7:

					System.out.println("Enter Student Name :");
					String studentName1 = scanner.next();

					Students studentFound = studentService.getStudentByName(studentName1);
					if (studentFound == null) {
						System.out.println("No student found for the name .....:" + studentName1);
					} else {
						System.out.println(studentFound);
					}

					break;
				case 8:

					System.out.println("Enter Student entering date :");
					String studentDate = scanner.next();

					Students studentFoundForDate = studentService.getStudentByDate(studentDate);
					if (studentFoundForDate == null) {
						System.out.println("No student found for the date .....:" + studentDate);
					} else {
						System.out.println(studentFoundForDate);
					}

					break;
				case 9:

					System.out.println("Enter Student Name to find for update:");
					String studentNametoFind = scanner.next();

					System.out.println("Enter Student  Name:");
					String studentNametoUpdate = scanner.next();

					System.out.println("Enter Date:");
					date = scanner.next();

					System.out.println("Enter Student nationality:");
					nationality = scanner.next();

					System.out.println("Enter Student code:");
					code = scanner.next();

					student = new Students(studentNametoUpdate, date, nationality, code);
					studentService.updateStudentByName(studentNametoFind, student);

					System.out.println("Student has been updated:" + student);

					break;

				case 0:
					System.out.println("BYE...");
					System.exit(1);
					break;

				default:
					System.out.println("Invalid choice try again ......");
					break;

				}
			} while (choice != 0);

		} catch (NoSuchBeanDefinitionException noBeanEx) {
			System.err.println("********** NoSuchBeanDefinitionException ********** :" + noBeanEx.getMessage());
		} catch (Exception e) {
			System.err.println("********** invalid value entered ********** ");
			e.printStackTrace();
		}
	}

}