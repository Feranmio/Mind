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
<script type="text/javascript" src="/resources/js/hideForm.js"></script>

</head>

<body>
<ul>
	<div class="topnav" id="myTopnav">
 		<a href="/">Home</a>
  		<a class="active" href="/admin/caseSummary/">Case Summary</a>
  		<a href="/admin/debtorSummary/">Debtors</a>
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
      <h2 class="form-signin-heading" style="font-size:30px;">Submit New Case</h2>
      <button class="btn btn-lg btn-primary btn-block" onclick="myFunction2()">Already Existing Debtor</button>
      <button class="btn btn-lg btn-primary btn-block" onclick="myFunction()">New Debtor</button>      
</div>

<div id="myDIV" class="container" style="width:450px;">
      <form class="form-signin" action="/admin/newCase" >
      	<hr size="10">
  		<h2 style="font-size: 20px;">Case Details</h2>
        <hr size="10">
        
        <label for="verificationNumber" class="sr-only">Reason</label>
        <input name="reason" type="text" id="inputEmail" class="form-control" placeholder="Reason" required autofocus>
        
        <label for="inputPassword" class="sr-only">Service</label>
        <input name="service" type="text" id="inputPassword" class="form-control" placeholder="Service Offered" required>
        
        <label for="inputPassword" class="sr-only">Date </label>
        <input name="date" type="text" id="inputPassword" class="form-control" placeholder="Date Incurred" required>
        
        <label for="inputPassword" class="sr-only">Amount </label>
        <input type="number" min="0.00" class="form-control" name="amount" placeholder="Amount in Pounds Sterling (£)">
        
        <label for="inputPassword" class="sr-only">Debtor Name</label>
        <input name="debtorName" type="text" id="inputPassword" class="form-control" placeholder="Debtor Name" required>
        
        <label for="inputPassword" class="sr-only">Creditor Name</label>
        <input name="creditorName" type="text" id="inputPassword" class="form-control" placeholder="Creditor Name" required>
       
        <label for="inputPassword" class="sr-only">Additional Information</label>
    	<textarea name="info" class="form-control" placeholder="Enter additional information here..." rows="4" cols="50"></textarea>
    
  		<hr size="10">
  		<h2 style="font-size: 20px;">Debtor Details</h2>
        <hr size="10">

	<label for="verificationNumber" class="sr-only">Title</label>
        <select name="title" id="inputEmail" class="form-control" required>
         	<option value="" selected>--Title--</option>
  			<option value="Mr">Mr</option>
 			<option value="Mrs">Mrs</option>
  			<option value="Miss">Miss</option>
  			<option value="Ms">Ms</option>
  			<option value="Dr">Dr</option>
		</select>

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
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/caseSummary'">Cancel</button>
        
      </form>
</div> <!-- /container -->

<div id="myDIV2" class="container" style="width:450px;">
      <form class="form-signin" action="/admin/newCase2" >
      	<hr size="10">
  		<h2 style="font-size: 20px;">Case Details</h2>
        <hr size="10">
        
        <label for="verificationNumber" class="sr-only">Reason</label>
        <input name="reason" type="text" id="inputEmail" class="form-control" placeholder="Reason" required autofocus>
        
        <label for="inputPassword" class="sr-only">Service</label>
        <input name="service" type="text" id="inputPassword" class="form-control" placeholder="Service Offered" required>
        
        <label for="inputPassword" class="sr-only">Date </label>
        <input name="date" type="text" id="inputPassword" class="form-control" placeholder="Date Incurred" required>
        
        <label for="inputPassword" class="sr-only">Amount </label>
        <input type="number" min="0.00" class="form-control" name="amount" placeholder="Amount in Pounds Sterling (£)">
        
        <label for="inputPassword" class="sr-only">Debtor Name</label>
        <input name="debtorName" type="text" id="inputPassword" class="form-control" placeholder="Debtor Name" required>
        
        <label for="inputPassword" class="sr-only">Creditor Name</label>
        <input name="creditorName" type="text" id="inputPassword" class="form-control" placeholder="Creditor Name" required>
       
        <label for="inputPassword" class="sr-only">Additional Information</label>
    	<textarea name="info" class="form-control" placeholder="Enter additional information here..." rows="4" cols="50"></textarea>
    
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/caseSummary'">Cancel</button>
        
      </form>
</div> <!-- /container -->
        <br/>
        <br/>
<p>Case has successfully been submitted admin will verify
Do java script validation
ajax verification to check already existing debtors
</p>
</body>
</html>