<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/button_style.css" />
<script language="javascript" type="text/javascript">
	function initialize() {
		// alert("Hello = 1");
		setTimeout('submitForm()', 0); //delay 3 seconds
		// alert("Hello = 10");
	}
	function submitForm() {
		// alert("Hello = 2");
		var x = document.getElementsByName('my_search_form');
		x[0].submit(); // Form submission
		// window.document.loginForm.submit();
		// document.forms["login_form"].submit();
		// alert("Hello = 3");
	}
	function clearText() {
		document.getElementById('nameLetterId').value = "";
	}
</script>
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
			<form:form action="/empapp/empbyletter" method="POST"
				commandName="employeeDTOLetter" name="my_search_form">
				<form:input id="nameLetterId" path="nameFirstLetter"
					placeholder="Search by First Letter of name"
					onmouseout="initialize()" onclick="clearText()"
					autofocus="autofocus" style="width: 213px; height: 30px" />
				<input class="button button2" name="my_search_form" type="submit"
					value="Search">
				<br>
				<font size="2" face="consolas" color="red"> <form:errors
						path="nameFirstLetter" />
				</font>
			</form:form>
			<c:choose>
				<c:when test="${list.size() > 0}">
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
				</c:when>
				<c:otherwise>
					<font color="#ff0055"> Sorry no result was found !!! </font>
				</c:otherwise>
			</c:choose>
		</div>
		<footer>Copyright © primetgi.com</footer>
	</div>
</body>
</html>