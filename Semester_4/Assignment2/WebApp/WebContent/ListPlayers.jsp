<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Players</title>
</head>

<body>

	Team: ${team}
	<br />
	<c:forEach var="player" items="${players}">
		<form action="ProcessPlayerServlet" method="Post">
			<input type="text" name="playerName" value="${player.playerName}"
				readonly /> <input type="submit" name="Action" value="edit" /> <input
				type="submit" name="Action" value="delete" />
		</form>
	</c:forEach>


</body>
</html>