<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
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
			
			<li class="nav-item"><a class="nav-link" href="showStudent">Display all students</a></li>
            <li class="nav-item"><a class="nav-link" href="logout">Log
					out</a></li>
		</ul>
		</nav>


		<br>

	</div>
	<div class="container">

		<table class="table">
			<thead>
				<tr>

					<th>SSN</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Age</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
							
							<td>${studentDTO.ssn}</td>
							<td>${studentDTO.name}</td>
							<td>${studentDTO.email}</td>
							<td>${studentDTO.password}</td>
							<td>${studentDTO.age}</td>


				</tr>

			</tbody>
		</table>

	</div>

</body>
</html>
