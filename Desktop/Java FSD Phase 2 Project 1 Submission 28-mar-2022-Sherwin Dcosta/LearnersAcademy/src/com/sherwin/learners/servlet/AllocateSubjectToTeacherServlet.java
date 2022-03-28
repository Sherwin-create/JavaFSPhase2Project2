package com.sherwin.learners.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.learners.dao.AllocateSubjectsForTeachersDao;

/**
 * Servlet implementation class AllocateSubjectToTeacherServlet
 */
public class AllocateSubjectToTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllocateSubjectsForTeachersDao dao = new AllocateSubjectsForTeachersDao();
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String subject1 = request.getParameter("subjectChosen1");
		String subject2 = request.getParameter("subjectChosen2");
		String subject3 = request.getParameter("subjectChosen3");
		boolean result = dao.updateSubjects(id, subject1, subject2, subject3);
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
