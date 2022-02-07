<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="register">Student
					Registration</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">Log
					out</a></li>

		</ul>
		</nav>


		<br>

	</div>
	<div class="container">
		<h1>Student Data</h1>
		<br> <br>

		<table class="table">

			<thead>
				<tr>
					<th>S.No.</th>
					<th>SSN</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Age</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentDTOlist}" var="student"
					varStatus="counter">


					<tr>
						<td>${counter.count}</td>
						<td>${student.ssn}</td>
						<td>${student.name}</td>
						<td>${student.email}</td>
						<td>${student.password}</td>
						<td>${student.age}</td>


						<td><a href="editStudent?ssn=${student.ssn}">
								<button type="button" class="btn btn-primary">update</button>
						</a> <a href="deleteStudent?ssn=${student.ssn}">
								<button type="button" class="btn btn-danger">delete</button>
						</a></td>


					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


</body>
</html>