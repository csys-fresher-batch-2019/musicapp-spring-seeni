<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
span {
	float: right;
}
/* .active {
  background-color: #4CAF50;
} */
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body style="text-align: center">
	<%
		String str = "";
		HttpSession sessio = request.getSession();
		str = (String) sessio.getAttribute("mailId");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li style="float: right"><a class="active" href="#about">Logged
						in as <%=str%></a></li>
				<li><a href="login.jsp"><span
						class="glyphicon glyphicon-log-in"></span>Logout</a></li>
			</ul>
		</div>
	</nav>
	<ul>
		<li>
			<h3>
				<a href="PremiumSongList.jsp">Songs List</a>
			</h3>
			<br>
			<h3>
				<a href="UpdatePhoneNumber.jsp">Update phone number</a>
			</h3>
		</li>
	</ul>
</body>
</html>