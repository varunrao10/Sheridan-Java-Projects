<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Student</title>
</head>
<body>
<form action="StudentController" method="post">
<fieldset>
<div>
<label for="studentId">Student ID</label> <input type="text"
name="studentId" value="<c:out value="${student.studentid}" />" readonly="readonly"/>
</div>
<div>
<label for="firstName">First Name</label> <input type="text"
name="firstName" value="<c:out value="${student.firstname}" />" />
</div>
<div>
<label for="lastName">Last Name</label> <input type="text"
name="lastName" value="<c:out value="${student.lastname}" />" />
</div>
<div>
<label for="program">Program</label> <input type="text" name="program" value="<c:out value="${student.program}" />" />
</div>
<div>
<label for="gpa">GPA</label> <input type="text" name="gpa" value="<c:out value="${student.gpa}" />" />
</div>
<div>
<input type="submit" value="Submit" />
</div>
</fieldset>
</form>
</body>
</html>