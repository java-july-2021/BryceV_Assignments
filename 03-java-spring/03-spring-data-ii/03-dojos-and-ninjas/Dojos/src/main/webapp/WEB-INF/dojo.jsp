<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Details</title>
</head>
<body>
<h1><c:out value="${dojo.name}"/> Ninjas:</h1>
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
</tr>
<c:forEach items="${dojo.ninjas}" var="ninja">
<tr>
<td><c:out value="${ninja.first_name}"></c:out></td>
<td><c:out value="${ninja.last_name}"></c:out></td>
<td><c:out value="${ninja.age}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>