<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Data </title>
</head>
<style>
	div.ex{text-align:right; width: 300px; padding: 10px; border: 5px solid grey; margin: 0px;}
</style>
<body>
	<h1>Registration Form</h1>
	<div class ="ex">
	<form action = "RegistrationController" method = "get">
		<table style = "width 50%">
			<tr>
				<td> Full Name </td>
				<td> <input type = "text" name = "fullname"></td>
			</tr>
			
			<tr>
				<td> Address: </td>
				<td> <input type = "text" name = "address"></td>
			</tr>
			
			<tr>
				<td> Age </td>
				<td> <input type = "text" name = "age"></td>
			</tr>
			
			<tr>
				<td> Qualification </td>
				<td> <input type = "text" name = "qual"></td>
			</tr>
			
			<tr>
				<td> Percentage </td>
				<td> <input type = "text" name = "percent"></td>
			</tr>
			
			<tr>
				<td> Year Passed </td>
				<td> <input type = "text" name = "yop"></td>
			</tr>
		</table>
		<input type = "submit" value = "Register"/>
	</form>
	
	</div>

</body>
</html>