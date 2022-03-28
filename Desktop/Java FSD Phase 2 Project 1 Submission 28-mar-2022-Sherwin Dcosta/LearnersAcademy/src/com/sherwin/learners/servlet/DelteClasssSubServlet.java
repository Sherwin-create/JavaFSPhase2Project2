package com.sherwin.learners.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.learners.dao.AllocateSubjectsForClassDao;

/**
 * Servlet implementation class DelteClasssSubServlet
 */
public class DelteClasssSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String className = (String) session.getAttribute("className");
		AllocateSubjectsForClassDao dao = new AllocateSubjectsForClassDao();
		boolean result = dao.deleteSubjects(className);
		if(result) {
			RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/eroor.html");
			rd.forward(request, response);
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
