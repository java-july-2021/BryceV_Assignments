<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Search</title>
</head>
<body>
	<h1>Welcome, everyone!</h1>
	<hr>
	<p>You searched for: <c:out value="${search}"/>
</body>
</html>