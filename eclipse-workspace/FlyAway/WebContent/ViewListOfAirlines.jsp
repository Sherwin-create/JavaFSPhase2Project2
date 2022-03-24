<%@page import="java.util.List"%>
<%@page import="com.sherwin.flyaway.bean.ViewBean"%>
<%@page import="com.sherwin.flyaway.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%AdminService service = new AdminService(); %>
	<%List<ViewBean> listOfLines = (List<ViewBean>) service.listOfAirlines();%>
	
	<div>
		<table>
			<tr>
				<th>Airline Name</th>
				<th>Airline Code</th>
			</tr>
			
			<%
				for(ViewBean viewbean: listOfLines) {
			%>
			<tr>
				<td><%=viewbean.getAirlineName() %></td>
				<%-- <td><%=viewbean.getAirlineCode() %></td> --%>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>