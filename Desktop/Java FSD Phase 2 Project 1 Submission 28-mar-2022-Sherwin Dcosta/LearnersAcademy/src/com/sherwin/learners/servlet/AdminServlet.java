package com.sherwin.learners.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherwin.learners.bean.AdminBean;
import com.sherwin.learners.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		AdminService service = new AdminService();
		HttpSession session = request.getSession();
		
		if(btn.equalsIgnoreCase("sign-in")) {
			System.out.println("post of user servlet");
			
			String adminName = request.getParameter("username");
			String password = request.getParameter("password");
			
			AdminBean beanFromUser = new AdminBean();
			beanFromUser.setAdminName(adminName);
			beanFromUser.setPassword(password);
			try {
				boolean result = service.login(beanFromUser);
				if(result==false) {
					RequestDispatcher rd = request.getRequestDispatcher("/LoginError.html");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("/AdminHome.jsp");
					session.setAttribute("adminName", adminName);
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(btn.equalsIgnoreCase("Students")) {
			RequestDispatcher rd = request.getRequestDispatcher("/students.jsp");
			rd.forward(request, response);
		}
	}

}
