<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<form action="NewPasswordServlet" method="post">
Set New Password :<input type="password" name="newpwd"><br><br>
Confirm New Password : <input type="password" name="cnfmpwd"><br><br>
<a href="login.jsp">skip</a>
<button type="submit">submit</button>
	<center>${msg}</center>
</form>
</body>
</html>