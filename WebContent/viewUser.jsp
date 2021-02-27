<%@page import="com.usermanager.dao.User_DAO"%>
<%@page import="com.usermanager.modal.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User</title>
 		<link rel="stylesheet" href="CSS/addUser.css">
	</head>
	<body>
		
			<%
			int user_sr_no = Integer.parseInt(request.getParameter("id"));
			User user = User_DAO.retrieveUser(user_sr_no);
			int sr_no = user.getSr_no();
			String name = user.getName();
			String email = user.getEmail();
			String address = user.getAddress();
			String dob = user.getDob();
			String gender = user.getGender();
			String password = user.getPassword();
			long number = user.getNumber();
			%>
			
		<form action="viewUser.jsp" method="post">
			<div class="topnav">
			  <a class="active" href="index.jsp">Home</a>
			  <a class="active" href="addUser.html">Add User</a>
			  <a class="active" href='updateUser_form.jsp?id=<%=sr_no%>'>Update User</a>
			  <a class="active" href='deleteUser?id=<%=sr_no%>'>Delete User</a>
<!-- 			  <div class="search-container">
			      <input type="text" placeholder="Search User" name="name">
			      <input class="button_css" type="submit" value="Go">
			  </div>
 -->
			</div>
			<p><b></b></p>
			
			<div class="table_whole">
				<table  align="center">
					<tr>
						<th align="left">Sr. NO.:</th>
						<th align="left"><%=sr_no%></th>
					</tr>
					<tr>
						<th align="left">Name:</th>
						<th align="left"><%=name%></th>
					</tr>
					<tr>
						<th align="left">Email:</th>
						<th align="left"><%=email%></th>
					</tr>
					<tr>
						<th align="left">Address:</th>
						<th align="left"><%=address%></th>
					</tr>
					<tr>
						<th align="left">DOB:</th>
						<th align="left"><%=dob%></th>
					</tr>
					<tr>
						<th align="left">Gender:</th>
						<th align="left"><%=gender%></th>
					</tr>
					<tr>
						<th align="left">Password:</th>
						<th align="left"><%=password%></th>
					</tr>
					<tr>
						<th align="left">Number:</th>
						<th align="left"><%=number%></th>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>