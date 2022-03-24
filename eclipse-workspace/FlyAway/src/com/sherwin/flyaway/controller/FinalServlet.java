package com.sherwin.flyaway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FinalServlet
 */
public class FinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int tickets = (int) session.getAttribute("tickets");
		int price = (int) session.getAttribute("price");
		int noOfTicketsOrdered = Integer.parseInt(request.getParameter("noOfTickets"));
		
		if( noOfTicketsOrdered > tickets) {
			System.out.println("u excedded the no. of tickets available");
		}
		else {
			int finalPrice = price * noOfTicketsOrdered;
			session.setAttribute("finalPrice", finalPrice);
			RequestDispatcher rd = request.getRequestDispatcher("/DummyPayment.jsp");
			rd.forward(request,response);
		}
	}

}
