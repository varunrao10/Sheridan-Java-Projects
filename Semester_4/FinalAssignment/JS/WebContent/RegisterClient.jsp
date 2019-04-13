<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%@ include file ="Header.jsp" %>
	<h1>Register Client</h1>
	<form action = "RegisterClientServlet" method = "Post">
		Name: <input type = "text" name = "ClientName"></input><br/>
		CreditCard: <input type = "text" name = "CreditCard"></input><br/><br/>
		<button type = "submit">Register</button>
	</form>
</body>
</html>