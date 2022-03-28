<%@page import="java.util.ArrayList"%>
<%@page import="com.sherwin.learners.bean.ClassBean"%>
<%@page import="java.util.List"%>
<%@page import="com.sherwin.learners.dao.ClassDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AddClassToTeacher">
	<table align="center" border="1px">
	<%int id = Integer.parseInt(request.getParameter("id")); %>
	<%session.setAttribute("id", id); %>
	<%ClassDao dao = new ClassDao();
			List<ClassBean> bean =(ArrayList<ClassBean>) dao.getClassList();
			int size = bean.size();
			int i = 0;%>
		<tr>
		<td>
			<label for="classChoose" >List Classes</label><br>
			<select name="classChosen" required="required" id="classChoose" >
			<%
			
			while(size>0) {
			%>
				<option><%=bean.get(i).getName() %></option>
			<%
				size--;
				i++;
				}
			%>
			</select>
		</td>
		</tr>
		<tr>
			<td><input type="submit" ></td>
		</tr>
		</table>
		</form>
</body>
</html>