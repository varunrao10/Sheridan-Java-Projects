<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Screen</title>
<link rel="stylesheet" href="styles.css"/>
</head>
<body>

	<h1>Booking System</h1>
	
		<%@ include file ="Header.jsp" %>
	
	<form action = "BookHallServlet" method = "Post">
		<button type = "submit" name = "BookHall">Book Hall</button>
	</form>
	
	<form action = "RegisterClient" method = "Post">
		<button type = "submit" name = "RegisterClient">Register Client</button>
	</form>
	
	<form action = "HallAdminServlet" method = "Post">
		<button type = "submit" name = "HallAdmin">Hall Admin</button>
	</form>
</body>
</html>