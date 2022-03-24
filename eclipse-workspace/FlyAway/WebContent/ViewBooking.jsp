<%@page import="java.util.List"%>
<%@page import="com.sherwin.flyaway.service.ViewService"%>
<%@page import="com.sherwin.flyaway.bean.ViewBean"%>
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
	<div align="center">
		<h2>Available Flights</h2>
		<hr>
	</div>
	<% List<ViewBean> bean = (List<ViewBean>) request.getAttribute("viewObj");%>
	<%int count=0; %>
	
	<table align="center" border="1px">
	<tr>
		<th>FlightNo.</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Travel Date</th>
		<th>Seats Available</th>
		<th>Price</th>
		<th>Airline</th>
		<th>BookTickets</th>
	</tr>
		
	<%	
			for(ViewBean viewbean: bean) {	
	%>
				
	<tr>
				<td><%=viewbean.getFlightNo() %>
				<td><%=viewbean.getSource() %></td>
				<td><%=viewbean.getDestination() %></td>
				<td><%=viewbean.getTravelDate() %>
				<td><%=viewbean.getTickets() %>
				<td><%=viewbean.getPrice() %>
				<td><%=viewbean.getAirlineName() %></td>
				<td><button type="submit" name="btn-book" value="<%=viewbean.getFlightNo()%>">Book Now</button>
				
	</tr>
	<%
			}
	%>
	<%
		/* session.setAttribute("bookNow", btn-book); */
	%>
	</table>
</body>
</html>