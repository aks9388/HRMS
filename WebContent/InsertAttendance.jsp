<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertAttendance" method="post">
<table align="center">

<TR>
<TD>EMPID</TD><TD> <INPUT TYPE="text" name="empid"/></TD>
</TR>

<TR><TD>
<INPUT TYPE = "SUBMIT" VALUE="timein"/>
</TD>
</form>
<td><form action="UpdateAttendance" method="post">
<TR>
<TD>EMPID</TD><TD> <INPUT TYPE="text" name="empid"/></TD>
</TR>

<TR><TD>
<INPUT TYPE = "SUBMIT" VALUE="timeout"/>
</TD></TR>
</form></td></TR>

</body>
</html>