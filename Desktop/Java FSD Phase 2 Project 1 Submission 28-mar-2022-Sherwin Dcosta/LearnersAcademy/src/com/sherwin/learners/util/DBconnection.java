package com.sherwin.learners.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	public static Connection getConnection() {
		Connection con = null;
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String uname = "system";
				String pass = "sherwin";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, uname, pass);
				System.out.println("connection successfull");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
	}
	
//	public static void main(String args[]) {
//		Connection con = DBconnection.getConnection();
//	}
}
