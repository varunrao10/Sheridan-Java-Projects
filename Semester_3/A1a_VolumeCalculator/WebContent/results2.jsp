<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results of Volume Calculation</title>
</head>
<style>


</style>

<body>
	<%
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String depth = request.getParameter("depth");
		int volume = Integer.parseInt(height) * Integer.parseInt(width) * Integer.parseInt(depth);
	%>
	
	<p> width = <%= width %> <br/>
	 height = <%= height %> <br/>
	 depth = <%= depth %> <br/>
	 volume = <%= volume %>  </p>
	 
	
</body>
</html>