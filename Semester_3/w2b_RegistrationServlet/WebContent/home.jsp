<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatted Output</title>
</head>
<style>
	table#nat{
		width:50%;
		background-color:#c48ec5
	}

</style>

<body>
	<%
		String name = request.getParameter("fullname");
		String addr = request.getParameter("address");
		String age = request.getParameter("age");
		String qual = request.getParameter("qual");
		String percent = request.getParameter("percent");
		String year = request.getParameter("yop");
	%>
	
	<table id = "nat">
		<tr>
			<td>Full Name </td>
			<td><%= name %> </td>
		</tr>
		
		<tr>
			<td>Address </td>
			<td><%= addr %> </td>
		</tr>
		
		<tr>
			<td>Age </td>
			<td><%= age %> </td>
		</tr>
		
		<tr>
			<td>Qualification </td>
			<td><%= qual %> </td>
		</tr>
		
		<tr>
			<td>Percent </td>
			<td><%= percent %> </td>
		</tr>
		
		<tr>
			<td>Year of Passout </td>
			<td><%= year %> </td>
		</tr>
		
		
		
		
		
		
	</table>
</body>
</html>