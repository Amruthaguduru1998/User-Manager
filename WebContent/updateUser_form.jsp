<%@page import="com.usermanager.dao.User_DAO"%>
<%@page import="com.usermanager.modal.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update User</title>
 		<link rel="stylesheet" href="CSS/addUser.css">
	</head>
	<body>
		<%
		
		int sr_no = 0;
		sr_no = Integer.parseInt(request.getParameter("id"));
		User user = User_DAO.retrieveUser(sr_no);
		
		String name = user.getName();
		String email = user.getEmail();
		String address = user.getAddress();
		String dob = user.getDob();
		String gender = user.getGender();
		String password = user.getPassword();
		long number = user.getNumber();
		
		%>
		
		<form action="updateUser" method="post">
			<div class="topnav">
			  <a class="active" href="index.jsp">Home</a>
			  <div class="search-container">
			      <input type="text" placeholder="Search User" name="name">
			      <input class="button_css" type="submit" value="Go">
			  </div>
			</div>
			<p><b></b></p>
			<div class="table_whole">
				<table  align="center">
					<tr>
						<th align="left">Sr. No.</th>
						<th align="left"><input class="table" type="number" name="sr_no" value=<%=user.getSr_no()%>></th>
					</tr>
					<tr>
						<th align="left">Name</th>
						<th align="left"><input class="table" type="text" name="user_name" value=<%=name%>></th>
					</tr>
					<tr>
						<th align="left">Email</th>
						<th align="left"><input class="table" type="email" name="email" value=<%=email%>></th>
					</tr>
					<tr>
						<th align="left">Address</th>
						<th align="left"><input class="table" type="text" name="address" value=<%=address%>></th>
					</tr>
					<tr>
						<th align="left">DOB</th>
						<th align="left"><input class="table" type="date" name="dob" value=<%=dob%>></th>
					</tr>
					<tr>
						<th align="left">Gender</th>
						<th align="left">
							  <select name="gender" class="table">
							      <option value="<%=gender%>"><%=gender%></option>
							      <option value="Male">Male</option>
							      <option value="Female">Female</option>
							      <option value="Other">Other</option>
							  </select>
						</th>
					</tr>
					<tr>
						<th align="left">Password</th>
						<th align="left"><input class="table" type="password" name="password" value=<%=password%>></th>
					</tr>
					<tr>
						<th align="left">Number</th>
						<th align="left"><input class="table" type="tel" name="number" value=<%=number%>></th>
					</tr>
					<tr>
						<th></th>
						<th align="left"><input type="submit" value="Update" class="table_button"></th>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>