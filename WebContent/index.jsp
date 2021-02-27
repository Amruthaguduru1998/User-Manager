<%@page import="com.usermanager.modal.User"%>
<%@page import="com.usermanager.dao.User_DAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Users</title>
		<link rel="stylesheet" href="CSS/table.css">
	</head>
	<body>
		<!-- This page is to show the list of all the records and to give option to insert, update or delete user -->
		<!-- create table crud_user(sr_no number(10), name varchar2(2000), email varchar2(2000), password varchar2(2000), mobile_number number(10)); -->
		
		<form action="table.jsp" method="get">
			<div class="topnav">
			  <a class="active" href="addUser.html">Add User</a>
			  <div class="search-container">
			      <input type="text" placeholder="Search User" name="name">
			      <input class="button_css" type="submit" value="Go">
			  </div>
			</div>
			
			<p><b></b></p>
			<table width="100%" align="left">
				<tr>
					<th align="left">Name</th>
					<th align="left">Email</th>
					<th align="left">Address</th>
					<th align="left">DOB</th>
					<th align="left">Gender</th>
					<th align="left">Password</th>
					<th align="left">Mobile Number</th>
					<th align="left">Action</th>
					<th align="left"></th>
					<th align="left"></th>
				</tr>
				<%
				// invoke users method from User_DAO class
				List<User> users = User_DAO.users();
				
				for (User user: users) {
				%>
				<tr>
					<td align="left"><%=user.getName()%></td>
					<td align="left"><%=user.getEmail()%></td>
					<td align="left"><%=user.getAddress() %></td>
					<td align="left"><%=user.getDob()%></td>
					<td align="left"><%=user.getGender()%></td>
					<td align="left"><%=user.getPassword()%></td>
					<td align="left"><%=user.getNumber()%></td>
					<td align="left"><a class="action_table_p" href='viewUser.jsp?id=<%=user.getSr_no()%>'>View</a></td>
					<td align="left"><a class="action_table_p" href='updateUser_form.jsp?id=<%=user.getSr_no()%>'>Update</a></td>
					<td align="left"><a class="action_table_p" href='deleteUser?id=<%=user.getSr_no()%>'>Delete</a></td>
				</tr>
				<%	
				}
				%>
			</table>
		</form>
	</body>
</html>