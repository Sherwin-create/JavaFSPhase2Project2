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
<title>Insert title here</title>
</head>
<body>
	
<jsp:include page="header.jsp" />
	<%AdminService service = new AdminService(); %>
	<%List<ViewBean> listOfLines = (List<ViewBean>) service.listOfAirlines();%>
	</hr>
	<div>
		<table align="center" border="1px">
			<tr>
				<th>Airline Name</th>
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
	<br>
	<br>
	<jsp:include page="footer.jsp" />
</body>
</html>