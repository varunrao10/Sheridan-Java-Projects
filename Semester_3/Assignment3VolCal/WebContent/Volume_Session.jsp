<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volume_Session</title>
</head>
<body>
<p>Name: Varun Rao Student Number: 991498928</p>
<!--Show Date Dynamically  -->
<p><%=getMyDate()%> </p>

<%
//Create The Session Containing our Default Values
	session = request.getSession();
	
	session.setMaxInactiveInterval(1800);
	
	String default_height = (String)session.getAttribute("default_height");
	
	if(default_height==null){
		default_height = "10";
	}
	
	String default_width = (String)session.getAttribute("default_width");
	
	if(default_width==null){
		default_width = "10";
	}
	
	String default_depth = (String)session.getAttribute("default_depth");
	
	if(default_depth==null){
		default_depth = "18";
	}
	

 %>

<!-- Form with our default values from the session stored as cookies -->

<form action="VolumeCalc" method="post">
	<table>
	
		<tr><td><font face="verdana" size="2px">Width:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="width" value="<%=default_width %>"></td>
		</tr>
		
		
		<tr><td><font face="verdana" size="2px">Height:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="height" value="<%=default_height %>"></td>
		</tr>
		 
		 
		<tr><td><font face="verdana" size="2px">Depth:</font></td>
		<td><input type="number" required="required" min="1" max="99" name="depth" value="<%=default_depth %>"></td>
		</tr>
		
		<tr><td><font face="verdana" size="2px">Scaling :</font></td>
		<td><input type="number" required="required" name="numerator"> / <input type="number" required="required"  name="denominator"></td>
		</tr>
	</table>
	
<input type="submit" value="Calculate Volume">

</form>

<!-- Formats the date so it is shown dynamically in our webpage -->
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