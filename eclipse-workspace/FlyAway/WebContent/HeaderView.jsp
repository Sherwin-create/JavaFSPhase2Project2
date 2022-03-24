<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	* {
    margin: 0;
    padding: 0;
    font-family: 'Poppins', sans-serif;
}

/* .header {
    min-height: 100vh;
    width: 100%;
   /*  background-image: linear-gradient(to top, #48c6ef 0%, #6f86d6 100%);
    background-position: center; */
    background-size: cover;
    position: relative;
} */

nav{
    display: flex;
    padding: 2% 6%;
    justify-content: space-between;
    align-items: center;
}

.nav-links {
    flex: 1;
    text-align: center;
}

.nav-links ul li {
    list-style: none;
    display: inline-block;
    padding: 8px 12px;
    position: relative;
}

.nav-links ul li a {
    color: black;
    text-decoration: none;
    font-size: 13px;
    
}

.nav-links ul li::after {
    content: '';
    width: 0%;
    height:2px;
    background: #f44336;
    display: block;
    margin: auto;
    transition: 0.5s;
}

.nav-links ul li:hover::after {
    width: 100%;
}

th,td {
		padding: 5px;
		margin: 2px;	
		text-align: center;
	 }
	 
 
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="header">
<nav>
	<div class="nav-links">
        <ul>
            <li><a href="index.html">HOME</a></li>
            <li><a href="AdminLogin.html">ADMIN LOGIN</a></li>
       </ul>
    </div>
</nav>	
<div align="center">
<h1 class="flyaway">FlyAway</h1>
<br>
<p>Your one stop flight booking site</p>
<br>
<hr>
<br>
<br>
</div>
</section>


</body>
</html>