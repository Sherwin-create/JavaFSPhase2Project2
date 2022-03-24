package com.sherwin.flyaway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.service.ViewService;

public class ViewServletBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello to booking servlet");
		//from viewbooking.jsp
		int flightNo = Integer.parseInt(request.getParameter("btn-book"));
		HttpSession session = request.getSession();
		ViewService service = new ViewService();
		List<ViewBean> listOfResult = service.viewAllDetails(flightNo);
		
		if(listOfResult.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/NoRoute.html");
			rd.forward(request,response);
		}
		else {
			session.setAttribute("flightDetailsObj",flightNo );
			//send to CustomerDetails.jsp and view all the flight details + the form
			RequestDispatcher rd = request.getRequestDispatcher("/CustomerDetails.jsp");
			rd.forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
