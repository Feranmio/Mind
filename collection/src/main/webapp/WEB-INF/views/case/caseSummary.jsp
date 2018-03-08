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
<div class="container" style="width:450px; font-size: 20px;">
<h2>Case Summary</h2>
<br/>

<table>
	<tr>
  		<td>CaseId: </td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Case Reason: </td>
        <td>${reason}</td>
    </tr>
    <tr>
  		<td>Service Offered by ${creditorName}:</td>
        <td>${service}</td>
    </tr>
    <tr>
  		<td>Date Debt was Incurred: </td>
        <td>${date}</td>
    </tr>
    <tr>
  		<td>Amount: </td>
        <td>${amount}</td>
    </tr>
    <tr>
  		<td>Additional Information: </td>
        <td>${info}</td>
    </tr>
  	<tr>
  		<td>Name: </td>
        <td>${debtorName}</td>
    </tr>
    <tr>
  		<td>Creditor: </td>
        <td>${creditorName}</td>
    </tr>

    <tr>
  		<td>Fully Paid: </td>
        <td>${paid}</td>
    </tr>
</table>
</div>
<br/>
<br/>
<br/>

<p>Information about a particular case</p>


<p>instruct us on new cases</p>
<p>scanned documents, transcripts of telephone conversations and a breakdown of costs and interest accrued to date</p>

</body>
</html>