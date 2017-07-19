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
	<form action="UserChat"method="post">
<% 
		String name=request.getParameter("abc");
		System.out.println(name);
		%>
<% 			
try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
				System.out.println("Database connected...");
				String q="select email from doctorinfo1 where email=?" ;
				PreparedStatement  pst=con.prepareStatement(q);
				pst.setString(1,name);
				pst.executeUpdate();
				ResultSet rs=pst.executeQuery();
				 
				 while(rs.next())
					{
					
					out.println("<br >" +rs.getString(1));
					
					}
					String p="select email from doctorinfo1 where email=?";
					PreparedStatement  ps=con.prepareStatement(p);
					ps.setString(1, name);
					ps.executeUpdate();
					ResultSet rst=pst.executeQuery();
					
				       boolean val1 = rst.next();
					if(val1==false)
					{
						RequestDispatcher rd=request.getRequestDispatcher("/UserMenu1.jsp");
						request.setAttribute("msg", "please insert above mentioned specializationS !!");
						rd.forward(request, response);
						
					}
					
					
				
				
               
				con.close();
				System.out.println("Connection closed");
				
			}
				
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		%>
	<h3><input type="hidden" name="abcd"></h3>

<h3><input type="Submit" value="SUBMIT"></h3>	

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