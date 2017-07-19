
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><a href ="UserMenu.jsp">Chat With Doctor</a></h3>
<h3><a href ="Previouschat.jsp">view reply</a></h3>
<h3><a href ="HospitalList.jsp">Find Hospital</a></h3>
<h3><%=session.getAttribute("email") %>  <a href="userlogout">Logout</a></h3>
</body>
</html>