<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="employee.*,java.util.*"%>
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
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/AdminHome.jsp">Profile</a>
            				<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/AdminHome.jsp">View</a></li>
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/EditProfile.jsp">Edit</a></li>
            				</ul>
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/DisplayAllEmp">Employee</a>
 			 				<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/EmpInsert.jsp">Add</a></li>
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/DisplayAllEmp">View</a></li>
               				 	<li><a href="http://127.0.0.1:8080/HRMSWAR/EmpView.jsp">Edit</a></li>
           					</ul>       
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/DisplayAllDept">Department</a>
							<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/DepartmentInsert.jsp">Add</a></li>
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/DisplayAllDept">View</a></li>
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/DepartmentView.jsp">Edit</a></li>
            				</ul>          
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/Leave.jsp">Leave Request</a>
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/ChangePassword.jsp">Account Setting</a>
            				<ul class="sub-level">
                				<li><a href="http://127.0.0.1:8080/HRMSWAR/ChangePassword.jsp">Change Password</a></li>
            				</ul>
        				</li>
        				<li><a href="http://127.0.0.1:8080/HRMSWAR/AdminLogOut">Log Out</a>
        				</li>
    				</ul>
				</div>
			</section>
			<aside>
			<section class="login">
			<h2 align="center">Employee</h2>
				<table align="center" width="500px" >
	<tr>
		<th align="center">Id</th>
		<th align="center">Name</th>
		<th align="center">Department</th>
		<th align="center">Address</th>
		<th align="center">Mobile</th>
		<th align="center">Email</th>
		<th align="center">Password</th>
		
	</tr>
<%ArrayList<EmpBean> array=(ArrayList<EmpBean>)request.getAttribute("array");
for(EmpBean emp:array)
{%>

	<tr>
		<td><%=emp.getEmpid() %></td>
		<td><%=emp.getEmpname() %></td>
		<td><%=emp.getEmpdept() %></td>
		<td><%=emp.getAddress() %></td>
		<td><%=emp.getMobile() %></td>
		<td><%=emp.getEmail() %></td>
		<td><%=emp.getPassword() %></td>
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