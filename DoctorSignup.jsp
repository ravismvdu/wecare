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
<center><form action="DoctorSignup" method ="post">
<hr>
<table>
<tr><td>Enter Name</td><td><input type="text" name="name"></td></tr>


<tr><td>Enter Email</td><td><input type="text" name="email"></td></tr>
<tr><td>Enter Password</td><td><input type="password" name="pass"></td></tr>
<tr><td>Enter Mobile</td><td><input type="text" name="mobile"></td></tr>
<tr><td>Enter Specification</td><td><input type="text" name="spe"></td></tr>
<tr><td>Enter Experience</td><td><input type="text" name="exp"></td></tr>
<tr><td>Enter Qualification</td><td><input type="text" name="qual"></td></tr>
<tr><td>Enter Work Place</td><td><input type="text" name="work"></td></tr>
<tr><td><input type = "submit" value="submit"></td></tr>




</table>
<h3><a href ="DactorSignin.jsp">Cancil</a></h3>
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