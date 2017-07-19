<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="PendingDelete" method="get">

<table border="1" >
<tr><td>Name</td><td>Email</td><td>Password</td><td>Mobile<td>Specialization</td><td>Experience</td><td>Qualification</td><td>Workplace</td></tr>

<%
try
{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
	
	String q="Select * from doctorinfo ";
	PreparedStatement  pst=con.prepareStatement(q);
	ResultSet rs=pst.executeQuery();
	
	
	while(rs.next())
	{
		%>
		
		<tr>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("email") %></td>
		<td><%=rs.getString("password") %></td>
		<td><%=rs.getString("mobile") %></td>
		<td><%=rs.getString("specialization") %></td>
		<td><%=rs.getString("experiance") %></td>
		<td><%=rs.getString("qualification") %></td>
		<td><%=rs.getString("workplace") %></td>
		
		
		</tr>
		
		<%
		
	}

	con.close();
}
catch(Exception e)
{
	e.printStackTrace();
	out.print("SQL Error "+e.getMessage());
}

%>
</table>
 Enter Email: <input type="text" name="eemail" size="20">
    <br><br>
    <input type="submit" name="first" value="Delete">
    <input type="submit" name="second" value="Submit">

</form>
<h3><a href ="ConfirmedDoctor.jsp">Confirmed Doctors Till Now</a></h3>
<a href="AdminWelcome.jsp">cancel</a>
</body>
</html>