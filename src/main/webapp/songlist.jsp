<%@page import="com.chainsys.OtherClass.SongList"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.OtherClass.SongList.*"%>
<%@ page import="com.chainsys.OtherClass.SongLink"%>
<%@ page import="com.chainsys.SongList.*"%>

<html>
<head>
<style>
body {
	background-color: #cccccc;
	background-image: url("Assets/Images/music image.jpg");
	
}

table {
	width: 100%;
}

th, tr, td {
	text-align: center;
	padding: 20px;
	font-family: "Times New Roman";
	font-size: 20px;
	font-weight: bold;
	color: #17150e;
}
thead{
	font-size: 40px;
	text-align:center;
}
</style>
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="text-align: center">

<%
String input = request.getParameter("search");
%>
	<form action="SearchSongServlet">
		Search : <input type="search" name="search"><br> <br>
		<button type="submit">Search</button>
	</form>
	<%
		ArrayList<SongList> songList=(ArrayList<SongList>)request.getAttribute("songDetailsList");	

	%>
	<table style="text-align:center">
	<thead>
		<tr>
			<th>SNO</th>
			<th>SongName</th>
			<th>Songs</th>
		</tr>
	</thead>
	<tbody>
		<%
			int k = 1;
		
															
		    if(songList != null )
			for ( SongList song :songList) {
						String songName = song.getSongName();
						String link = song.getSongLink();
		%>
		<tr>
			<td><%=k++%></td>
			<td><%=songName%></td>
			<td><audio controls controlsList='nodownload'>
					<source src='Assets/Images/<%=link%>' type='audio/mpeg'></source>
				</audio></td>
		</tr>
		<%	
		}
		    else{
		    	
		    	SongLink sl=new SongLink();
		    	List<String> li=sl.songLink();
		    	SearchSongTab2DAOImpl s=new SearchSongTab2DAOImpl();
		    	List<String> song=s.searchSongName();
		    	for(int i=0;i<song.size();i++){
		    		for(int j=0;j<li.size();j++){
		    			if(i==j){
		    			out.println("<tr><td>"+ k++ +"</td><td>"+song.get(i)+"</td><td><audio controls controlsList='nodownload'<source src='Assets/Images/"+li.get(j)+"' type='audio/mpeg'></source></audio></td></tr>");
		    			}
		    		}
		    	}
		    	}%>
		</tbody>
	</table>

</body>
</html>