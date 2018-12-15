<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
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
	<form action="HybridCar" method="post">
	<div class="ex">
	<table id = "car">
		<tr>
			<td>Car Brand </td>
			<td><input type="text" name="brand" /></td>
		</tr>
		
		<tr>
			<td>Car Model </td>
			<td><input type="text" name="model" /></td>
		</tr>
		
		<tr>
			<td>Efficiency Index </td>
			<td><input type="text" name="effidx"/></td>
		</tr>
		
	</table>
	</div>
	<input type="submit" value="register" />
	</form>
</body>
</html>