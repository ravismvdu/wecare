<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form action="UserChat.jsp"method="post">
<center><h3>AVAILABLE DOCTORS ARE:-</h3></center>
		
		<% 
		String name=request.getParameter("specialization");
		HttpSession session1=request.getSession(true);
				request.setAttribute("abcde", name);
				session1.setAttribute("abcde", name);
				%>
				<%String a=(String)request.getAttribute("abcde");
				System.out.println(a);
				System.out.println(name);%>
		<% 
		try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
				System.out.println("Database connected...");
				String q="select email from doctorinfo1 where specification=?";
				PreparedStatement  pst=con.prepareStatement(q);
				pst.setString(1, name);
				pst.executeUpdate();
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
				ArrayList<String> lst=new ArrayList<String>();
				lst.add(rs.getString(1));
				out.println("<br >" +rs.getString(1));
				System.out.println(lst);
				HttpSession session2=request.getSession(true);
				request.setAttribute("list", lst);
				session.setAttribute("list", lst);
				}
				String p="select email from doctorinfo1 where specification=?";
				PreparedStatement  ps=con.prepareStatement(p);
				ps.setString(1, name);
				ps.executeUpdate();
				ResultSet rst=pst.executeQuery();
				
			       boolean val = rst.next();
				if(val==false)
				{
					
					RequestDispatcher rd=request.getRequestDispatcher("/UserMenu.jsp");
					request.setAttribute("msg", "please insert above mentioned specialization and doctor name !!");
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
		
<h3>Select Doctor email:-<input type="text" name="abc"></h3>
<h3>Enter Message:<input type="text" name="msg"></h3>
<h3><input type="Submit" value="send"></h3>

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