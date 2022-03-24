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
<jsp:include page="HeaderView.jsp" />
<!-- redirected from viewServletBooking -->
	<form action="OrderDetails.jsp" method="post">
		<div align="center">
			<table border="2px" >
			<caption>Customer Details Form</caption>
				<tr>
					<td colspan="2">Fill your details</td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td><input type="text" name="email" required></td>
				</tr>
				<tr>
					<td>Enter Name</td>
					<td><input type="text" name="cName" required></td>
				</tr>
				<tr>
					<td>Enter Age</td>
					<td><input type="text" name="age" required></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" id ="genM" name="gender" value="male" required>
						<label for="genM">Male</label>
						<input type="radio" id ="genF" name="gender" value="female" required>
						<label for="genF">Female</label>
					</td>
				</tr>
				<tr>
					<td><label for="addr">Address</label></td>
					<td>
						<textarea id="addr" name="address" rows="4" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<td>Country</td>
					<td><input type="text" name="country" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="cusDetails"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>