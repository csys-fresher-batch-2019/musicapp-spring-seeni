<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>
</head>
<form name="Online music player" method="post"
	action="AdminLoginVerification">
	<body style="text-align: center">
		<h3>
			<b>Admin login</b>
		</h3>
		<br>
		<br>
		<br>
		<b>MailID</b>
		<input type="email" style="margin-left: 24px;" name="mail"
			placeholder="Enter email" required>
		<br>
		<br>
		<b>Password</b>
		<input type="password" style="margin-left: 10px;"
			placeholder="Enter password" name="password" required>
		<br>
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
</form>
<%
	String result = (String) request.getParameter("result");
	if (result != null) {
		out.println("<center >" + result + "</center>");
	}
	String resul = (String) request.getParameter("resul");
	if (resul != null) {
		out.println("<center >" + resul + "</center>");
	}
%>
</body>