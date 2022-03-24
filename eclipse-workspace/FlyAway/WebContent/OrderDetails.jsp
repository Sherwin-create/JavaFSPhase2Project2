<%@page import="com.sherwin.flyaway.service.ViewService"%>
<%@page import="java.util.List"%>
<%@page import="com.sherwin.flyaway.bean.ViewBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- redirected from customerDetails.jsp -->
	 <%int flightNo = (int) session.getAttribute("flightDetailsObj"); %> 
	<% %>
	<%String email = request.getParameter("email");
		String name = request.getParameter("cName");
		/* int age = Integer.parseInt(request.getParameter("age")); */
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
	%>
	
	<form>
		<table border="1px">
			<caption>Booking Confirmation</caption>
			<tr>
				<td>Name:</td>
				<td><%=name%></td>
				<td>Email Address</td>
				<td><%=email %>
				<td>Country</td>
				<td><%=country %>
				<td>Gender</td>
				<td><%=gender%></td>
			</tr>
			<%
			ViewService service = new ViewService();
			List<ViewBean> listOfResult = service.viewAllDetails(flightNo);
			%>
			<%
				for(ViewBean viewbean: listOfResult) {
			%>
			<tr>
				<th>Source</th>
				<td><%=viewbean.getSource() %></td>
				<th>Destination</th>
				<td><%=viewbean.getDestination() %></td>
				<th>airline</th>
				<td><%=viewbean.getAirlineName() %></td>
				<th>ticket price</th>
				<td><%=viewbean.getPrice() %></td>
			</tr>
			
				<%int priceP = viewbean.getPrice(); %>
				<%session.setAttribute("pricePObj", priceP); %>
			<%
				}
			%> 
			<tr>
				<td>no. of passenger</td>
				<td><input type="text" name=''></td>
			</tr>
		</table>
	</form>
</body>
</html>