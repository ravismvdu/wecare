<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DoctorChat" method="post">

<table border="1" >

<tr><td>DoctorEmail</td><td>Messages</td></tr>

 <% HttpSession session1= request.getSession();
 String id = (String) session.getAttribute("email"); %>
 <% 
try
{

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
	
	String q="Select doctormailid,msg from doctorchat where usermailid=?";
	PreparedStatement  pst=con.prepareStatement(q);
	pst.setString(1,id);
	ResultSet rs=pst.executeQuery();
	
	
	while(rs.next())
	{
		%>
		
		<tr>
		<td><%=rs.getString("doctormailid") %></td>
		<td><%=rs.getString("msg") %></td>
		
		
		
		
		
		</tr>
		
		<%
		
	}

	con.close();
}
catch(Exception e)
{
	e.printStackTrace();
	out.print("SQL Error ");
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
	<a href="Welcome.jsp">Want To Chat More</a>
</form>


</body>
</html>