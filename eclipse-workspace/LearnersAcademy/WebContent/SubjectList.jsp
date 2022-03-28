<%@page import="com.sherwin.learners.service.SubjectService"%>
<%@page import="com.sherwin.learners.dao.SubjectDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sherwin.learners.bean.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects | Learner's Academy</title>
</head>
<body>
<body>
<jsp:include page="nav.html" />
	<%
	SubjectService dao = new SubjectService();
	List<Subject> bean =(List<Subject>) dao.getSubjectList();
	%>
	<a href="addSubject.jsp">Add Student</a>
	<div>
		<h1>Subjects</h1>
	<form method="get" action="DeleteSubjectServlet">
	<table align="center">
	<tr>
		<th >SNo.</th>
		<th >Subject Name</th>
		<th >Delete Subject</th>
	</tr>
	
	<%		
			for(Subject viewbean: bean) {	
	%>
		
	<tr>
		<td><%=viewbean.getId() %></td>
		<td><%=viewbean.getName() %></td>
		<td><button type="submit" name="btn-subject" value="<%=viewbean.getId()%>" >delete</button></td>
	</tr>
	<% } %>
	</table>
	</form>
	</div>
</body>
</body>
</html>