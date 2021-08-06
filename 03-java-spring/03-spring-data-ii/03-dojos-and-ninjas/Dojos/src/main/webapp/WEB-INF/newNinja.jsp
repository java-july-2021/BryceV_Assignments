<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<h1>Create Ninja:</h1>
<form:form method="POST" action="/ninja/createNinja" modelAttribute="ninja">
<p>
<form:label path="dojo">Dojo Name:</form:label>
<form:errors path="dojo"/>
<form:select path="dojo">
<c:forEach items="${allDojos}" var="dojo">
<option value="${dojo.id}">${dojo.name}</option>
</c:forEach>
</form:select>
</p>
<p>
<form:label path="first_name">First Name:</form:label>
<form:errors path="first_name"/>
<form:input path="first_name"/>
</p>
<p>
<form:label path="last_name">Last Name:</form:label>
<form:errors path="last_name"/>
<form:input path="last_name"/>
</p>
<p>
<form:label path="age">Age:</form:label>
<form:errors path="age"/>
<form:input path="age"/>
</p>
<button>Create Ninja</button>
</form:form>
</body>
</html>