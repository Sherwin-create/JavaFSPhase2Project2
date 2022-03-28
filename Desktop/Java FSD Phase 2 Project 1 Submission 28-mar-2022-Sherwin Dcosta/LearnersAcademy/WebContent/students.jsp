<%@page import="com.sherwin.learners.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.sherwin.learners.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.sub-head {
text-align: center;
}
a:hover{
	color: green;
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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="nav.html" />
	<div class="table">
	<%
	StudentService service = new StudentService();
	List<Student> bean = (List<Student>) service.StudentList();
	%>
	<h1 class="heading" align="center">Student Details</h1>
	<form action="StudentServlet" method="get">
	
	<table border="1px" align="center" >	
	<tr>
		<th>Roll no.</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Delete</th>
		<th>Class</th>
	</tr>
	<%		
			for(Student viewbean: bean) {	
	%>
		
	<tr>
		<td><%=viewbean.getRollNo() %></td>
		<td><%=viewbean.getFirstName() %></td>
		<td><%=viewbean.getLastName() %></td>
		<td><button type="submit" name="btn-student" value="<%=viewbean.getRollNo()%>" >delete</button></td>
		<td><a href="AddStudentToAClass.jsp?method=get&rollNo=<%=viewbean.getRollNo() %>">Add to a class</a></td>
	</tr>
	<% } %>
	</table>
	
	</form>
	<br>
	<div class="sub-head"><a href="addStudent.jsp"  >Add Student</a></div>
	</div>
</body>
</html>