<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ePetition</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="./js/form.js"></script>
<script typ="text/javascript">
$(document).ready(function(){
	$("#nic").change(function(){
		var nic = $("#nic").val();
		$.ajax({
			type: "POST",
			url: "./CW2/NicVerification?nic="+nic,
			success: function(result){
				$("#nicmsg").html(result);
			}
		});
	});
})
</script>
</head>
<body>
<h1>Register Now</h1>
<p>Have a say!</p>

<form name="index" action="./Register" method="POST" onsubmit="return validateRegister()" > 
<div>
	<input type="text" name="name" id="name" placeholder="Full Name"/><br/>
	<input type="text" name="email" id="email" onchange="validEmail()" placeholder="Email"/><br/>
	<input type="date" name="dob"/><br/>
	<input type="text" name="address" placeholder="Full Address"/><br/>
	<input type="password" name="pass" placeholder="Password"/><br/>
	<input type="text" name="nic" id="nic" placeholder="National Identity Code"/><span id="nicmsg"></span><br/>
	
	<input type="submit" name="submit" value="Register">
	<a href="login.jsp">Click here if you already have an account</a>
</div>
</form>
</body></html>