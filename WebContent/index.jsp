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
					<th align="left">Password</th>
					<th align="left">Mobile Number</th>
					<th align="left">Action</th>
					<th align="left"></th>
				</tr>
				<tr>
					<td align="left">My Name</td>
					<td align="left">email@gmail.com</td>
					<td align="left">password</td>
					<td align="left">123567890</td>
					<td align="left"><a class="action_table_p" href="update.jsp">Update</a></td>
					<td align="left"><a class="action_table_p" href="delete.jsp">Delete</a></td>
				</tr>
				<tr>
					<td align="left">My Name</td>
					<td align="left">email@gmail.com</td>
					<td align="left">password</td>
					<td align="left">123567890</td>
					<td align="left"><a class="action_table_p" href="update.jsp">Update</a></td>
					<td align="left"><a class="action_table_p" href="delete.jsp">Delete</a></td>
				</tr>
				<tr>
					<td align="left">My Name</td>
					<td align="left">email@gmail.com</td>
					<td align="left">password</td>
					<td align="left">123567890</td>
					<td align="left"><a class="action_table_p" href="update.jsp">Update</a></td>
					<td align="left"><a class="action_table_p" href="delete.jsp">Delete</a></td>
				</tr>
			</table>
		</form>
	</body>
</html>