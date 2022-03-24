package com.sherwin.flyaway.service;

import java.util.List;
import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.dao.BookingDao;


public class ViewService {
	BookingDao dao = new BookingDao();
	
	public List<ViewBean> search(ViewBean beanFromUser) {	
		return dao.search(beanFromUser);
	}	

	public List<ViewBean> viewTable(ViewBean beanFromUser) {
		return dao.viewTable(beanFromUser);
	}
	
	public ViewBean viewAllDetails(int flightNo) {
		return dao.viewDetails(flightNo);
	}
}