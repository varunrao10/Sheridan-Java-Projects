<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Players</title>
</head>
<body>
<form action = "ProcessPlayerServlet" method = "Post">
	Name: <input type = "text" name = "playerName" value = "${player.playerName }" /><br/>
	Address: <input type = "text" name = "playerAddress" value = "${player.playerAddress }"/><br/>
	Role: <input type = "text" name = "playerRole" value = "${player.playerRole }"/><br/>
	Active: <input type = "checkbox" name = "playerActive" value = "${player.active }"/><br/>
	<input type = "submit" name = "Action" value = "save"/>

</form>

</body>
</html>