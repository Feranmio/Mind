<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/login.css">
<script type="text/javascript" src="./js/form.js"></script>
<title>Login</title>
</head>
<body>
<body>
<h1>Login</h1>

<form name="login" action="./Login" method="GET" onsubmit="return validateLogin()">
<div>
	<input type="text" id="email" name="email" placeholder="Email"/><br/>
	<input type ="password" name="pass" placeholder="Password"/><br/>
	<input type="submit" name="submit" id="validate" value="Login">
	<a href="index.jsp">Click here to register if you don't have an account</a>
</div>
</form>

</body>
</html>
