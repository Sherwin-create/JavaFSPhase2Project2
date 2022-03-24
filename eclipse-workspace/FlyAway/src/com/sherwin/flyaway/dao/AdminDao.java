package com.sherwin.flyaway.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.flyaway.bean.AdminBean;
import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.util.DBconnection;

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
	
	public boolean editByUserPassword(String currPass,String newPass) {
		boolean updateStatus = false;
		Connection con = DBconnection.getConnection();
		String query = "update admin_login set password ='"+ newPass + "' where password = '" 
							+ currPass +"'";
			
			try {
				Statement stmt; 
				System.out.println(currPass);
				System.out.println(newPass);
				stmt = con.createStatement();
				
				//pstmt.setString(1, newPass);
				int value = stmt.executeUpdate(query);
				if(value> 0) {
					updateStatus = true;
				}
				System.out.println("Rows impacted are:" + value);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(query);
		return updateStatus;
	}
	
	public List<ViewBean> viewSourceDestination() {
		List<ViewBean> listViewTable = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		
		String query = "select distinct source,destination from bookig_table";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);
			
			while(rs.next()) {
				ViewBean bean = new ViewBean();		
				bean.setSource((rs.getString(1)));
				bean.setDestination((rs.getString(2)));
				listViewTable.add((bean));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listViewTable;
	}
	
	public List<ViewBean> viewAirlines() {
		List<ViewBean> listViewTable = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		
		String query = "select distinct airline_name from bookig_table";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);
			
			while(rs.next()) {
				ViewBean bean = new ViewBean();		
				bean.setAirlineName((rs.getString(1)));
				listViewTable.add((bean));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listViewTable;
	}
	
	public List<ViewBean> listFlights() {
		List<ViewBean> listViewTable = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		
		String query = "select source,destination,airline_name,price from bookig_table";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);
			
			while(rs.next()) {
				ViewBean bean = new ViewBean();	
				bean.setSource(rs.getString(1));
				bean.setDestination(rs.getString(2));
				bean.setAirlineName((rs.getString(3)));
				bean.setPrice((rs.getInt(4)));
				listViewTable.add((bean));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listViewTable;
	}
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//	//update status
//		AdminDao user = new AdminDao();
//		//AdminBean bean = new AdminBean();
////		
////		bean.setAdminName("sherwin");
////		bean.setPassword("sher");
//		System.out.println(user.editByUserPassword("sher14","jerr"));
//		
//		//
////		if(bean!=null) {
////		System.out.println("name: "+ bean.getAdminName());
////		System.out.println("password : "+ bean.getPassword());
////		}
////		else {
////			System.out.println("This Admin - " + adminName + " is not availabe in database table");
////		}
//	}
}
