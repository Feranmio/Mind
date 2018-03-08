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
 		<a href="/case/caseLogin">Case Summary</a>
 		<a href="/case/pay">Make a Payment</a>
  		<a class="active" href=".">Payment Plan</a>
  		<a href="/case/inOut">Incomings and Outgoings</a>
  		<a href="#help">Help</a>
  		
		<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">       
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
	</form>  		
	
	<li style="float:right"><a href="/case/caseDashboard">Case Dashboard</a></li>
	</div>
</ul>

<div style="width:450px;">
<h2>Payment Plan</h2>
<hr/>
<form action="/case/paymentPlan" style="width: 400px;">

  <div class="form-group" style="font-size:15px;">
    <label for="exampleInputEmail1" >Time Period</label>
    <select name="timePeriod">
    <option value="" selected >--Select--</option>
    <option value="weekly">Weekly</option>
    <option value="bi-weekly">Bi-weekly</option>
    <option value="monthly">Monthly</option>
  </select>
  <br/><br>
  
  <label for="exampleInputEmail1">Name</label>
  <input type="text" name="debtorName">
  </div>
  
 <div class="form-group" style="font-size:15px;">
    <label for="exampleInputEmail1">Amount in Pounds Sterling (£)</label>
    <input type="number" min="0.00" step="0.05" value="1.00" class="form-control" name="amount" placeholder="Amount">
  </div>
  
   <div class="form-group" style="font-size:15px;">
    <label for="exampleInputEmail1">Reason for Updating Payment Plan.</label>
	<textarea name="reason" placeholder="Enter text here..." rows="4" cols="50"></textarea>
	  <hr/>
  </div>
  
  <div style="font-size:15px; width: 400px; ">
  <button type="submit" class="button">Update</button>
  <button type="reset" class="button">Reset</button>
  <button type="button" class="button" onclick="window.location.href='/case/caseSummary'">Cancel</button>
  </div>
  
</form>
</div>
<p>
Add date
Display Most Recent payment plan</p>
<p>validate form</p>
<p>Payment plan history?</p>

</body>
</html>