<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ePetition.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/dashboard.css">
<title>Edit Petition</title>
</head>
<body>
<%
String id = request.getParameter("id");
Petition p = UserVerification.getPetition(id);
%>
<h2>Edit Petition</h2>
<form method="POST" action="./EditPetition">
<input type="hidden" name="id" value="<%= p.getId() %>"/><br/>
<input type="text" name="petition" value="<%= p.getTitle() %>"/><br/>
<textarea rows="4" cols="30" name="description" ><%= p.getContent()%></textarea><br/>
<button type="submit" class="button">Submit</button>
<button class="button" onclick="window.location.href='ViewPetitions.jsp'">Cancel</button>
</form>
</body>
</html>