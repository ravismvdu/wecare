<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertHospitalDetail" method="post">
Enter Hospital Name:-<input type="text" name="hname">
<br>
Enter City Name:-<input type="text" name="cname">
<br>
Enter State Name:-<input type="text" name="sname">
<br>
Enter Type Of Hospital:-<input type="text" name="type">
<br>
Enter Rating:-<input type="text" name="rating">
<br>
<input type="Submit" value="Submit">
<h3><a href ="AdminWelcome.jsp">Cancel</a></h3>
</form>
<%if(request.getAttribute("msg")!=null)
	{
	%>
	<h2><%=request.getAttribute("msg")%></h2>
	<%
	}
	%>

</body>
</html>