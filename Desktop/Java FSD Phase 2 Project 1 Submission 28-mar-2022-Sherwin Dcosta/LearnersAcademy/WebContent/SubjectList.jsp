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
<style>
.sub-head {
	text-align: center;
}
th
{
	margin:3px;
	padding:10px;
	text-align: center;
	background-color: #DCD9D4;
	 background-image: linear-gradient(to bottom, rgba(255,255,255,0.50) 0%, rgba(0,0,0,0.50) 100%), radial-gradient(at 50% 0%, rgba(255,255,255,0.10) 0%, rgba(0,0,0,0.50) 50%);
	 background-blend-mode: soft-light,screen;
}
td {
	margin:3px;
	padding:10px;
	text-align: center;
}

</style>
<meta charset="ISO-8859-1">
<title>Subjects | Learner's Academy</title>
</head>
<body>
<jsp:include page="nav.html" />
	<%
	SubjectService dao = new SubjectService();
	List<Subject> bean =(List<Subject>) dao.getSubjectList();
	%>
	
	<div>
		<h1 align="center">Subjects</h1>
	<form method="get" action="DeleteSubjectServlet">
	<table align="center" border="1px">
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
	<br>
	<div class="sub-head"><a href="addSubject.jsp">Add Subject</a></div>
</body>
</html>