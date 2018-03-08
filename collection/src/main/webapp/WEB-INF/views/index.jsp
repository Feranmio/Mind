<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

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
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
</head>

<body>
<ul>
	<div class="topnav" id="myTopnav">
 		<a class="active" href=".">Home</a>
  		
  		<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
	</form>

  		<li style="float:right"><a href="/admin/">Admin</a></li>
   		<li style="float:right"><a href="/client/">Client</a></li>
  		<li style="float:right"><a href="/case/">Case</a></li>
	</div>
</ul>

<div id=logo>
<a href=".">
	<img src="/resources/img/logo.png" alt="logo" height="43" width="250"/>
</a>
<br/><br/><br/>
</div>

<div>
	<c:url value="/logout" var="logoutUrl"/>
		<form action="${logoutUrl}" method="get">
			<a href="/case/" class="btn btn-default">Case</a>
			<a href="/client/" class="btn btn-default">Client</a>
			<a href="/admin/" class="btn btn-default">Admin</a>
	    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn btn-default">Log out</button>
		</form>				
</div>

</body>
</html>