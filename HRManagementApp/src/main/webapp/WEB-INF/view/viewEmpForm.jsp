<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<link href="<c:url value='/resources/css/stylesheet.css' />"
	rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>AG Technologies | View Employees</title>
</head>
<body>
	<header>
		<div id="branding">
			<h1>AG Technologies</h1>
		</div>
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="addEmp">Add New Employee</a></li>
				<li class="current"><a href="viewEmp">View Employees</a></li>
				<li><a href="aboutUs">About Us</a></li>
			</ul>
		</nav>

	</header>

	<section>
		<div class="container">
			<table class="list">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Email ID</th>
					<th>Designation</th>
					<th>Salary</th>
				</tr>
				<c:forEach var="employee" items="${list}">
					<tr>
						<td><a href="editEmp?employeeId=${employee.employeeId}">${employee.employeeId}</a></td>
						<td>${employee.employeeName}</td>
						<td>${employee.mailId}</td>
						<td>${employee.designation}</td>
						<td>${employee.salary}</td>
					</tr>
				</c:forEach>
			</table>

		</div>


	</section>


</body>
</html>