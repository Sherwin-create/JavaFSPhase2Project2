package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.bean.SubjectClassBean;
import com.sherwin.learners.util.DBconnection;

public class AllocateSubjectsForClassDao {

	public List<SubjectClassBean> getDetails(String className){
		 SubjectClassBean bean;
		 String QUERY = "Select * from class_subject where classname = '" + className + "'";
		 List<SubjectClassBean> classList = new ArrayList<SubjectClassBean>();
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QUERY);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				bean = new SubjectClassBean();
				bean.setClassName(set.getString(1));
				bean.setSubject1(set.getString(2));	
				bean.setSubject2(set.getString(3));
				bean.setSubject3(set.getString(4));
				bean.setSubject4(set.getString(5));
				bean.setSubject5(set.getString(6));
				bean.setSubject6(set.getString(7));
				classList.add(bean);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return classList;
	}
	
	public boolean addSubjects(SubjectClassBean beanFromUser) {
		boolean isAdded = true;
		String query = "insert into class_subject values(?,?,?,?,?,?,?)";
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, beanFromUser.getClassName());
			statement.setString(2, beanFromUser.getSubject1());
			statement.setString(3, beanFromUser.getSubject2());
			statement.setString(4, beanFromUser.getSubject3());
			statement.setString(5, beanFromUser.getSubject4());
			statement.setString(6, beanFromUser.getSubject5());
			statement.setString(7, beanFromUser.getSubject6());
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected == 0) {
				isAdded = false;
			}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}
	
	public boolean deleteSubjects(String className) {
		boolean isDeleted = true;
		String query = "delete class_subject where classname = ?";
		try {
			Connection connection = DBconnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, className);
			
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
