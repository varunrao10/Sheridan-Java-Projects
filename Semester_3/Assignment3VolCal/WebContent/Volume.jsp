<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p><%=getMyDate()%> </p>

<form action="VolumeCalc" method="post">
	<table>
	
		<tr><td><font face="verdana" size="2px">Width:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="width" value="<%=application.getInitParameter("Default-Width") %>"></td>
		</tr>
		
		
		<tr><td><font face="verdana" size="2px">Height:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="height" value="<%=application.getInitParameter("Default-Height") %>"></td>
		</tr>
		 
		 
		<tr><td><font face="verdana" size="2px">Depth:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="depth" value="<%=application.getInitParameter("Default-Depth") %>"></td>
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