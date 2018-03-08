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
  		<a href="/case/paymentPlan">Payment Plan</a>
  		<a class="active" href="/case/inOut">Incomings and Outgoings</a>
  		<a href="#help">Help</a>
  		
		<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">       
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
	</form>  		
	
	<li style="float:right"><a href="/case/caseDashboard">Case Dashboard</a></li>
	</div>
</ul>

<div style="width:600px;">
<h2>Incomings and Outgoings</h2>
<hr/>
<form action="/case/inOut" style="width: 400px;">

  <div class="form-group" style="font-size:15px;">
    <label for="exampleInputEmail1" >CaseId</label>
    <input type="text" name="caseId">
  	<br/><br/>
  
  	<label for="exampleInputEmail1">Name</label>
  	<input type="text" name="name">
  	<br/><br/>
  	
  
  	<label for="exampleInputEmail1">Date</label>
  	<input type="text" name="date">
  	<br/><br/>
  	
  
  	<label for="exampleInputEmail1">Employment</label>
  	<select name="employment">
    	<option value="" selected >--Select--</option>
    	<option value="Full-time">Full-time</option>
    	<option value="Part-time">Part-time</option>
    	<option value="Unemployed">Unemployed</option>
    	<option value="Student">Student</option>
  	</select>
  	<br/><br/>
  	
  	
  	<label for="exampleInputEmail1">Dependent Children</label>
  	<input type="text" name="dependent">
   	<br/><br/>
  	
  	
  	<label for="exampleInputEmail1">Housing</label>
	<select name="housing">
    	<option value="" selected >--Select--</option>
    	<option value="Owner">Owner</option>
    	<option value="Tenant">Tenant</option>
    	<option value="Living with Parents">Living with Parents</option>
    	<option value="Other">Other</option>
  	</select>    
  </div>
  
 <div class="form-group" style="font-size:15px;">
    <label for="exampleInputEmail1">Monthly Income in Pounds Sterling (£)</label>
    <input type="number" min="0.00" value="0.00" class="form-control" name="income" placeholder="Income">
    <br/>
    
    <label for="exampleInputEmail1">Monthly Outgoings in Pounds Sterling (£)</label>
    <input type="number" min="0.00" value="0.00" class="form-control" name="outgoings" placeholder="Outgoings">
    <br/>
    
    <label for="exampleInputEmail1">Other Debts in Pounds Sterling (£)</label>
    <input type="number" min="0.00" value="0.00" class="form-control" name="debts" placeholder="Debts">
    <br/>
    
    <label for="exampleInputEmail1">Available Income After Monthly Expenditure in Pounds Sterling (£)</label>
    <input type="number" min="0.00" value="0.00" class="form-control" name="available" placeholder="Available Income">
    <br/>
    
    <label for="exampleInputEmail1">Additional Information</label>
    <textarea name="info" placeholder="Enter text here..." rows="4" cols="50"></textarea>
    <hr/>
 </div>
  
 <div style="font-size:15px; width: 400px; ">
  	<button type="submit" class="button">Update</button>
  	<button type="reset" class="button">Reset</button>  	
	<button type="button" class="button" onclick="window.location.href='/case/caseDashboard'">Cancel</button>
 </div>
  
</form>
</div>
<p>available income use java script</p>
<p>Display Most Recent IN and out</p>
<p>validate form</p>
<p>Incomings and outgoings history?</p>

</body>
</html>