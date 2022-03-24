package com.sherwin.flyaway.service;

import java.sql.SQLException;
import java.util.List;

import com.sherwin.flyaway.bean.AdminBean;
import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.dao.AdminDao;


public class AdminService {
	AdminDao adminDao = new AdminDao();
	public boolean login(AdminBean beanFromUser) throws ClassNotFoundException, SQLException {
		
		AdminBean beanFromDB = adminDao.getAdminByUserName(beanFromUser.getAdminName(),beanFromUser.getPassword());
		boolean result = false;
		if(beanFromDB != null ) {
			if(beanFromUser.getAdminName().equals(beanFromDB.getAdminName())
					&& beanFromUser.getPassword().equals(beanFromDB.getPassword())) {
						result = true;
					}
		}
		return result;
	}
	
	public boolean editPassword(String currPass,String newPass) {
		return adminDao.editByUserPassword(currPass,newPass);
	}
	
	public List<ViewBean> sourceDestination() {
		return adminDao.viewSourceDestination();
	}
	
	public List<ViewBean> listOfAirlines() {
		return adminDao.viewAirlines();
	}
	
	public List<ViewBean> listFlights() {
		return adminDao.listFlights();
	}
}
