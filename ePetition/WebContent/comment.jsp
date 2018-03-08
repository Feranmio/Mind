<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ePetition.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/dashboard.css">
<title>Add A Comment</title>
</head>
<body>
<h2>Add A Comment</h2>
<%  
String id = request.getParameter("id");
Petition p =  UserVerification.getPetition(id);
%>
<form:form method="POST" action="./Comment">
<input type="hidden" name="id" value="<%= p.getId() %>"/><br/>
<input type="text" name="petition" disabled value="<%= p.getTitle() %>"/><br/>
<textarea rows="4" cols="30" disabled placeholder="Description" ><%= p.getContent()%></textarea><br/>
<textarea rows="4" cols="30" name="comment" placeholder="Comment"></textarea><br/>
<button type="submit" class="button">Submit</button>
<button class="button" onclick="window.location.href='view.jsp?id=<%= p.getId() %>'">Cancel</button>
</form:form>

</body>
</html>


<!-- <section> -->
<!-- <form method="POST" action="./Comment"> -->
<%-- <input type="hidden" name="id" value="<%=p.getId()%>"/><br/> --%>
<!-- <textarea rows="4" cols="30" name="comment" placeholder="Comment"></textarea><br/> -->
<!-- <br/> -->
<!-- <button type="submit" class="button">Submit</button> -->
<!-- </form> -->
<!-- </section> -->