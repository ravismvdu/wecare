<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENTER USER INFORMATION
</h1>
<center><form action="UserSignupControl" method ="post">
<hr>
<table>
<tr><td>Enter Email</td><td><input type="text" name="email"></td></tr>


<tr><td>Enter Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Enter Password</td><td><input type="password" name="pass"></td></tr>
<tr><td>Enter Mobile</td><td><input type="text" name="mobile"></td></tr>
<tr><td>Enter Address</td><td><input type="text" name="add"></td></tr>

<tr><td><input type = "submit" value="submit"></td></tr>




</table>
<h3><a href ="User.jsp">Cancil</a></h3>
</form></center>
<center><%if(request.getAttribute("msg")!=null)
	{
	%>
	<h2><%=request.getAttribute("msg")%></h2>
	<%
	}
	%></center>
</body>

</body>
</html>