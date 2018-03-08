<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<title>CoCollect</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" media="screen" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/myStyle.css">
<link rel="stylesheet" type="text/css" href="/resources/css/starter-template.css">
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
<link rel="stylesheet" type="text/css" href="/resources/css/button.css">
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
<style>
.error {
	color: red;
}
</style>
</head>

<body>

<div class="container" style="width:450px;">

<br/>
<h2>Login page</h2>
<hr/>
<p>
<c:if test="${error == true}">
	<b class="error">Invalid login or password.</b>
</c:if>
<c:if test="${logout == true}">
	<b class="logout">You have been logged out.</b>
</c:if>
</p>

	<c:url value="/login" var="loginUrl"/>
	<form action="${loginUrl}" method="post" modelAttribute="user">       
		<c:if test="${param.error != null}">        
			<p>Invalid username and password.</p>
		</c:if>
		<c:if test="${param.logout != null}">       
			<p>You have been logged out.</p>
		</c:if>
		<p>
			<label class="sr-only" for="username">Email</label>
			<input class="form-control"  type="text" id="username" name="username" placeholder="Email" required autofocus/>	
		</p>
		<p>
			<label class="sr-only" for="password">Password</label>
			<input class="form-control" type="password" id="password" name="password" placeholder="Password" required/>	
		</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<hr/>
		<button type="submit" class="btn btn-lg btn-primary btn-block" >Log in</button>
	</form>	
</div>
</body>
</html>