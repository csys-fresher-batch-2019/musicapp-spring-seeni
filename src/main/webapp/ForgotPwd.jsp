<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<form action="ForgotPasswordServlet"><br><br>
Enter your registered Email : <input type="email" name="mail" placeholder="Enter your Registered Email"><br><br>
<button type="submit">Enter</button>
</form>
<%
String result=(String)request.getParameter("result");
if(result!=null){
	out.println("<center>"+result+"</center");
}
%>
</body>
</html>