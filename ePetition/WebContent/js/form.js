/**
 * 
 */
function validateRegister() {
    var a = document.forms["index"]["name"].value;
    var b = document.forms["index"]["email"].value;
    var c = document.forms["index"]["dob"].value;
    var d = document.forms["index"]["address"].value;
    var e = document.forms["index"]["pass"].value;
    var f = document.forms["index"]["nic"].value;

    if (a == ""|| b == "" || c == ""|| d == ""||e == ""||f == ""){
    	alert("Please Fill In All Fields Properly");
        return false;
    }
} 

function validateLogin() {
    var a = document.forms["login"]["email"].value;
    var b = document.forms["login"]["pass"].value;
    
    if (a == ""|| b == ""){
    	alert("Please Fill In All Fields Properly");
        return false;
    }
} 

function validateComment(){
	var a =document.forms["com"]["comment"].value;
	var regex;
	if(a == ""){
    	alert("Please Fill In Comment");
        return false;
	}
	
}

	function validEmail(email){
		var email= document.forms["index"]["email"].value;
		var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		
		if(!regex.test(email)){
			 alert("Use a valid email address");
		}
	}