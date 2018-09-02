<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="employee.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="navigation.css"/>
<link rel="stylesheet" type="text/css" href="menustyle.css"/>
<link rel="stylesheet" type="text/css" href="admin.css">
<title>Insert title here</title>
</head>
<body>
<%EmpBean emp=(EmpBean)session.getAttribute("emp"); %>
<div class="wrapper">
			<header>
				<h1 align="right">Human Resource Management System</h1>
				<nav align="center">
					<ul>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Index.html">HOME</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/About.html">ABOUT US</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp">ADMIN</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Emp_Login.jsp">EMPLOYEE</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Notice.html">NOTICE</a></li>
						<li><a href="http://127.0.0.1:8080/HRMSWAR/Contact.html">CONTACT US</a></li>
					</ul>
				</nav>
			</header>
			<section class="vermenu">
				 <div id="navigation">
				    <ul class="top-level">
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/EmpHome.jsp">Profile</a>
            				<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/EmpHome.jsp">View</a></li>
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/EditEmpProfile.jsp">Edit</a></li>
            				</ul>
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/Attendance.jsp">Attendance</a>      
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/LeaveRequest.jsp">Leave Request</a>
        				</li>
        				<li><a href="#">Account Setting</a>
            				<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/ChangeEmpPassword.jsp">Change Password</a></li>
            				</ul>
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/EmpLogOut">Log Out</a>
        				</li>
    				</ul>
				</div>
			</section>
			<aside>
			<section class="login">
			<h2 align="center">Leave Request</h2>
				<form method="post" action="LeaveRequest">
				<table align="center">
				
				<tr>
					<th>Id</th>
					</th>
					<td><input type="text" name="empid" value="<%=emp.getEmpid() %>"/>
					</td>
				</tr>
				<tr>
					<th>Department</th>
					</th>
					<td><input type="text" name="dept" value="<%=emp.getEmpdept() %>"/>
					</td>
				</tr>
				<tr>
					<th>Name</th>
					</th>
					<td><input type="text" name="name" value="<%=emp.getEmpname() %>"/>
					</td>
				</tr>
				<tr>
					<th>Type of Leave</th>
					</th>
					<td><select name="type_of_leave">
					<option value="Casual Leave">Casual Leave</option>
					<option value="Privilaged Leave">Privilaged Leave</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>Date From</th>
					</th>
					<td><input type="text" name="datefrom" palceholder="01-01-2014"/>
					</td>
				</tr>
				<tr>
					<th>Date to</th>
					</th>
					<td><input type="text" name="dateto" palceholder="01-01-2014"/>
					</td>
				</tr>
				<tr>
					<th>Total Days</th>
					</th>
					<td><input type="text" name="totaldays"/>
					</td>
				</tr>
				<tr>
					<th>Reason</th>
					</th>
					<td><input type="text" name="reason"/>
					</td>
				</tr>
				<tr>
					<td><input type="hidden" name="status" value="Pending"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="Send"/>
					</td>
				</tr>
				
				</table>
				</form>
				</section>
			</aside>
			
			<footer align="center">
				&copy; 2014 Abhishek Singh
			</footer>
		</div>


</body>
</html>