<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="OTPValidation">
Enter your OTP:
<input type="number" name="otp">
<button type="submit" >Enter</button>
</form>
<%
String result=(String)request.getParameter("result");
if(result!=null){
	out.println("<center>"+result+"</center>");
}
%>
</body>
</html>