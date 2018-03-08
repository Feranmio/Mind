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
<link rel="stylesheet" type="text/css" href="/resources/css/table.css">
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
<link rel="stylesheet" type="text/css" href="/resources/css/button.css">
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css">
</head>

<body>
<ul>
	<div class="topnav" id="myTopnav">
 		<a href="/">Home</a>
  		<a href="/admin/caseSummary/">Case Summary</a>
  		<a class="active" href="/admin/debtorSummary/">Debtors</a>
  		<a href="/admin/clientSummary/">Clients</a>
  		<a href="/admin/adminOfficers/">Admin</a>
  		
<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
	</form>   		
	
	<li style="float:right"><a href="/admin/adminDashboard/">Admin Dashboard</a></li>
	</div>
</ul>
<br/>

<div class="container" style="width:450px;">
	<form action="/admin/debtorRegister" style="width: 500px">
	<h2 class="form-signin-heading" style="font-size:30px;">Add New Debtor</h2>
      	
  		<hr size="10">
  		<h2 style="font-size: 20px;">Debtor Details</h2>
        <hr size="10">

        <label for="verificationNumber" class="sr-only">First Name</label>
        <input name="firstname" type="text" id="inputEmail" class="form-control" placeholder="First Name" required autofocus>
        
        <label for="inputPassword" class="sr-only">Last Name</label>
        <input name="lastname" type="text" id="inputPassword" class="form-control" placeholder="Last Name" required>
        
        <label for="inputPassword" class="sr-only">Email</label>
        <input name="email" type="text" id="inputPassword" class="form-control" placeholder="Email" required>

        <label for="inputPassword" class="sr-only">Company Name</label>
        <input name="companyName" type="text" id="inputPassword" class="form-control" placeholder="Comapny Name" required>
        
        <label for="verificationNumber" class="sr-only">Company Type</label>
        <select name="companyType" id="inputEmail" class="form-control" required>
         	<option value="" selected>--Company Type--</option>
         	<option value="Individual">Individual</option>
  			<option value="Sole Trader">Sole Trader</option>
 			<option value="LLP">LLP</option>
  			<option value="Partnership">Partnership</option>
  			<option value="Trust/Charity">Trust/Charity</option>
  			<option value="PLC">PLC</option>
		</select>
        
        <label for="inputPassword" class="sr-only">Address</label>
        <input name="address" type="text" id="inputPassword" class="form-control" placeholder="Address" required>
        
        <label for="inputPassword" class="sr-only">Phone</label>
        <input name="phone" type="text" id="inputPassword" class="form-control" placeholder="Phone" required>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="text" id="inputPassword" class="form-control" placeholder="Password" required>
  
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/caseSummary/'">Cancel</button>
	</form>
</div>
<p>Do java script validation</p>
</body>
</html>