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
		String name = request.getParameter("name");
		String h = request.getParameter("height");
		String w = request.getParameter("weight");
		String reuse = request.getParameter("reuse");
		
%>

<table id = "rocket">
		<tr>
			<td>RocketName </td>
			<td><%= name  %> </td>
		</tr>
		
		<tr>
			<td>Rocket Height </td>
			<td><%= h %> </td>
		</tr>
		
		<tr>
			<td>Rocket Weight  </td>
			<td><%= w %> </td>
		</tr>
		
		<tr>
			<td>Rocket Reuse  </td>
			<td><%= reuse %> </td>
		</tr>
		
	</table>

</body>
</html>