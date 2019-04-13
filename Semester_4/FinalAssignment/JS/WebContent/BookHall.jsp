<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
	<%@ include file ="Header.jsp" %>
	<h1>Book Hall</h1>
	Select Hall: <input type = "text" name = "Selecthall"></input><br/>
	Select Client: <input type = "text" name = "Selectclient"></input><br/>
	Enter Date: <input type = "date" name = "Date"></input><br/><br/>
	<button type = "button">Book It</button>

</body>
</html>