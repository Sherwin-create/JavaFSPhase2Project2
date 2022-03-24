<%@page import="java.util.List"%>
<%@page import="com.sherwin.flyaway.bean.ViewBean"%>
<%@page import="com.sherwin.flyaway.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<%AdminService service = new AdminService(); %>
	<%List<ViewBean> listOfSourceDestination = (List<ViewBean>) service.listFlights();%>
	<div>
		<table border="1px" align="center">
			<tr>
				<th>Source</th>
				<th>Destination</th>
				<th>airline</th>
				<th>ticket price</th>
			</tr>
			
			<%
				for(ViewBean viewbean: listOfSourceDestination) {
			%>
			
			<tr>
				<td><%=viewbean.getSource() %></td>
				<td><%=viewbean.getDestination() %></td>
				<td><%=viewbean.getAirlineName() %></td>
				<td><%=viewbean.getPrice() %>
			</tr>
			
			<%
				}
			%>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>