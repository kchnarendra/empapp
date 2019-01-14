<%@ page isELIgnored="false"%>
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
				<a href="eif">Employee form</a>
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
				<h2>Hey your data was stored successfully....</h2>
				<h3>The following data was stored...</h3>
			</font>
			<table style="width: 212px;">
				<tr bgcolor="#eee">
					<td>Emplyoyee ID :</td>
					<td>${edto.getEid()}</td>
				</tr>
				<tr bgcolor="#eee">
					<td>Name :</td>
					<td>${edto.getName()}</td>
				</tr>
				<tr bgcolor="#eee">
					<td>Salary :</td>
					<td>${edto.getSalary()}</td>
				</tr>
			</table>
			<br>
			<button class="button button1">
				<a href="employee_form">add more ???</a>
			</button>
			<br>
		</div>
		<footer>Copyright © primetgi.com</footer>
	</div>
</body>
</html>