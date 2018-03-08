<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="ePetition.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
HttpSession ses= request.getSession();
User u=null;
if(ses.getAttribute("User")!=null){
	u=(User)ses.getAttribute("User");
}else{
	response.sendRedirect("error.jsp?errorid=2");
}
if(u!=null){
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/dashboard.css">
<title>Sign Petition</title>
</head>
<body>
<%  
String id = request.getParameter("id");
Petition p =  UserVerification.getPetition(id);
%>
<h2>Sign Petition</h2><input name="id" disabled placeholder="Id" value="<%= p.getId() %>"/><br/>
<input type="text" disabled name="petition" placeholder="Petition Title" value="<%= p.getTitle() %>"/><br/>
<textarea rows="4" cols="30" disabled name="description"><%= p.getContent()%></textarea><br/>

<form method="POST" action="./SignPetition">
<p>By clicking the button, the name below agrees to sign this petition </p>
<input name="petition" type="hidden"value="<%= p.getTitle() %>"/>
<input type="text" readonly name="user" value="<%= u.getFullname() %>"/><br/>
<button type="submit" class="button">Sign Petition</button>
<button class="button" onclick="window.location.href='view.jsp?id=<%= p.getId() %>'">Cancel</button>
</form>
</body>
</html>

<%}%>