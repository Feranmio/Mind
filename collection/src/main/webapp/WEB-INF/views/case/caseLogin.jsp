<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>CoCollect</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" media="screen" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/myStyle.css">
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
<link rel="stylesheet" type="text/css" href="/resources/css/signin.css">
</head>
<body>
<ul>
	<div class="topnav" id="myTopnav">
 		<a href="/">Home</a>
 		<a class="active" href="/case/caseLogin">Case Summary</a>
 		<a href="/case/pay">Make a Payment</a>
  		<a href="/case/paymentPlan/">Payment Plan</a>
  		<a href="/case/inOut">Incomings and Outgoings</a>
  		<a href="#help">Help</a>
 		
		<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">       
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
	</form>
	
	<li style="float:right"><a href="/case/caseDashboard/">Case Dashboard</a></li>
  		
	</div>
</ul>

<br/><br/><br/><br/><br/>

<div class="container" style="width:500px;">
      <form action="/case/login" class="form-signin">
      	<h2 class="form-signin-heading">Please Verify Case</h2>
        <label for="verificationNumber" class="sr-only">Case ID</label>
        <input name="caseId" type="verificationNumber" id="inputEmail" class="form-control" placeholder="Case ID" required autofocus>
        
     	<div class="checkbox">
<!--           <label> -->
<!--             <input type="checkbox" value="remember-me"> Remember me -->
<!--           </label> -->
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Verify</button>
      </form>
</div> <!-- /container -->
</body>
</html>