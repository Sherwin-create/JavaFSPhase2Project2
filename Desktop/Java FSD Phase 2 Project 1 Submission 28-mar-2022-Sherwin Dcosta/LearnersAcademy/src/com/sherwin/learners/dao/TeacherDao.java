package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.bean.Teacher;
import com.sherwin.learners.util.DBconnection;

public class TeacherDao {
	
	public List<Teacher> getTeacherList(){
		String QUERY = "select * from teacher";
		Teacher teacher;
		List<Teacher> teacherList = new ArrayList<Teacher>(); 
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				teacher = new Teacher();
				teacher.setId(set.getInt(1));
				teacher.setFirstName(set.getString(2));
				teacher.setLastName(set.getString(3));
				teacherList.add(teacher);
			}
			return teacherList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean addTeacher(String firstName,String lastName) {
		String ADD = "insert into teacher(teacherid,firstname,lastname) values  (teacherid.nextval,'"+ firstName +"' , '"
				+ lastName + "')";
		int rowsAffected = 0;
		boolean isadded = true;
		try {
			Connection connection = DBconnection.getConnection();
			Statement st = connection.createStatement();
			rowsAffected = st.executeUpdate(ADD);
			System.out.println(rowsAffected);
			if(rowsAffected == 0)
				{isadded = false;}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isadded;
	}
 
	
	public boolean deleteTeacher(int id) {
		 int rowsaffected = 0;
		 boolean isdeleted = true;
		try {
			String DELETE = "delete teacher where teacherid = ?";
			
			Connection connection =  DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE);
			
			statement.setInt(1, id);
			
			rowsaffected = statement.executeUpdate();
			if(rowsaffected == 0) isdeleted = false;
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isdeleted;
	}
	
	public boolean updateClassForTeacher(String className,int id) {
		 int rowsaffected = 0;
		 boolean isupdated = true;
		try {
			String update = "update teacher SET classname='"+ className +"' where teacherid = " + id;
				Connection connection = DBconnection.getConnection();
				Statement st = connection.createStatement();
				rowsaffected = st.executeUpdate(update);
				System.out.println(rowsaffected);
				if(rowsaffected == 0)
					{isupdated = false;}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return isupdated;
	}
	public List<Teacher> getTeacherListClass(String classname){
		String QUERY = "select * from teacher where classname = '" + classname +"'";
		Teacher teacher;
		List<Teacher> teacherList = new ArrayList<Teacher>(); 
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				teacher = new Teacher();
				teacher.setId(set.getInt(1));
				teacher.setFirstName(set.getString(2));
				teacher.setLastName(set.getString(3));
				teacherList.add(teacher);
			}
			return teacherList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
