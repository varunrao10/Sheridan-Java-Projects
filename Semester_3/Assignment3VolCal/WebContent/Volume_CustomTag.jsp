<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ taglib uri = "http://www.sheridancollege.com/customtag" prefix = "ms" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volume_Custom_Tag</title>
</head>
<body>
<p>Name: Varun Rao Student Number: 991498928</p>
<p><%=getMyDate()%> </p>

<!-- Used Custom tags in our column values -->
<form action="VolumeCalc" method="post">
	<table>
	
		<tr><td><font face="verdana" size="2px">Width:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="width" value='<ms:measurements measurementType = "width"/>'></td>
		</tr>
		
		
		<tr><td><font face="verdana" size="2px">Height:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="height" value='<ms:measurements measurementType = "height"/>'></td>
		</tr>
		 
		 
		<tr><td><font face="verdana" size="2px">Depth:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="depth" value='<ms:measurements measurementType = "depth"/>'></td>
		</tr>
		
		<tr><td><font face="verdana" size="2px">Scaling :</font></td>
		<td><input type="number" required="required" name="numerator"> / <input type="number" required="required"  name="denominator"></td>
		</tr>
	</table>
	
<input type="submit" value="Calculate Volume">

</form>

<p><%=getMyDate() %> </p>
<%@ include file="footer.jsp" %>
<%!
public String getMyDate(){
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  Date d = new Date();
  return sdf.format(d); 
}
%>
</body>
</html>