<%@page import="com.sherwin.learners.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.sherwin.learners.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="nav.html" />
	<a href="addStudent.jsp">Add Student</a>
	<%
	StudentService service = new StudentService();
	List<Student> bean = (List<Student>) service.StudentList();
	%>
	<form action="StudentServlet" method="get">
	<table border="1px" align="center">	
	<tr>
		<th>Roll no.</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>delete</th>
	</tr>
	<%		
			for(Student viewbean: bean) {	
	%>
		
	<tr>
		<td><%=viewbean.getRollNo() %></td>
		<td><%=viewbean.getFirstName() %></td>
		<td><%=viewbean.getLastName() %></td>
		<td><button type="submit" name="btn-student" value="<%=viewbean.getRollNo()%>" >delete</button></td>
	</tr>
	<% } %>


	</table>
	</form>
</body>
</html>