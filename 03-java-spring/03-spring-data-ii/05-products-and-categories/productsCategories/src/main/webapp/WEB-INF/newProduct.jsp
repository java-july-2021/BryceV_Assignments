<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Product</title>
</head>
<body>
<h1>Create New Product: </h1>
<form method="POST" action="/newProd">
<p>
<label for="name">Product Name: </label>
<input type="text" name ="product">
</p>
<p>
<label for="decription">Description: </label>
<input type="text" name="description">
</p>
<p>
<label for="price">Price: </label>
<input type="number" name="price" step="0.01">
</p>
<button>Create!</button>
</form>
</body>
</html>