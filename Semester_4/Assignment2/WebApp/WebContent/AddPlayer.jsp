<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Player</title>
</head>
<body>
<form action = "ProcessPlayerServlet" method = "Post">
	Name: <input type = "text" name = "playerName"/><br/>
	Address: <input type = "text" name = "playerAddress"/><br/>
	Role: <input type = "text" name = "playerRole"/><br/>
		Active: <input type = "checkbox" name = "playerActive"/><br/>
	<input type = "submit" name = "Action" value = "add"/>

</form>

</body>
</html>