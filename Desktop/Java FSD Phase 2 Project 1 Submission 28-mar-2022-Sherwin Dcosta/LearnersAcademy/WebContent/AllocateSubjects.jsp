<%@page import="com.sherwin.learners.service.SubjectService"%>
<%@page import="com.sherwin.learners.bean.Subject"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String className = (String) session.getAttribute("className");  %>
		<h1 align="center">Add Subjects for class <%=className %></h1> 
	<% %>	
	<br>
	<form method="post" action="AddSubjectsToClsServlet">
	<table align="center" border="1px">
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
		<td>
			<label for="subject4" >Select Subject 4</label><br>
			<select name="subjectChosen4" required="required" id="subject4">
			<%
			List<Subject> bean3 =(ArrayList<Subject>) dao.getSubjectList();
			size = bean3.size();
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
		<td>
			<label for="subject5" >Select Subject 5</label><br>
			<select name="subjectChosen5" required="required" id="subject5">
			<%
			List<Subject> bean4 =(ArrayList<Subject>) dao.getSubjectList();
			size = bean4.size();
			i=0;
			while(size>0) {
			%>
				<option><%=bean4.get(i).getName() %></option>
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
			<label for="subject6" >Select Subject 6</label><br>
			<select name="subjectChosen6" required="required" id="subject6">
			<%
			List<Subject> bean5 =(ArrayList<Subject>) dao.getSubjectList();
			size = bean5.size();
			i=0;
			while(size>0) {
			%>
				<option><%=bean5.get(i).getName() %></option>
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