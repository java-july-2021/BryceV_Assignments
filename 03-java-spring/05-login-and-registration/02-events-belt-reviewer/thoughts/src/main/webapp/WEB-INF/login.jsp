<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register</title>
</head>
<body>
<h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form:form method="POST" action="/login" modelAttribute="user">
    <fieldset>
    <legend>Login</legend>
     	<p><form:errors path="email"/></p>
        <p>
            <form:label path="email">Email</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p><form:errors path="password"/></p>
        <p>
            <form:label path="password">Password: </form:label>
            <form:password path="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </fieldset>
    </form:form>
    
<h1>Register!</h1>
    
    <%-- <p><form:errors path="user.*"/></p> --%>
    
    <form:form method="POST" action="/register" modelAttribute="user">
    <fieldset>
    <legend>Register</legend>
    	<p><form:errors path="firstName"/></p>
    	<p>
    		<form:label path="firstName">First Name: </form:label>
    		<form:input type="text" path="firstName"/>
    	</p>
    	<p><form:errors path="lastName"/></p>
    	<p>
    		<form:label path="lastName">Last Name: </form:label>
    		<form:input type="text" path="lastName"/>
    	</p>
        <p><form:errors path="email"/></p>
        <p>
            <form:label path="email">Email: </form:label>
            <form:input type="email" path="email"/>
        </p>
        <p><form:errors path="password"/></p>
        <p>
            <form:label path="password">Password: </form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="confirmPw">Password Confirmation: </form:label>
            <form:password path="confirmPw"/>
        </p>
        <input type="submit" value="Register!"/>
        </fieldset>
    </form:form>
</body>
</html>