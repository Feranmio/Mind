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
<script type="text/javascript" src="./js/form.js"></script>
<title>Petition</title>
</head>

<body>
<%
String id = request.getParameter("id");
Petition p = UserVerification.getPetition(id);
%>
<h2>Petition</h2>
<section>
<input disabled value="<%= p.getId() %>"/><br/>
<input type="text" disabled name="petition" value="<%= p.getTitle() %>"/><br/>
<textarea rows="4" cols="30" disabled ><%= p.getContent()%></textarea><br/>
<p><%= p.getSign()%> people have signed this petition<p>
<button class="button" onclick="window.location.href='signPetition.jsp?id=<%= p.getId()%>'">Sign This Petition</button>
<%-- <button class="button" onclick="window.location.href='comment.jsp?id=<%= p.getId()%>'">Comment</button> --%>
<button class="button" onclick="window.location.href='ViewPetitions.jsp'">Cancel</button>
</section>

<hr/>
<section>
<h2>Comments</h2>
<hr/>
<table>
<tr>
<!-- <td><h3>Id</h3></td> -->
<td><h3>Id</h3></td>
<td><h3>Comment</h3></td>
<td><h3>MP</h3></td>
</tr>
<% int i=1;
for(CommentInfo com: Comment.getComments(id)){
%>
<tr>
<td><%=i++%></td>
<td><%=com.getComment()%></td>
<td><%=com.getBy_mp()%></td>

</tr>
<%
}
%>
</table>
</section>

<section style="display: <%=u.getPosition() == 0?"none":"block"%>"href="./view.jsp?id=<%=p.getId()%>">
<form name="com" method="POST" action="./Comment" onsubmit="return validateComment()">
<input type="hidden" name="id" value="<%=p.getId()%>"/><br/>
<input type="hidden" name="mp" value="<%=u.getFullname()%>"/><br/>
<textarea rows="4" cols="30" name="comment" placeholder="Comment"></textarea><br/>
<br/>
<button type="submit" class="button">Submit</button>
</form>
<button class="button" onclick="window.location.href='ViewPetitions.jsp'">Cancel</button>

</section>

</body>
</html>
<%
}
%>