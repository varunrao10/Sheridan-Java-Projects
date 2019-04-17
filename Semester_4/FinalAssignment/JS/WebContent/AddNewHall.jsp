<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddNewHall</title>
<link rel="stylesheet" href="styles.css"/>
</head>
<body>
	<%@ include file ="Header.jsp" %>

	<form action = "HallAdminServlet" method = "Post">
		Hall Name: <input type = "text" name = "HallName"></input><br/>
		<button type = "submit" name = "HallButton" value = "Add">AddHall</button>
	</form>
	
</body>
</html>