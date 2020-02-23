<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Online music player</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<style>
body {
	background-color: #cccccc;
	border: 1px solid black;
}

#loginbox span {
	display: block;
}

#loginbox input {
	border-top-style: hidden;
	border-right-style: hidden;
	border-left-style: hidden;
	border-bottom-style: groove;
	width: 80%;
	height: 5%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online music player</title>
</head>
<body>
	<br>
	<form name="Online music player" action="SongListServlet">
		<div class="container">
			<h2>Stacked form</h2>
			<form>
				<div class="form-group">
					<label for="Song name">Song name:</label> <input type="text"
						class="form-control" id="email" name="songName"
						placeholder="Enter song">
				</div>
				<div class="form-group">
					<label for="pwd">Music Director:</label> <input type="text"
						class="form-control" id="pwd" name="mDir"
						placeholder="Enter music director">
				</div>
				<div class="form-group">
					<label for="pwd">Lyricist:</label> <input type="text"
						class="form-control" id="pwd" name="lyric"
						placeholder="Enter Lyricist name">
				</div>
				<div class="form-group">
					<label for="pwd">Singers:</label> <input type="text"
						class="form-control" id="pwd" name="singer"
						placeholder="Enter Singer name">
				</div>
				<div class="form-group">
					<label for="pwd">Movie name:</label> <input type="text"
						class="form-control" id="pwd" name="mName"
						placeholder="Enter movie name">
				</div>
				<div class="form-group">
					<label for="pwd">Song link:</label> <input type="text"
						class="form-control" id="pwd" name="slink"
						placeholder="Enter Song link">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</form>
</body>
</html>