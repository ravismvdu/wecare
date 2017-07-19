<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserMenu"method="post">
<center><h3>AVAILABLE Specialization ARE:-</h3></center>
<% 		
		
try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
				System.out.println("Database connected...");
				String q="select specification from doctorinfo1" ;
				PreparedStatement  pst=con.prepareStatement(q);
				
				pst.executeUpdate();
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
				
				out.println("<br >" +rs.getString(1));
				
				
				}
				
				
               
				con.close();
				System.out.println("Connection closed");
				
			}
				
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		%>
		
<h3>Select Specialization Name:-<input type="text" name="specialization"></h3>

<h3><input type="Submit" value="SUBMIT"></h3>
<%
%>
</form>
<% if(request.getAttribute("msg")!=null)
	{
	%>
	
	<h2 style="color: red;"><%=request.getAttribute("msg") %></h2>
	<%
	}
	%>
</body>
</html>