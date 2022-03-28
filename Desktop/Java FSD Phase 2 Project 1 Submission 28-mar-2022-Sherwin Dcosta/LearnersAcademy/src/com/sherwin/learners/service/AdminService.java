package com.sherwin.learners.service;

import java.sql.SQLException;

import com.sherwin.learners.bean.AdminBean;
import com.sherwin.learners.dao.AdminDao;



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
}
