<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employees</title>
	</head>
	<body>
		<a href="index.html">Add Employee</a>
		<form action="ViewEmployees.jsp">
			<table>
				<tr>
					<th align="left">Employee Number</th>
					<th><input type="number" name="eno"></th>
					<th><input type="submit" value="Search Emp"></th>
				</tr>
			</table>
			<table border="1">
				<tr>
					<th align="left">Employee No</th>
					<th align="left">Employee Name</th>
					<th align="left">Salary</th>
					<th align="left">Update</th>
					<th align="left">Delete</th>
				</tr>
			</table>
		</form>
	</body>
</html>