<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Enter User ID And Password</h1></center>
<center><form action ="UserLoginControl" method ="post">
<hr>

<table>
<tr><td>Enter Email</td><td><input type="text" name="email"></td></tr>

<tr><td>Enter password</td><td><input type ="password" name ="pass"></td></tr>
<tr><td></td><td><input type = "submit" value="Login"></td></tr>
</table>
<h3><a href ="UserSignup.jsp">Signup</a></h3>
</form></center>
<%if(request.getAttribute("msg")!=null)
	{
	%>
	<h2><%=request.getAttribute("msg")%></h2>
	<%
	}
	%>
</body>
</html>