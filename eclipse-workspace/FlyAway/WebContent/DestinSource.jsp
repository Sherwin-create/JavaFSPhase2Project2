<%@page import="java.util.List"%>
<%@page import="com.sherwin.flyaway.bean.ViewBean"%>
<%@page import="com.sherwin.flyaway.service.AdminService"%>
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
<title>Source Destination</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<%AdminService service = new AdminService(); %>
	<%List<ViewBean> listOfSourceDestination = (List<ViewBean>) service.sourceDestination();%>
	
	<div>
		<table border="2px" align="center">
		<caption><h3>Source and Destination of all flights</h3></caption>
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
	<jsp:include page="footer.jsp" />
</body>
</html>