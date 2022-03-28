package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.util.DBconnection;
import com.sherwin.learners.bean.ClassBean;

public class ClassDao {
	
	public List<ClassBean> getClassList(){
		
		 String QUERY = "Select * from classes";
		 ClassBean cls;
		 List<ClassBean> classList = new ArrayList<ClassBean>();
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				cls = new ClassBean();
				cls.setName(set.getString(2));
				cls.setId(set.getInt(1));				
				classList.add(cls);
			}
			return classList;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addClass(String className) {
		String INSERT = "insert into classes values (classno.nextval, '" + className + "')";
		int rowsaffected;
		boolean isadded = true;
		try {
			Connection connection = DBconnection.getConnection();
			Statement st = connection.createStatement();
			rowsaffected = st.executeUpdate(INSERT);
			System.out.println(rowsaffected);
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
	
	public boolean deleteClass(int id) {
		boolean isDeleted = true;
		String query = "delete classes where classno = ?";
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
	

}
