package com.sherwin.flyaway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.flyaway.bean.SourceDestinationBean;
import com.sherwin.flyaway.bean.ViewBean;
import com.sherwin.flyaway.service.ViewService;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		
		if(btn.equalsIgnoreCase("search")) {
			System.out.println("post of view servlet");
			
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			int tickets = Integer.parseInt(request.getParameter("tickets"));	
			String travelDate = request.getParameter("travelDate");
			System.out.println(travelDate);
			
			
			ViewService service = new ViewService();
			
			ViewBean beanFromUser = new ViewBean();
			beanFromUser.setSource(source);
			beanFromUser.setDestination(destination);
			beanFromUser.setTickets(tickets);
			//beanFromUser.setTravelDate(travelDate);
			List<ViewBean> listOfResult = service.search(beanFromUser);
		
			if(listOfResult.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/NoRoute.html");
				rd.forward(request,response);
			}
			else {
				List<ViewBean> sendView = service.viewTable(beanFromUser);
				request.setAttribute("viewObj", sendView);
//				session.setAttribute("source",source);
//				session.setAttribute("destination", destination);
//				session.setAttribute("tickets", tickets);
//				session.setAttribute("travelDate", travelDate);
				RequestDispatcher rd = request.getRequestDispatcher("/ViewBooking.jsp");
				rd.forward(request,response);
			}
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
