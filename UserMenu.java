

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






/**
 * Servlet implementation class UserMenu
 */
@WebServlet("/UserMenu")
public class UserMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
	
		response.setContentType("text/html");
		String abc=request.getParameter("specialization");
		HttpSession session=request.getSession(true);
		session.setAttribute("abc", abc);
		System.out.println(abc);
		out.println("<html>");
		out.println("<body>");
		out.println("<center><h3>Available Doctors:</h3></center>");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
			System.out.println("Database connected...");
			String q="select email from doctorinfo1 where specification=?";
			PreparedStatement  pst=con.prepareStatement(q);
			pst.setString(1, abc);
			pst.executeUpdate();
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			ArrayList<String> lst=new ArrayList<String>();
			lst.add(rs.getString(1));
			out.println("<br >" +rs.getString(1));
			System.out.println(lst);
			
			request.setAttribute("list", lst);
			session.setAttribute("list", lst);
			}
			String p="select email from doctorinfo1 where specification=?";
			PreparedStatement  ps=con.prepareStatement(p);
			ps.setString(1, abc);
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
		out.println("<form action=UserChat method=post>"+"Enter Doctor Name:"+"<input type =text name=abc>"+"Enter Msg"+"<input type=text name=msg>"+"<input type=submit name=submit></form>");
	
	}
}

