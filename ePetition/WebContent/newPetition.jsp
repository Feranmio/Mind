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
<title>New Petition</title>
</head>
<body>
<h2>Add A New Petition</h2>
<form method="POST" action="./NewPetition">
<input path="id" name="id" type="text" placeholder="Id"/><br/>
<input type="text" name="petition" placeholder="Petition Title"/><br/>
<input type="text" name="date" placeholder="Date:yyyy-mm-dd"/><br/>
<textarea rows="4" cols="30" name="description" placeholder="Description"></textarea><br/>
<label>Creator:</label><br/>
<input type="text" readonly name="creator" value="<%= u.getFullname() %>"/>
<br/>
<button type="submit" class="button">Submit</button>
<button class="button" onclick="window.location.href='ViewPetitions.jsp'">Cancel</button>
</form>
</body>
</html>
<%}%>