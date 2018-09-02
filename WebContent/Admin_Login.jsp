<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="navigation.css">
<link rel="stylesheet" type="text/css" href="admin.css">
<title>Admin Login Page</title>
</head>
<body>
<div class="wrapper">
			<header>
				<h1 align="right">Human Resource Management System</h1>
				<nav align="center">
					<ul>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Index.html">HOME</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/About.html">ABOUT US</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp">ADMIN</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/EmployeeLogin.jsp">EMPLOYEE</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Notice.html">NOTICE</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Contact.html">CONTACT US</a></li>
					</ul>
				</nav>
			</header>
			<section class="login">
				<h2 align="center">Admin's Login</h2>
				</h2>
				<table align="center" width=200px>
				<form action="AdminLoginCheck" method="post">
				<tr>
					<th>User ID:</th>
					<td><input type="text" name="id"/>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="pass"/>
				</tr>
				<tr >
					<th colspan="2" align=center><input type="submit" value="Log In"/></th>
				</tr>
				</form>	
				</table>	
			</section>
			
			<footer align="center">
				&copy; 2014 Abhishek Singh
			</footer>
		</div>

</body>
</html>