package com.sherwin.learners.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.learners.bean.SubjectTeacherBean;
import com.sherwin.learners.util.DBconnection;

public class AllocateSubjectsForTeachersDao {
	
	public boolean updateSubjects(int id,String subject1,String subject2,String subject3) {
		int rowsaffected;
		boolean isadded = true;
		
		String query = "UPDATE teacher " + 
				"SET subject1='" + subject1 +"',subject2='"+subject2 +"',subject3='" 
				+ subject3+"' WHERE teacherid=" + id;
		
		try {
				Connection con = DBconnection.getConnection();
				Statement st = con.createStatement();
				rowsaffected = st.executeUpdate(query);
				System.out.println(rowsaffected);
				if(rowsaffected == 0)
				{
					isadded = false;
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isadded;
	}
	
	public List<SubjectTeacherBean> listSubjectsTeachers(String subject) {
		List<SubjectTeacherBean> subjectList = new ArrayList<SubjectTeacherBean>();
		try {
			
			String QUERY ="SELECT firstname from teacher where "+
					"subject1='"+ subject +"' or subject2=' "+ subject 
					+"' or subject3='"+ subject +"'";
			Connection con = DBconnection.getConnection();
			PreparedStatement statement = con.prepareStatement(QUERY);
		
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				SubjectTeacherBean student = new SubjectTeacherBean();
				student.setSubject1(set.getString(1));
				subjectList.add(student);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return subjectList;
	}
}

