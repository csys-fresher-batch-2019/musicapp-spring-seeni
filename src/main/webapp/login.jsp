
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<style>
body {
	background-color: #cccccc;
	background-image: url("Assets/Images/music image.jpg");
	background-repeat: no-repeat;
}

a {
	color: #022108;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>
</head>
<body style="text-align: center">
	<form method="post" action="LoginServelet">
		<h1>
			<b>Online music player</b>
		</h1>
		<h3>
			<b>User login</b>
		</h3>
		<br>
		<br>
		<br> <b>MailID</b><input type="email" style="margin-left: 24px;"
			name="mail" placeholder="Enter email" required><br>
		<br> <b>Password</b><input type="password"
			style="margin-left: 10px;" placeholder="Enter password"
			name="password" required><br>
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>
	<%
		String result = (String) request.getParameter("result");
		if (result != null) {
			out.println("<center style='background-color:red'></font>" + result + "</center>");
		}
	%>
</body>
<b><a href="ForgotPwd.jsp">Forgot Password</a></b>
<br>
<b><i>You are a admin ?</i></b>
<a href="Admin.jsp">Admin login</a>
<br>
<b><i>New User ?</i></b>
<a href="register.jsp">Register</a>
<br>
<html>
<script type="text/javascript">
	$().ready(function() {
		if (document.referrer != 'http://192.168.56.207:8090/MusicWeb/login') {
			history.pushState(null, null, 'login');
			window.addEventListener('popstate', function() {
				history.pushState(null, null, 'login');
			});
		}
	});
</script>