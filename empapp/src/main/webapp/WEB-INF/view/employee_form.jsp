<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<form:form action="/empapp/eds" method="POST"
				commandName="employeeDTO">
				<form:input path="eid" placeholder="Employee ID"
					autofocus="autofocus" style="width: 213px; height: 30px" />
				<b><font size="2" face="consolas" color="red"><blink>
							<form:errors path="eid" />
						</blink></font> <br> <form:input path="name" placeholder="Name"
						style="width: 213px; height: 30px" /> <font size="2"
					face="consolas" color="red"><form:errors path="name" /></font> <br>
					<form:input path="salary" placeholder="Salary"
						style="width: 213px; height: 30px" /> <font size="2"
					face="consolas" color="red"><form:errors path="salary" /></font> </b>
				<br>
				<input class="button button1" type="submit" value="Save">
			</form:form>
		</div>
		<footer>Copyright © primetgi.com</footer>
	</div>
</body>
</html>
