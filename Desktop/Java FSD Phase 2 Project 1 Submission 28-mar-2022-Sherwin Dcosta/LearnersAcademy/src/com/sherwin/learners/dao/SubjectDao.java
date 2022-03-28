package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.bean.Subject;
import com.sherwin.learners.util.DBconnection;

public class SubjectDao {
	public List<Subject> getSubjectList(){
		try {
			String QUERY = "select * from subjects";
			Connection connection = DBconnection.getConnection();
			Subject subject; //subject bean
			PreparedStatement statement = connection.prepareStatement(QUERY);
			List<Subject> subjectList = new ArrayList<Subject>();
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				subject = new Subject();
				subject.setName(set.getString(2));
				subject.setId(set.getInt(1));
				subjectList.add(subject);
			}
			return subjectList;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteSubject(int id) {
		boolean isDeleted = true;
		String query = "delete subjects where subjectno = ?";
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
	

	public boolean addSubjects(String subjectName) {
		String INSERT = "insert into subjects values (subjectno.nextval, '" + subjectName + "')";
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
}
