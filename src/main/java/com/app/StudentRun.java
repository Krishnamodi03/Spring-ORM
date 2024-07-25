package com.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentRun {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao sd = ac.getBean("studentDao", StudentDao.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1) for inserting new student");
			System.out.println("2) for displaying all the students");
			System.out.println("3) for displaying a single student");
			System.out.println("4) for deleting the student");
			System.out.println("5) for updating the student");
			System.out.println("6) for Exit");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter Name : ");
				String name = sc.nextLine();
				System.out.println("Enter Gender : ");
				String gender = sc.nextLine();
				System.out.println("Enter Age : ");
				int age = sc.nextInt();
				System.out.println("Enter Contact Number : ");
				long contactNo = sc.nextLong();

				Student s = new Student(name, gender, contactNo, age);

				int i = sd.saveStudent(s);
				System.out.println("==========================================");
				System.out.println("Data of Student with id " + i + " is inserted");
				System.out.println("==========================================");
				break;
			case 2:
				List<Student> students = sd.fetchAllStudent();
				System.out.println("==========================================");
				for (Student std : students) {
					System.out.println("Id : " + std.getId());
					System.out.println("Name : " + std.getName());
					System.out.println("Gender : "+std.getGender());
					System.out.println("Contact Number : "+std.getContactNo());
					System.out.println("Age : " + std.getAge());
					System.out.println("________________________");
				}
				System.out.println("==========================================");
				break;
			case 3:
				System.out.println("Enter Student Id : ");
				int sid = sc.nextInt();

				Student student = sd.fetchById(sid);
				if (student != null) {
					System.out.println("_________________________");
					System.out.println("Id : " + student.getId());
					System.out.println("Name : " + student.getName());
					System.out.println("Gender : "+student.getGender());
					System.out.println("Contact Number : "+student.getContactNo());
					System.out.println("Age : " + student.getAge());
					System.out.println("_________________________");
				} else {
					System.out.println("Wrong Student Id");
				}
				break;
			case 4:
				System.out.println("Enter Student Id : ");
				int sId = sc.nextInt();

				Student stdnt = sd.fetchById(sId);
				if (stdnt != null) {
					sd.deleteStudent(stdnt);
				} else {
					System.out.println("Wrong Student Id");
				}
				break;
			case 5:
				System.out.println("Enter Student Id : ");
				int SId = sc.nextInt();
				sc.nextLine();
				Student studnt = sd.fetchById(SId);

				if (studnt != null) {
					System.out.println("Enter Name : ");
					String newname = sc.nextLine();
					System.out.println("Enter Gender : ");
					String newgender = sc.nextLine();
					System.out.println("Enter Age : ");
					int newage = sc.nextInt();
					System.out.println("Enter Contact Number : ");
					long newcontactNo = sc.nextLong();

					studnt.setName(newname);
					studnt.setGender(newgender);
					studnt.setAge(newage);
					studnt.setContactNo(newcontactNo);

					sd.updateStudent(studnt);
				} else {
					System.out.println("Wrong Student Id");
				}
				break;
			case 6:
				System.out.println("Thank you!.");
				System.out.println("Have a Nice Day.....");
				return;
			default:
				System.out.println("Wrong Choice.");
				System.out.println("Chooose from below options only.");
				break;
			}

		}
	}
}
