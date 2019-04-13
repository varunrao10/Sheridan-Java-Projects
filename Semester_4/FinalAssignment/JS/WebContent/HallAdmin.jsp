<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HallAdmin</title>
</head>
<body>
	<form action = "AddNewHall" method = "Post">
		<button type = "submit">Add New Hall</button>
	</form>
	<br/>
	<h3>Hall Names</h3><br/>
	<c:forEach var="hall" items="${halls}">
		<form action = "HallAdminServlet" method = "Post">
			<input type="text" name="HallName" value="${hall.value.hallName}"  />
			<input type = "hidden" name = "HallID" value = "${hall.value.hallID}"/>
			<button type = "submit" name = "HallButton" value = "Edit">Save</button>
			<button type = "submit" name = "HallButton" value = "Delete">Delete</button><br/>
		</form>
	</c:forEach>
	
</body>
</html>