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

<title>ePetition</title>
</head>
<body>
<h1>HOME</h1>
<p>Welcome <%= u.getFullname()%> <p>

<h2>Have A Say!</h2>

<section>
<button class="button" onclick="window.location.href='ViewPetitions.jsp'">Petitions</button>
<button class="button" onclick="window.location.href='./Logout'">Logout</button>
</section>

</body>
</html>
<%}%>