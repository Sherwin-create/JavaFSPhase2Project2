<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	td { 
		margin: 3px;
		padding: 10px;
	}
	th { 
		margin: 3px;
		padding: 10px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.html" />
<h1 align="center">Add Student</h1>
<form action="AddStudentServlet" method="get">
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
<form >
</form>
</body>
</html>