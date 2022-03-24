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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="HeaderView.jsp" />
	<%String email = request.getParameter("email");
		String name = (String) session.getAttribute("name");
		String gender = (String) session.getAttribute("gender");
		String country = (String) session.getAttribute("country");
	%>
	<%
		int flightNo = (int) session.getAttribute("flightDetailsObj");
		String source = (String) session.getAttribute("source");
		String destination =(String) session.getAttribute("destination");
		String travelDate = (String) session.getAttribute("travelDate");
		int tickets = (int) session.getAttribute("tickets");
		String airlineName = (String) session.getAttribute("airlineName");
		int price = (int) session.getAttribute("price");
	%>
	<form>
		<table border="1px" align="center">
		<h2 style="color:green;">Your ticket is confirmed</h2>
			<tr>
				<td colspan="5">Flight No: <%=flightNo %></td>
			</tr>
			
			<tr>
				<td colspan="2">Name: <%=name%></td>
				<td colspan="2">Country : <%=country %></td>
				<td>Gender : <%=gender%></td>
			</tr>
			<tr>
				<td colspan="5">Flight Information</td>
			</tr>
		
			<tr>
				<th>Source: <%=source %></th>
				<th>Destination: <%=destination %></th>
				<td colspan="3">Airline : <%=airlineName%></td>
			</tr>
			<tr>
				<th colspan="3">Travel Date: <%=travelDate %></th>
				<td>Amount Paid: <% int finalPrice = (int) session.getAttribute("finalPrice");%><%=price %>
			</tr>
		</table>
	</form>
</body>
</html>