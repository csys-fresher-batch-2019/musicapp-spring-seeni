<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Login page</h3>
Gender:
<input type="radio" name="gender" value="M"> Male
<input type="radio" name="gender" value="F"> Female<br><br>
Hobbies:
<input type="checkbox" name ="hobbies" value="cricket">Cricket
<input type="checkbox" name ="hobbies" value="Football">Football<br><br>
Select Movie
<select name="movie">
<option value="darbar">Darbar</option>
<option value="kabaali">Kabaali</option>
</select><br><br>
Display movies:
<table border=1>
<thead><tr><th>#</th><th>Movie name</th></tr>
<tbody>
<tr><td>1</td> <td>Darbar</td></tr>
<tr><td>2</td> <td>Kabaali</td></tr>
</tbody>
</table><br><br>

Enter your city :<input list="source_station_list">
<datalist id="source_station_list">
<option value="Chennai">
<option value="Tambaram">
<option value="Delhi">
</option>
</datalist><br><br>
<img src="Assets/Images/raina.png" height=250px width=250px alt="raina"/>
</body>
</html>