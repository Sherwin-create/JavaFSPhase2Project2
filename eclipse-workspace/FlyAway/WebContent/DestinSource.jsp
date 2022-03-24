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
	<%List<ViewBean> listOfSourceDestination = (List<ViewBean>) service.sourceDestination();%>
	
	<div>
		<table>
			<tr>
				<th>Source</th>
				<th>Destination</th>
			</tr>
			
			<%
				for(ViewBean viewbean: listOfSourceDestination) {
			%>
			
			<tr>
				<td><%=viewbean.getSource() %></td>
				<td><%=viewbean.getDestination() %></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</div>
</body>
</html>