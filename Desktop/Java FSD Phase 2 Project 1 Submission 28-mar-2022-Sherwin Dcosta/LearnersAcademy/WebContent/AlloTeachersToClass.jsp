<%@page import="com.sherwin.learners.dao.AllocateSubjectsForTeachersDao"%>
<%@page import="com.sherwin.learners.bean.SubjectClassBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sherwin.learners.bean.Subject" %>
<%@page import="com.sherwin.learners.bean.SubjectTeacherBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="main">
	<% String className = (String) session.getAttribute("className");%>
	<h1>Select Teachers</h1>
		<%SubjectClassBean bean = (SubjectClassBean) request.getAttribute("beanFromUser"); %>
		<% AllocateSubjectsForTeachersDao dao = new AllocateSubjectsForTeachersDao(); %>
		
		
		<table>
		<%-- <% String subject1 = bean.getSubject1(); %>
		<%List<SubjectTeacherBean> beanTeacher = (ArrayList<SubjectTeacherBean>) dao.listSubjectsTeachers(subject1);
		int size = beanTeacher.size();
		int i = 0;%>
		<tr>
		<td>
			<label for="subject1" >Select Teacher for <%=subject1 %></label><br>
			<select name="subjectChosen1" required="required" id="subject1">
			<% while(size>0) {
			%>
				<option><%=beanTeacher.get(i).getSubject1() %></option>
			<%size--;
				i++;
			}
			%>
			</select>
		</td>
		</tr>
		</table> --%>
		
		<table>
		<% AllocateSubjectsForTeachersDao dao1 = new AllocateSubjectsForTeachersDao(); %>
		<% String subject2 = bean.getSubject2(); %>
		<%List<SubjectTeacherBean> beanTeacher2 = (ArrayList<SubjectTeacherBean>) dao1.listSubjectsTeachers(subject2);
		int size2 = beanTeacher2.size();
		int ii = 0;%>
		<tr>
		<td>
			<label for="subject1" >Select Teacher for <%=subject2 %></label><br>
			<select name="subjectChosen1" required="required" id="subject1">
			<% while(size2>0) {
			%>
				<option><%=beanTeacher2.get(ii).getSubject2() %></option>
			<%size2--;
				ii++;
			}
			%>
			</select>
		</td>
		</tr>
		</table>
		<% String subject3 = bean.getSubject3(); %>
		<%List<SubjectTeacherBean> beanTeacher3 = (ArrayList<SubjectTeacherBean>) dao.listSubjectsTeachers(subject3);
		int size3 = beanTeacher3.size();
		int iii = 0;%>
		<table>
		<tr>
		<td>
			<label for="subject1" >Select Teacher for <%=subject3 %></label><br>
			<select name="subjectChosen1" required="required" id="subject1">
			<% while(size3>0) {
			%>
				<option><%=beanTeacher3.get(iii).getSubject3() %></option>
			<%size3--;
				iii++;
			}
			%>
			</select>
		</td>
		</tr>
		</table>
	</div>
</body>
</html>