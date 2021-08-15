<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thoughts</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
<div class="col">
<h1>Hi <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"></c:out>!</h1>
</div>
<div class="col">
<a href="/logout" id="logout" class="btn btn-primary">Logout</a>
</div>
</div>
<form:form method="POST" action="/postThought" modelAttribute="thought">
	<p><form:errors path="message"/></p>
	<form:input type="text" class="longer" placeholder="Post a Great Thought Here!" path="message"/>
    <form:input type="hidden" value="${user.id}" path="user"/>
    <input type="submit" value="Add Thought!"/>
</form:form>
<hr>

<c:forEach items="${allThoughts}" var="thought">
<div class="row" id="post">
<div class="col-2">
<p class="poster">
<c:out value="${thought.user.firstName}"></c:out> says: 
</p>
</div>
<div class="col-9">
<p class="postM">
<c:out value="${thought.message}"></c:out>
</p>
<p>
<c:choose>
<c:when test="${thought.likers.contains(user)}">
<a href="/unlike/${thought.id}" class="btn btn-secondary">unLike</a>
</c:when>
<c:otherwise>
<a href="/like/${thought.id}" class="btn btn-primary">Like</a>
</c:otherwise>
</c:choose>
${thought.likers.size()}
<c:if test="${thought.user.id == user.id}">
<a href="/delete/${thought.id}" id="delete" class="btn btn-danger">Delete</a>
<a href="/edit/${thought.id}" id="edit" class="btn btn-warning">Edit Thought</a>
</c:if>
</p>
</div>
</div>
</c:forEach>
</div>
</body>
</html>