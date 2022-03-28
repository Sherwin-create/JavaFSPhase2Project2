package com.sherwin.learners.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.learners.bean.SubjectClassBean;
import com.sherwin.learners.service.SubjectsForClassService;

/**
 * Servlet implementation class AlloClassSubjectServlet
 */
public class AlloClassSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = request.getParameter("classname");
		HttpSession session = request.getSession();
		System.out.println(className);
		SubjectsForClassService service = new SubjectsForClassService();
		List<SubjectClassBean> classList = service.getDetails(className);
		session.setAttribute("className", className);
		if(classList.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/AllocateSubjects.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/SubjectsAllocated.jsp");
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
