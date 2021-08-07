<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Dojo</th>
<th>Actions</th>
<th>Number of Ninjas</th>
</tr>
<c:forEach items="${allDojos}" var="dojo">
<tr>
<td><c:out value="${dojo.name}"></c:out></td>
<td><a href="/dojo/${dojo.id}">View Dojo Page</a></td>
<td><c:out value="${dojo.ninjas.size()}"></c:out></td>
</tr>
</c:forEach>
</table>
<hr>
<a class="button" href="/ninja/new">Create New Ninja</a>
<a class="button" href="/dojo/new">Create New Dojo</a>
</body>
</html>