<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h1{
	text-align: center;
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.html" />
<h1 >Add Subject</h1>
<form action="AddSubjectServlet" method="get">
<table border="1px" align ="center">
<tr>
	<td>Subject Name<input type="text" name="subjectName" placeholder="Enter Subject Name" maxlength="20"></td>
</tr>
<tr>
	<td><input type = "submit" ><input type="reset">
<tr>
</table>
</form>

</body>
</html>