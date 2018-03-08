<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ePetition.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:c="http://java.sun.com/jstl/core">
<head><base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Petitions</title>
<link rel="stylesheet" type="text/css" href="./css/dashboard.css">
</head>
<body>
<h2>Petition Summary</h2>
<section>
<button class="button" onclick="window.location.href='home.jsp'">Home</button>
<button class="button" onclick="window.location.href='newPetition.jsp'">Add New Petition</button>
<button class="button" onclick="window.location.href='./Logout'">Logout</button>
</section>

<section>
<table >
<tr>
  <td><h3>Id</h3></td>
  <td><h3>Petition</h3></td>
  <td><h3>Description</h3></td>
  <td><h3>Date</h3></td>
  <td><h3>Creator</h3></td>
  <td><h3>Signed</h3></td>
  <td><h3></h3></td>
  <td><h3></h3></td>
</tr>

<% int i=1;
for(Petition p: UserVerification.getAllPetitions()){
%>
<tr>
<td><%= i++ %></td>
<td><%= p.getTitle() %></td>
<td><%= p.getContent() %></td>
<td><%= p.getDate() %></td>
<td><%= p.getCreator() %></td>
<td><%= p.getSign()%></td>
<td><button class="button" onclick="window.location.href='editPetition.jsp?id=<%= p.getId() %>'">Edit</button></td>
<td><button class="button" onclick="window.location.href='view.jsp?id=<%= p.getId() %>'">View</button></td>

</tr>
<%
}
%>

</table>
</section>
</body>
</html>