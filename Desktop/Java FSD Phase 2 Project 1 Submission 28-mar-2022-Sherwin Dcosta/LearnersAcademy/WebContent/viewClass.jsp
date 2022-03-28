<%@page import="com.sherwin.learners.bean.Teacher"%>
<%@page import="com.sherwin.learners.dao.TeacherDao"%>
<%@page import="com.sherwin.learners.bean.Student"%>
<%@page import="com.sherwin.learners.dao.StudentsDao"%>
<%@page import="com.sherwin.learners.dao.AllocateSubjectsForClassDao"%>
<%@page import="com.sherwin.learners.bean.SubjectClassBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	
	<%String className = request.getParameter("className"); %>
	
	<h1 align="center">Class <%=className%> </h1>
	<br>
	<hr>
	<table align ="center" border="1px">
	<caption>Subjects Aloated for class <%=className%></caption>
	<% AllocateSubjectsForClassDao dao = new AllocateSubjectsForClassDao(); %>
	<%List<SubjectClassBean> list = (List<SubjectClassBean>) dao.getDetails(className); %>
	<%for(SubjectClassBean viewbean: list) {%>
	<tr>
		<td>ClassName</td>
		<td>Subject1</td>
		<td>Subject 2</td>
		<td>Subject 3</td>
		<td>Subject 4</td>
		<td>Subject 5</td>
		<td>Subject 6</td>
	</tr>
	
	<tr>
		<td><%=viewbean.getClassName() %></td>
		<td><%=viewbean.getSubject1() %></td>
		<td><%=viewbean.getSubject2() %></td>
		<td><%=viewbean.getSubject3() %></td>
		<td><%=viewbean.getSubject4() %></td>
		<td><%=viewbean.getSubject5() %></td>
		<td><%=viewbean.getSubject6() %></td>
	</tr>
	</table>
	<%} %>
	<br>
	<hr>
	
	<table align="center" border="1px">
	<caption>Students on class <%=className%></caption>
	<%StudentsDao daoStudents = new StudentsDao(); %>
	<%List<Student> listStudents = (List<Student>) daoStudents.getStudents(className); %>
	
		<tr>
			<td>RollNo</td>
			<td>FirstName</td>
			<td>LastName</td>
		</tr>
		<%for(Student viewbeanSt: listStudents) {%>
		<tr>
			<td><%=viewbeanSt.getRollNo() %></td>
			<td><%=viewbeanSt.getFirstName() %></td>
			<td><%=viewbeanSt.getLastName() %></td>
		</tr>
		<%} %>
	</table>
	<br>
	<hr>
	<br>
	<table align="center" border="1px">
	<caption>Teachers allocated on class <%=className%></caption>
	<%TeacherDao daoTeachers = new TeacherDao(); %>
	<%List<Teacher> listteacher = (List<Teacher>) daoTeachers.getTeacherListClass(className); %>
	
		<tr>
			<td>TeacherId</td>
			<td>FirstName</td>
			<td>LastName</td>
		</tr>
		<%for(Teacher viewbeanSt: listteacher) {%>
		<tr>
			<td><%=viewbeanSt.getId() %></td>
			<td><%=viewbeanSt.getFirstName() %></td>
			<td><%=viewbeanSt.getLastName() %></td>
		</tr>
		<%} %>
	</table>
	 
	</div>
	
</body>
</html>