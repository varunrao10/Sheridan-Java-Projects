<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rocket Details</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<h2>Name:Varun Rao Student #: 991498928</h2>
		
	<form action="ReusableRocket" method="post">
	<div class="ex">
	<table id = "rocket">
		<tr>
			<td>Name of Rocket: </td>
			<td><input type="text" name="name" /></td>
		</tr>
		
		<tr>
			<td>Height of Rocket: </td>
			<td><input type="text" name="height" /></td>
		</tr>
		
		<tr>
			<td>Weight of Rocket:</td>
			<td><input type="text" name="weight"/></td>
		</tr>
		
		<tr>
			<td>Number of Reuses </td>
			<td><input type="text" name="reuse"/></td>
		</tr>
		
	</table>
	</div>
	<input type="submit" value="register" />
	</form>
</body>
</html>