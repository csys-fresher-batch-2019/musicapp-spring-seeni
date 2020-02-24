<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
body {
	height: 100%;
	text-align: center;
	background-image: url("Assets/Images/music image.jpg")
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>
</head>
<body style="background-color: powderblue;">
	<br>
	<form name="Online music player" method="post" action="UserRegister">
		<h1 style="text-align: center">Online music player</h1>
		<h3 style="text-align: center">Register</h3>
		<br>
		<br>
		<br>
		<!-- <b>UserId</b><input type="number" min="1"  style="margin-left:63px;" name="number" placeholder="UserID" min="1"  required autofocus><br><br>
 -->
		<b>UserName</b><input type="text" name="username"
			placeholder="Enter name" style="margin-left: 38px;" required><br>
		<br> <b>Email-Id</b><input type="email"
			style="margin-left: 50px;" placeholder="EmailID" name="email"
			required><br>
		<br> <b>Password</b><input type="password"
			style="margin-left: 45px;" placeholder="Password" name="password"
			required><br>
		<br> <b>Mobile Number</b><input type="tel" name="mobileNumber"
			pattern="[0-9]{10}" placeholder="Mobile number" style="margin-left: 3px;"
			required><br>
		<br>
		<button type="submit">SUBMIT</button>
	</form>
	<%
		String str = (String) request.getAttribute("mailError");
		if (str != null) {
			out.println("<center>" + str + "</center>");
		}
	%>
</body>
</html>