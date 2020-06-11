<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>AG Technologies | Edit Employee</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/stylesheet.css' />">
<script type="text/javascript"
	src="<c:url value='/resources/js/app.js' />"></script>
</head>
<body>

	<header>
		<div id="branding">
			<h1>AG Technologies</h1>
		</div>
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li class="current"><a href="addEmp">Add New Employee</a></li>
				<li><a href="viewEmp">View Employees</a></li>
				<li><a href="aboutUs">About Us</a></li>
			</ul>
		</nav>

	</header>

	<section>
		<div class="container">
			<div>
				<h1>Add New Employee</h1>
				<div class="form-group">
					<form:form method="post" modelAttribute="employee">
						<div class="hide">
							<label>Employee Id</label>
							<form:input path="employeeId" readonly="true" />
						</div>
						<div>
							<label>Employee Name</label>
							<form:input path="employeeName" />
						</div>
						<div>
							<label>Employee Email</label>
							<form:input path="mailId" />
						</div>
						<div>
							<label>Designation</label>
							<form:input path="designation" />
						</div>
						<div>
							<label>Salary</label>
							<form:input path="salary" />
						</div>
						<button class="button" type="submit"
							formaction="updateEmployee">Update
							Employee</button>
							
						<button class="button"
							formaction="deleteEmployee">Delete
							Employee</button>
					</form:form>
				</div>
			</div>

		</div>

	</section>

	<section></section>

</body>
</html>