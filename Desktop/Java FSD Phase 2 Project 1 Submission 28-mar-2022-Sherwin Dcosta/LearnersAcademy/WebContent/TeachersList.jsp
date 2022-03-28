<%@page import="java.util.List"%>
<%@page import="com.sherwin.learners.bean.Teacher"%>
<%@page import="com.sherwin.learners.service.TeacherService"%>
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
<title>Teacher List | learner's academy</title>
</head>
<body>

<jsp:include page="nav.html" />
	
	<%
	TeacherService service = new TeacherService();
	List<Teacher> bean = (List<Teacher>) service.getTeacherList();
	%>
	<h1 align="center">Teacher List</h1>
	<form action="DeleteTeacherServlet" method="get">
	<table border="1px" align="center">	
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>delete</th>
		<th>Allocate Subject</th>
		<th>Allocate class</th>
	</tr>
	<%		
			for(Teacher viewbean: bean) {	
	%>
		
	<tr>
		
		<td><%=viewbean.getId() %></td>
		<td><%=viewbean.getFirstName() %></td>
		<td><%=viewbean.getLastName() %></td>
		<td><button type="submit" name="btn-teacher" value="<%=viewbean.getId() %>" >delete</button></td>
		<td><a href="AllocateSubjectsToTeacher.jsp?method=get&id=<%=viewbean.getId()%>">allocate</a></td>
		<td><a href="AllocateTeacherToClass.jsp?method=get&id=<%=viewbean.getId() %>">allocate class</a>
	</tr>
	<%  } %>
	</table>
	</form>
	<br>
	<div class="sub-head"><a href="addTeacher.jsp">Add Teacher</a></div>
</body>
</html>
