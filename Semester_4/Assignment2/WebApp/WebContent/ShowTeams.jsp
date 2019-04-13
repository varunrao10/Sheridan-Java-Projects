<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Select Teams</title>
	</head>
	
	<body>
		<form action = "ProcessTeamServlet" method = "Post"> 
	
			
				Team: <select name = "teamSelect">
				<c:forEach var="team" items="${teams}">
					<option><c:out value="${team.teamName}" /></option>
				 </c:forEach>
				</select>
				
			<input type = "submit" name = "Action" value = "add"/>
			<input type = "submit" name = "Action" value = "edit"/>
			 
		</form>
	
	
	</body>
</html>