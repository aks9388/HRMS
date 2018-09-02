<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="employee.*,leaverqst.*,java.util.*"%>
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
			<table align="center" width="500px" >
	<tr>
		<th align="center">ID</th>
		<th align="center">Name</th>
		<th align="center">Department</th>
		<th align="center">Type of Leave</th>
		<th align="center">Date from</th>
		<th align="center">Date to</th>
		<th align="center">Total days</th>
		<th align="center">Reason</th>
		<th align="center">Status</th>	
	</tr>
<%ArrayList<LrqstBean> array=(ArrayList<LrqstBean>)request.getAttribute("array");
for(LrqstBean leave:array)
{%>

	<tr>
		<td><%=leave.getEmpid() %></td>
		<td><%=leave.getName() %></td>
		<td><%=leave.getDept() %></td>
		<td><%=leave.getType_of_leave() %></td>
		<td><%=leave.getDatefrom() %></td>
		<td><%=leave.getDateto() %></td>
		<td><%=leave.getTotal_day() %></td>
		<td><%=leave.getReason() %></td>
		<td><%=leave.getStatus() %></td>
	</tr>


	
<%
}
 %>
 </table>
				</section>
			</aside>
			
			<footer align="center">
				&copy; 2014 Abhishek Singh
			</footer>
		</div>



</body>
</html>