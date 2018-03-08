	function myFunction() {
    var x = document.getElementById("myDIV");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
	
	function myFunction2() {
	    var x = document.getElementById("myDIV2");
	    if (x.style.display === "none") {
	        x.style.display = "block";
	    } else {
	        x.style.display = "none";
	    }
	}
	
	window.onload = function() {
		  document.getElementById('myDIV').style.display = 'none';
		  document.getElementById('myDIV2').style.display = 'none';
		};
