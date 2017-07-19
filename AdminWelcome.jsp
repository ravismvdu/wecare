<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h3><a href ="UserInfo.jsp">User Information</a></h3></center>
<center><h3><a href ="DoctorInfo.jsp">Registered Doctors</a></h3></center>
<center><h3><a href ="PendingDoctorInfo.jsp">Pending Doctors</a></h3></center>
<center><h3><a href ="InsertHospitalDetail.jsp">Insert Hospital Detail</a></h3></center>

<h3><%=session.getAttribute("id") %>  <a href="adminlogout">Logout</a></h3>
</body>
</html>