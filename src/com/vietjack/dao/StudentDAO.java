package com.vietjack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vietjack.core.Student;

public class StudentDAO {
	private Connection connection;
	public Connection getConnection() {
		if(connection ==null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "123456");
				return connection;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	public void closeConnection() {
		if(connection !=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean addStudent(Student student) throws SQLException {
		String query ="insert into STUDENT values(?,?,?,?,?)";
		PreparedStatement ps =getConnection().prepareStatement(query);
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setString(3,student.getDob());
		ps.setInt(4, student.getIDMath());
		ps.setInt(5, student.getPhysics());
		int n = ps.executeUpdate();
		if(n ==0) {
			return true;
		}else {
			return false;
		}	
	}
	public int generateID() throws SQLException {
		String query ="select max(id) as maxId from STUDENT ";
		Statement statement = getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		if(resultSet.next()) {
			return resultSet.getInt("maxId")+1;
		}else {
			return 0;
		}
	}
	public boolean updateStudent(Student student) throws SQLException {
		String query="update STUDENT set name =?, dob =?, math_id=?, physics_id=? where id =?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1,student.getName());
		ps.setString(2, student.getDob());
		ps.setInt(3, student.getIDMath());
		ps.setInt(4, student.getPhysics());
		ps.setInt(5, student.getId());
		int n = ps.executeUpdate();
		if(n!=0) {
			System.out.println("Update Complete");
			return true;
		}else {
			return false;
		}
	}
	public Student findStudentById(int id) throws SQLException {
		String query ="select * from STUDENT where id="+id+"";
		Statement statement = getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		if(resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getInt("id"));
			return student;
		}else {
			return null;
		}
	}
	public void findStudentByIdDB(int id) throws SQLException {
		String query ="SELECT * FROM student where id ="+id+"";
		Statement statement = getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString("name")+resultSet.getString("dob")+resultSet.getInt("math_id")+resultSet.getInt("physics_id"));
		}
	}
	public boolean deleteStudent(int id) throws SQLException {
		String query = "delete from STUDENT where id =?";
		PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setInt(1, id);
		int n = ps.executeUpdate();
		if(n !=0) {
			System.out.println("Update Complete");
			return true;
		}else {
			return false;
		}
	}
}

