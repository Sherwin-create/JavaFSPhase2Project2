package com.sherwin.learners.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sherwin.learners.bean.AdminBean;
import com.sherwin.learners.util.DBconnection;



public class AdminDao {
	public AdminBean getAdminByUserName(String adminName, String password) throws ClassNotFoundException, SQLException {	
		Connection con = DBconnection.getConnection();
		AdminBean bean = new AdminBean();
		String query = "select * from admin_login where admin_name = '" + adminName +
				"' and password = '"+password +"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
			
		System.out.println(query);
			
		if(rs.next()) {
			bean.setAdminName(rs.getString(1));
			bean.setPassword(rs.getString(2));
		}
		else {
			bean = null;
		}
		return bean;
	}
	
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//	   //check admin name and password 
//		AdminDao user = new AdminDao();
//		AdminBean bean = new AdminBean();
//		
//		bean.setAdminName("sherwin");
//		bean.setPassword("sheru");
//		AdminBean beanFromDB = user.getAdminByUserName(bean.getAdminName(),bean.getPassword());
//		boolean result = false;
//		if(user != null ) {
//			if(bean.getAdminName().equals(beanFromDB.getAdminName())
//					&& bean.getPassword().equals(beanFromDB.getPassword())) {
//						result = true;
//					}
//		}
//		System.out.println(result);
//	}
}
