$(document).ready(function(){
	
});

var isLoggedIn = false;



if (isLoggedIn == false) {
	document.getElementById("loginLogout").href="CatLogin.xhtml";
	document.getElementById("loginSignUp").innerHTML="Login / Sign Up";
} else {
	document.getElementById("loginLogout").href="CatHome.xhtml";
	document.getElementById("loginSignUp").innerHTML="Logout";
}