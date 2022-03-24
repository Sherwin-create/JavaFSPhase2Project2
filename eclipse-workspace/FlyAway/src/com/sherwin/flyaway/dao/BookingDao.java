package com.sherwin.flyaway.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.util.DBconnection;

public class BookingDao {
	public List<ViewBean> search(ViewBean beanFromUser) {
		List<ViewBean> listSourceDestination = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		String query = "select * from bookig_table where source = '" +beanFromUser.getSource() +
				"' and destination = '" + beanFromUser.getDestination()+
				"' and tickets >= " + beanFromUser.getTickets();
//				+ 
//				" and travel_date = '"+beanFromUser.getTravelDate() +
//				"'";
			 	
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				System.out.println(query);
			
				while(rs.next()) {
					ViewBean bean = new ViewBean();
					bean.setSource((rs.getString(2)));
					bean.setDestination((rs.getString(3)));
					//bean.setTravelDate((rs.getString(4)));
					bean.setTickets((rs.getInt(5)));
					listSourceDestination.add((bean));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listSourceDestination;
	}
	
	public List<ViewBean> viewTable(ViewBean beanFromJsp) {
		List<ViewBean> listViewTable = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		
		String query = "select * from bookig_table where source = '" + beanFromJsp.getSource() +
				"' and destination = '" + beanFromJsp.getDestination()+
				"' and tickets >= " + beanFromJsp.getTickets();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);
			
			while(rs.next()) {
				ViewBean bean = new ViewBean();
				
				bean.setSource((rs.getString(1)));
				bean.setDestination((rs.getString(2)));
				bean.setTravelDate((rs.getString(3)));
				bean.setTickets((rs.getInt(4)));
				bean.setPrice(rs.getInt(5));
				bean.setAirlineName(rs.getString(6));
				bean.setFlightNo(rs.getInt(7));
				listViewTable.add((bean));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listViewTable;
		
	}
	
	public  List<ViewBean> viewDetails(int flightNo) {
		List<ViewBean> listViewTable = new ArrayList<ViewBean>();
		Connection con = DBconnection.getConnection();
		
		String query = "select * from bookig_table where flight_no = "+ flightNo;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println(query);
			
			while(rs.next()) {
				ViewBean bean = new ViewBean();
				
				bean.setSource((rs.getString(1)));
				bean.setDestination((rs.getString(2)));
				bean.setTravelDate((rs.getString(3)));
				bean.setTickets((rs.getInt(4)));
				bean.setPrice(rs.getInt(5));
				bean.setAirlineName(rs.getString(6));
				bean.setFlightNo(rs.getInt(7));
				listViewTable.add((bean));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listViewTable;
	}
//	public static void main(String args[]) throws ClassNotFoundException, SQLException {
//		System.out.println("main");
//		BookingDao dao = new BookingDao();
//		ViewBean beanFromUser = new ViewBean();
//		
//		String source = "Mangalore";
//		String destination="Jaipur";
//		String travelDate="2022-04-23";
//		int tickets=10;
//		
//		beanFromUser.setSource(source);
//		beanFromUser.setDestination(destination);
//		beanFromUser.setTravelDate(travelDate);
//		beanFromUser.setTickets(tickets);
//		System.out.println(travelDate);
//		
//		List<ViewBean> listOfResult = dao.viewTable(beanFromUser);	
//		if(listOfResult.isEmpty()) {
//			System.out.println("no data");
//		}
//		else {
//			for(ViewBean viewbean: listOfResult) {	
//				System.out.println("airline no. " + viewbean.getAirlineCode());
//				System.out.println("source "+ viewbean.getSource());
//				System.out.println("destination: "+ viewbean.getDestination());
//				System.out.println("date :" + viewbean.getTravelDate());
//				System.out.println("tickets: " + viewbean.getTickets());
//				System.out.println("price :" + viewbean.getPrice());
//			}
//		}
//	}
}
