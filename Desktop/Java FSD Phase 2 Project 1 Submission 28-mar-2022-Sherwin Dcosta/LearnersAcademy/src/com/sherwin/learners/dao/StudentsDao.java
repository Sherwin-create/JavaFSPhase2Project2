package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.bean.Student;
import com.sherwin.learners.util.DBconnection;

public class StudentsDao {


	private Student student;
	private List<Student> studentList = new ArrayList<Student>();
		
	public List<Student> getStudentList(){
		try {
			String QUERY = "select * from student";
			Connection con = DBconnection.getConnection();
			PreparedStatement statement = con.prepareStatement(QUERY);
		
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				student = new Student();
				student.setRollNo(set.getInt(1));
				student.setFirstName(set.getString(2));
				student.setLastName(set.getString(3));
				studentList.add(student);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}
	
	public boolean deleteStudent(int id) {
		boolean isDeleted = true;
		String query = "delete from student where rollNo= ?";
		try {
			Connection connection = DBconnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			int rowsaffected = statement.executeUpdate();
			if(rowsaffected == 0) {
				isDeleted = false;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isDeleted;
	}
	

	public boolean addStudent(String firstName, String lastName) {
		String INSERT = "insert into student(rollno,firstname,lastname) values (rollno.nextval, '" + firstName + 
				"','" + lastName + "')";
		int rowsaffected;
		boolean isadded = true;
		try {
			Connection connection = DBconnection.getConnection();
			Statement st = connection.createStatement();
			rowsaffected = st.executeUpdate(INSERT);
		
			if(rowsaffected == 0)
			{
				isadded = false;
			}
		}
		catch(SQLIntegrityConstraintViolationException e) 
		{
		System.out.println(e);
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isadded;
	}
	
	public boolean addClass(int rollNo,String className) {
		String INSERT = "UPDATE student " + 
				"SET classname= '" + className +
				"' WHERE rollNo=" + rollNo;
		int rowsaffected;
		boolean isadded = true;
		try {
			Connection connection = DBconnection.getConnection();
			Statement st = connection.createStatement();
			rowsaffected = st.executeUpdate(INSERT);
		
			if(rowsaffected == 0)
			{
				isadded = false;
			}
		}
		catch(SQLIntegrityConstraintViolationException e) 
		{
		System.out.println(e);
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isadded;
	}
	
	public  List<Student> getStudents(String className){
		try {
			String QUERY = "select * from student where classname = '"+ className + "'" ;
			Connection con = DBconnection.getConnection();
			PreparedStatement statement = con.prepareStatement(QUERY);
		
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				student = new Student();
				student.setRollNo(set.getInt(1));
				student.setFirstName(set.getString(2));
				student.setLastName(set.getString(3));
				studentList.add(student);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}
}

