<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h1>REGISTERED USERS LIST</h1>
<form >

<table border="1" >
<tr><td>Name</td><td>Email</td><td>Password</td><td>Mobile<td>Address</td></tr>

<%
try
{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
	
	String q="Select * from userinfo ";
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
		<td><%=rs.getString("address") %></td>
		
		
		
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
<a href="AdminWelcome.jsp">cancel</a>
</form>
</body>
</html>