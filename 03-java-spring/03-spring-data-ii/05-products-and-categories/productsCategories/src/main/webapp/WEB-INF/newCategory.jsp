<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>
<h1>Create New Category: </h1>
<form method="POST" action="/newCat">
<label for="name">Category Name: </label>
<input type="text" name ="cat">
<button>Create!</button>
</form>
</body>
</html>