<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%String email = request.getParameter("email");
		String name = request.getParameter("cName");
		/* int age = Integer.parseInt(request.getParameter("age")); */
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
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
		<table border="1px">
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