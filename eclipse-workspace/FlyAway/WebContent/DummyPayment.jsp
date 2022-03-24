<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ConfirmationPage.jsp">
	<% int finalPrice = (int) session.getAttribute("finalPrice");%>
	<table border="1px" align="center">
		<caption>Dummy Payment Gateway</caption>
		<tr>
			<td>Requested by FlyAway</td>
		</tr>
		<tr>
			<td>Amount is: <%=finalPrice %></td>
		</tr>
		<tr>
			<td><input type="submit" value="confirm">
		</tr>		
	</table>
</form>
</body>
</html>