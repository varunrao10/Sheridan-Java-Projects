<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link rel="stylesheet" href="styles.css"/>
</head>
<body>
	<%@ include file ="Header.jsp" %>
	<form action = "BookHallServlet" method = "Post">

	<p>Select Client : 
		<select name="ClientSelection">
			<c:forEach var="client" items="${clients}">
			   		<option value="${client.value.clientName}">${client.value.clientName}</option>
			</c:forEach>
		</select>
	</p>

	<p>Select Hall :  
		<select name="HallSelection"> 
			<c:forEach var="hall" items="${halls}">
			   		<option value="${hall.value.hallName}">${hall.value.hallName}</option>
			</c:forEach>
		</select><br/>
	</p>
	
	Select Date: <input type = "date" name = "BookingDate"/><br/><br/>
		<button type = "submit" name = "Submit" >Book It</button>

	</form>
	
	<p>${message}</p>
</body>
</html>