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
  		<a href="/admin/debtorSummary/">Debtors</a>
  		<a class="active" href="/admin/clientSummary/">Clients</a>
  		<a href="/admin/adminOfficers/">Admin</a>
  		
	<c:url value="/logout" var="logoutUrl"/>
		<form action="${logoutUrl}" method="get">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<a style="float:right"><button type="submit" class="btn">${User.firstname} || Log out</button></a>
		</form>   		
	
	<li style="float:right"><a href="/admin/adminDashboard/">Admin Dashboard</a></li>
	</div>
</ul>
<h2>Clients</h2>
<br/>
<div>
<table id="client">
<button class="button">Filter</button>
<button class="button" onclick="window.location.href='/admin/clientRegister'">Add New Client</button>


<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Company</th>
<th>Company Type</th>
<th>Address</th>
<th>Phone</th>
<th></th>
</tr>

<c:forEach items="${clientList}" var="client" varStatus="itr">
<tr style="font-size: 15px;">
<td>${client.id}</td>
<td>${client.lastname} ${client.firstname}</td>
<td>${client.email}</td>
<td>${client.companyName}</td>
<td>${client.companyType}</td>
<td>${client.address}</td>
<td>${client.phone}</td>
<td></td>
</tr>
</c:forEach>

</table>
</div>

<p>List of all Creditors</p>

</body>
</html>