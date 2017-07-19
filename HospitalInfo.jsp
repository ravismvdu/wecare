<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >

<table border="1" >
<tr><td>Name</td><td>City</td><td>State</td><td>Type<td>Rating</td></tr>

<% String name=(String)request.getParameter("cityname"); out.print("welcome "+name); %>  
 <% 
try
{

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
	
	String q="Select * from hospitaldetail where city=? ";
	PreparedStatement  pst=con.prepareStatement(q);
	pst.setString(1,name);
	ResultSet rs=pst.executeQuery();
	
	
	while(rs.next())
	{
		%>
		
		<tr>
		<td><%=rs.getString("name") %></td>
		<td><%=rs.getString("city") %></td>
		<td><%=rs.getString("state") %></td>
		<td><%=rs.getString("type") %></td>
		<td><%=rs.getString("rating") %></td>
		
		
		
		</tr>
		
		<%
		
	}

	con.close();
}
catch(Exception e)
{
	e.printStackTrace();
	out.print("SQL Error "+"no hospital available");
}

%>

</table>

<%if(request.getAttribute("msg")!=null)
	{
	%>
	<h2><%=request.getAttribute("msg")%></h2>
	<%
	}
	%>
</form>
<h3><a href="Welcome.jsp">Cancil</a></h3>

</body>
</html>