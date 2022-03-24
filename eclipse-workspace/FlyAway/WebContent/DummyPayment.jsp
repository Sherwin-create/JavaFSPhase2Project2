<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th,td {
		padding: 5px;
		margin: 2px;	
		text-align: center;
	 }
table {
	color:green;
}
</style>
<meta charset="ISO-8859-1">
<title>Dummy Payment</title>
</head>
<body>
<form action="ConfirmationPage.jsp">
	<% int finalPrice = (int) session.getAttribute("finalPrice");%>
	<h2 align="center">Dummy Payment Gateway</h2>
	<table border="1px" align="center">
		<tr>
			<td>Requested by FlyAway</td>
		</tr>
		<tr>
			<td>Amount is: <%=finalPrice %></td>
		</tr>
		<tr>
			<td><input type="submit" value="confirm"></td>
		</tr>		
	</table>
</form>
</body>
</html>