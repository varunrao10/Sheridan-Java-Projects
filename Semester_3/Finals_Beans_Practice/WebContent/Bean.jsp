<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="sBean" class="sheridan.college.finals.SampleBean"
		scope="session">
		<%-- intialize bean properties --%>
		<jsp:setProperty name="sBean" property="param1" value="Mercury" />
		<jsp:setProperty name="sBean" property="param2" value="Venus" />
	</jsp:useBean>

	Sample Bean:
	<%=sBean%>

</body>
</html>