<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DojoSurvey</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<legend>
<form method="POST" action="/result">
  <div class="form-group">
    <label for="name">Your Name:</label>
    <input type="text" class="form-control" name="name">
  </div>
  <div class="form-group">
    <label for="location">Dojo Location</label>
    <select class="form-select" name="location">
      <option>San Jose</option>
      <option>Tulsa</option>
      <option>Chicago</option>
      <option>Seattle</option>
      <option>Online</option>
    </select>
  </div>
  <div class="form-group">
    <label for="language">Favorite Language</label>
    <select class="form-select" name="language">
      <option>Python</option>
      <option>Java</option>
      <option>JavaScript</option>
    </select>
  </div>
  <div class="form-group">
    <label for="comment">Comment (optional):</label>
    <textarea class="form-control" rows="3" name="comment"></textarea>
  </div>
   <button type="submit" class="btn btn-primary mb-2">Submit</button>
</form>
</legend>
</body>
</html>