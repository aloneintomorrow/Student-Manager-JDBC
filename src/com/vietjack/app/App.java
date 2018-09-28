package com.vietjack.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.vietjack.core.Student;
import com.vietjack.dao.StudentDAO;

public class App {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
	private static StudentDAO studentDAO = new StudentDAO();
	private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws SQLException, ParseException {
	boolean flag = true;
	while(flag) {
		printAction();
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			addNewStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			findStudentByIdDB();
			break;
		case 4:
			deleteStudent();
			break;
		case 10:
			flag = false;
			break;
		}
	}
}
private static void deleteStudent() throws SQLException {
	System.out.println("Nhap ID can xoa: ");
	int id = scanner.nextInt();
	scanner.nextLine();
	studentDAO.deleteStudent(id);
}
private static void findStudentByIdDB() throws SQLException {
	System.out.println("Nhap ID can tim: ");
	int id = scanner.nextInt();
	scanner.nextLine();
	studentDAO.findStudentByIdDB(id);
}
private static void updateStudent() throws ParseException, SQLException {
	System.out.println("Nhap Id can cap nhat:");
	int id = scanner.nextInt();
	scanner.nextLine();
	Student student = studentDAO.findStudentById(id);
	if(student ==null) {
		System.out.println("Khong tim thay Id");
	}else {
	System.out.println("Nhap Ten: ");
	String name = scanner.nextLine();
	System.out.println("Nhap ngay sinh: ");
	String dob = scanner.nextLine();
	Date date = sdf.parse(dob);
	String dob1 = sdf.format(date);
	Student student1 =new Student(id, name, dob1);
	System.out.println("Nhap Id Toan");
	int idMath = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Nhap Id Ly");
	int idPhysics = scanner.nextInt();
	scanner.nextLine();
	student1.inputID(idMath, idPhysics);
	studentDAO.updateStudent(student1);
}
}
private static void addNewStudent() throws SQLException, ParseException {
	int id = studentDAO.generateID();
	System.out.println("Nhap Ten: ");
	String name = scanner.nextLine();
	System.out.println("Nhap ngay sinh: ");
	String dob = scanner.nextLine();
	Date date = sdf.parse(dob);
	String dob1 = sdf.format(date);
	Student student =new Student(id, name, dob1);
	System.out.println("Nhap Id Toan");
	int idMath = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Nhap Id Ly");
	int idPhysics = scanner.nextInt();
	scanner.nextLine();
	student.inputID(idMath, idPhysics);
	studentDAO.addStudent(student);
}
private static void printAction() {
	System.out.println("1.Add New Student");
	System.out.println("2. Update Student");
	System.out.println("3. Find Student by Id");
	System.out.println("4. delete Student by Name");
	System.out.println("10. Exit");
}
}
