<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
<h1>Error</h1>

<%
String errorMsg="Access denied";
String errorid=request.getParameter("errorid");
if(errorid!=null){
	if(errorid.equals("1")){
		errorMsg+= " - Wrong password or email.";
	}else if(errorid.equals("2")){
		errorMsg+=" - Session expired.";
	}else{
		errorMsg+=" - You are not authorized to access this page.";
	}
}else{
	errorMsg+=" - An unexpected error has occurred.";
}
%>

<div>
	<label for="link"><%=errorMsg%></label>
	<label>Please <a href="login.jsp">login</a></label>
</div>
</body>
</html>