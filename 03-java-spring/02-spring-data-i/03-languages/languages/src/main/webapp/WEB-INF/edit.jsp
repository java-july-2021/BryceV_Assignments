<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<h1>Edit Language</h1>
<form:form action="/edit/${Language.id}" method="POST" modelAttribute="Language">
<p>
<form:label path="name">Name: </form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>

<p>
<form:label path="creator">Creator: </form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>

<p>
<form:label path="currentVersion">Version: </form:label>
<form:errors path="currentVersion"/>
<form:input path="currentVersion"/>
</p>
<input type="hidden" name="_method" value="put">
<button>Submit</button>

</form:form>
</body>
</html>