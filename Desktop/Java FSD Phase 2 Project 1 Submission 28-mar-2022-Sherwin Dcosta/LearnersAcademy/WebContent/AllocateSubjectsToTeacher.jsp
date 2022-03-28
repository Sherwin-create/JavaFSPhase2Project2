<%@page import="com.sherwin.learners.service.SubjectService"%>
<%@page import="com.sherwin.learners.dao.SubjectDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sherwin.learners.bean.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% int id = Integer.parseInt(request.getParameter("id")); %> 
 <h1><%=id %></h1>
 <%session.setAttribute("id", id); %>
<form action="AllocateSubjectToTeacherServlet" method="get">
	<table align="center">
	<%SubjectService dao = new SubjectService();
			List<Subject> bean =(ArrayList<Subject>) dao.getSubjectList();
			int size = bean.size();
			int i = 0;%>
		<tr>
		<td>
			<label for="subject1" >Select Subject 1</label><br>
			<select name="subjectChosen1" required="required" id="subject1">
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
		<td>
			<label for="subject2" >Select Subject 2</label><br>
			<select name="subjectChosen2" required="required" id="subject2">
			<%
			List<Subject> bean1 =(ArrayList<Subject>) dao.getSubjectList();
			size = bean1.size();
			i=0;
			while(size>0) {
			%>
				<option><%=bean1.get(i).getName() %></option>
			<%
				size--;
				i++;
				}
			%>
			</select>
		</td>
		<tr>
		<td>
			<label for="subject3" >Select Subject 3</label><br>
			<select name="subjectChosen3" required="required" id="subject3">
			<%
			List<Subject> bean2 =(ArrayList<Subject>) dao.getSubjectList();
			size = bean2.size();
			i=0;
			while(size>0) {
			%>
				<option><%=bean2.get(i).getName() %></option>
			<%
				size--;
				i++;
				}
			%>
			</select>
		</td>
		</tr>
		<tr>
			<td><input type="submit"><input type="reset">
		</tr>
	</table>
</form>	
</body>
</html>