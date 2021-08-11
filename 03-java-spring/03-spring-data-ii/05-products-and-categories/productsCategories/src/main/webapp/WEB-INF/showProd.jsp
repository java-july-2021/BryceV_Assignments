<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>
<p>Description: <c:out value="${product.description}"/></p>
<p>Price: <c:out value="${product.price}"/></p>

<hr>
<h2>Categories</h2>
<ul>
<c:forEach items="${product.categories}" var="cat">
<li>${cat.name}</li>
</c:forEach>
</ul>
<h3>Add Category: </h3>
<form method="POST" action="/addCatToProd/${product.id}">
<Select name="cats">
<c:forEach items="${notInProd}" var="cat">
<option value="${cat.id}">${cat.name}</option>
</c:forEach>
</Select>
<button>Add Category</button>
</form>
</body>
</html>