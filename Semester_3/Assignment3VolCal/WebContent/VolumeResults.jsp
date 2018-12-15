<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Volume_Results</title>
	</head>
	<body>
		<p>Name: Varun Rao Student Number: 991498928</p>
   		 <!-- If statement used with expressions to Error Check if our denominator is 0 and if it is not Volume is multiplied with scaling -->
   		 <c:if test="${requestScope.denominator== 0}">Sorry The denominator cannot be 0 </c:if>

		 The calculated volume is 
		 <c:out value='${requestScope.Volume*requestScope.numerator/requestScope.denominator}' />	
		 <br/>
	
		<p>Session ID = <%=pageContext.getSession().getId() %> </p>
		<!-- Lets the user go back to the initial form and calculate another volume -->
		<a href="Volume_Session.jsp">Calculate One More Volume</a>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>