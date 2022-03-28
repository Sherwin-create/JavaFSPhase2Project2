package com.sherwin.learners.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.learners.dao.TeacherDao;

/**
 * Servlet implementation class AddClassToTeacher
 */
public class AddClassToTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classChosen = request.getParameter("classChosen");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		
		TeacherDao dao = new TeacherDao();
		boolean result = dao.updateClassForTeacher(classChosen, id);
		
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
