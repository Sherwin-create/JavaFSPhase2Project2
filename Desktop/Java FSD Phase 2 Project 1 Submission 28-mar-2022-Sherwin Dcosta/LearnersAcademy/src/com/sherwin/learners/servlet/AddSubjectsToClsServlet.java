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

import com.sherwin.learners.bean.Subject;
import com.sherwin.learners.bean.SubjectClassBean;
import com.sherwin.learners.bean.SubjectTeacher;
import com.sherwin.learners.bean.SubjectTeacherBean;
import com.sherwin.learners.dao.FindSubjectByNameDAO;
import com.sherwin.learners.service.SubjectsForClassService;

/**
 * Servlet implementation class 
 */
public class AddSubjectsToClsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String subject1 = request.getParameter("subjectChosen1");
		String subject2 = request.getParameter("subjectChosen2");
		String subject3 = request.getParameter("subjectChosen3");
		String subject4 = request.getParameter("subjectChosen4");
		String subject5 = request.getParameter("subjectChosen5");
		String subject6 = request.getParameter("subjectChosen6");
		String className = (String) session.getAttribute("className");
//		
//		Subject sub1 = new Subject();
//		Subject sub2 = new Subject();
//		Subject sub3 = new Subject();
//		
//		List<SubjectTeacher> teacherList1 = new ArrayList<SubjectTeacher>();
//		List<SubjectTeacher> teacherList2 = new ArrayList<SubjectTeacher>();
//		List<SubjectTeacher> teacherList3 = new ArrayList<SubjectTeacher>();
//		List<Subject> subjectList = new ArrayList<Subject>();
//		subjectList.add(sub1);
//		subjectList.add(sub2);
//		subjectList.add(sub3);
		SubjectClassBean beanFromUser = new SubjectClassBean();
//		
//		sub1 = new FindSubjectByNameDAO().findSubjectByName(subject1);
//		sub2 = new FindSubjectByNameDAO().findSubjectByName(subject2);
//		sub3 = new FindSubjectByNameDAO().findSubjectByName(subject3);
//		
//		teacherList1 = new SubjectTeacherDAO().getSubjectList(sub1);
//		teacherList2 = new SubjectTeacherDAO().getSubjectList(sub2);
//		teacherList3 = new SubjectTeacherDAO().getSubjectList(sub3);
		
		beanFromUser.setClassName(className);
		beanFromUser.setSubject1(subject1);
		beanFromUser.setSubject2(subject2);
		beanFromUser.setSubject3(subject3);
		beanFromUser.setSubject4(subject4);
		beanFromUser.setSubject5(subject5);
		beanFromUser.setSubject6(subject6);
		SubjectsForClassService service = new SubjectsForClassService();
		boolean listOfResult = service.addSubjects(beanFromUser) ;
		
		if(listOfResult) {
			request.setAttribute("beanFromUser",beanFromUser);
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
