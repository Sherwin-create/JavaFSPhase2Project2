<%@page import="java.util.List"%>
<%@page import="com.sherwin.learners.service.ClassService"%>
<%@page import="com.sherwin.learners.bean.ClassBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	th
{
	margin:3px;
	padding:10px;
	text-align: center;
	background-color: #DCD9D4;
	 background-image: linear-gradient(to bottom, rgba(255,255,255,0.50) 0%, rgba(0,0,0,0.50) 100%), radial-gradient(at 50% 0%, rgba(255,255,255,0.10) 0%, rgba(0,0,0,0.50) 50%);
	 background-blend-mode: soft-light,screen;
}
td {
	margin:3px;
	padding:10px;
	text-align: center;
}
.center-cls {
	text-align: center;
}
</style>
</head>
<body>
<jsp:include page="nav.html" />
	<%
	ClassService dao = new ClassService();
	List<ClassBean> bean =(List<ClassBean>) dao.getClassList();
	%>
	
	<div>
		<h1 align="center">Classes</h1>
	<form method="get" action="DeleteClassServlet">
	<table align="center" border=1px>
	<tr>
		<th >SNo.</th>
		<th >Class Name</th>
		<th >Delete class</th>
		<th>Add Subjects </th>
	</tr>
	
	<%		
			for(ClassBean viewbean: bean) {	
	%>
		
	<tr>
		<td><%=viewbean.getId() %></td>
		<td><a href="viewClass.jsp?method=get&className=<%=viewbean.getName()%>"><%=viewbean.getName() %></a></td>
		<td><button type="submit" name="btn-cls" value="<%=viewbean.getId()%>" >delete</button></td>
		<td><a href="AlloClassSubjectServlet?method=get&classname=<%=viewbean.getName()%>">Allocate Subject for <%=viewbean.getName() %></a>
	</tr>
	<% } %>
	</table>
	</form>
	</div>
	<br>
	<div class="center-cls "><a href="addClasses.jsp" class="center-cls">Add Classes</a></div>
</body>
</html>