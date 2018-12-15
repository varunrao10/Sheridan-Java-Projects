<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String effidx = request.getParameter("effidx");
		
%>

<table id = "car">
		<tr>
			<td>Car Brand </td>
			<td><%= brand  %> </td>
		</tr>
		
		<tr>
			<td>Car Model </td>
			<td><%= model %> </td>
		</tr>
		
		<tr>
			<td>Efficiency Index </td>
			<td><%= effidx %> </td>
		</tr>
		
	</table>

</body>
</html>