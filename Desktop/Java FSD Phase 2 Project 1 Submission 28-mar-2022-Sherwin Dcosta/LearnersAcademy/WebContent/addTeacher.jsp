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
<h1 align="center">Add Teacher</h1>
<form action="AddTeacherServlet" method="get">
<table border="1px" align ="center">
<tr>
	<td>First Name<input type="text" name="firstName" placeholder="Enter student First Name" maxlength="10"></td>
</tr>
<tr>
	<td>Last Name<input type="text" name="lastName" placeholder="Enter student last Name" maxlength="10"></td>	
</tr>
<tr>
	<td><input type = "submit" ><input type="reset">
<tr>
</table>
</form>
</body>
</html>