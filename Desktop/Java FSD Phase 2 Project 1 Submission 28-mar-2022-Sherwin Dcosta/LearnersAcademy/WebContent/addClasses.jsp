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
<h1 align="center">Add Classes</h1>
<form action="AddClassServlet" method="get">
<table border="1px" align ="center">
<tr>
	<td>Class Name<input type="text" name="className" placeholder="Enter Class Name"></td>
</tr>
<tr>
	<td><input type = "submit" ><input type="reset"></td>
<tr>
</table>
</form>
</body>
</html>