<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/button_style.css" />
</head>
<body>
	<div class="mycontainer">
		<header>
			<h1>Prime Technology Group</h1>
		</header>
		<nav class="nav">
			<button class="button button5">
				<a href="employee_form">Employee form</a>
			</button>
			<br>
			<button class="button button5">
				<a href="allemp">All Employees</a>
			</button>
			<br>
			<button class="button button5">
				<a href="empbyletter">Employee letter</a>
			</button>
			<br>
			<button class="button button5">temp4</button>
			<br>
		</nav>
		<div class="bodystyle">
			<font color="black">
				<h3>All the employees are...</h3>
			</font>
			<table style="width: 212px;">
				<tr bgcolor=#777777>
					<td>Emp ID</td>
					<td>Name</td>
					<td>Salary</td>
				</tr>
				<c:forEach var="lst" items="${list}">
					<tr bgcolor="#eee">
						<td>${lst.eid}</td>
						<td>${lst.name}</td>
						<td>${lst.salary}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<footer>Copyright © primetgi.com</footer>
	</div>
</body>
</html>