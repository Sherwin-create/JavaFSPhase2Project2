package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sherwin.learners.bean.Subject;
import com.sherwin.learners.util.DBconnection;

public class FindSubjectByNameDAO {

	private final String FIND = "select * from subjects where name = ?";
	Subject subject = new Subject();
	
	
	public Subject findSubjectByName(String name) {
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(FIND);
			
			statement.setString(1, name);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				subject.setId(set.getInt(1));
				subject.setName(set.getString(2));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return subject;
	}
}
