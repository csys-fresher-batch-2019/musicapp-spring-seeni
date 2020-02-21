<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
body{
text-align:center;
background-color : #cccccc;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<% 
HttpSession ses=request.getSession();
String str=(String) ses.getAttribute("mailID");
%>

<nav class="navbar navbar-inverse">  
<div class="container-fluid"> 
   <ul class="nav navbar-nav navbar-right"> 

  
   		<li style="float:right"><a class="active" href="#about">Logged in as <%=str %></a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>  
    </ul>  
  </div>  
</nav> 
<body>  
<form name="Online music player" method="post">
<h1>ADMIN</h1><br><br>
Do you wants to Insert songs ? <a href="InsertSongs.jsp">Insert Songs</a><br><br>
View Songs?<a href="songlist.jsp">Display songs</a>
</form>

</body>