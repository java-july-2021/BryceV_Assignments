<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Submitted Info</h1>
	<p><strong>Name:</strong> <c:out value="${name}"/></p>
	<p><strong>Language:</strong> <c:out value="${location}"/></p>
	<p><strong>Location:</strong> <c:out value="${language}"/></p>
	<p><strong>Comment:</strong> <c:out value="${comment}"/></p>
</body>
</html>