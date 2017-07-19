

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorChat
 */
@WebServlet("/DoctorChat")
public class DoctorChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorChat() {
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
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        String b=request.getParameter("umail");
        String c = request.getParameter("msg");
        HttpSession session = request.getSession();
        String var = (String) session.getAttribute("demail");
        
        HttpSession session1= request.getSession(true);
        String id = (String) session1.getAttribute("demail");
       
       System.out.println(id);
       
       
       try{
        	
       
        Class.forName("oracle.jdbc.driver.OracleDriver");

	
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
          PreparedStatement pst=con.prepareStatement("select * from userchat");
          pst.executeUpdate();
			ResultSet rst=pst.executeQuery();
			
		       boolean val1 = rst.next();
			if(val1==true)
			{
          
        PreparedStatement ps=con.prepareStatement("insert into doctorchat values(?,?,?)");

        ps.setString(1, var);
        ps.setString(2, c);
        ps.setString(3, b);
       ps.executeQuery();
       
       
        out.println("successfully send messages");
       out.println("<a href=verifieddoctorwelcome.jsp>cancil</a>");
       return;
        }
       }
        catch(Exception i)
        {
            i.printStackTrace();
           
        }
        
	out.close();
	
	}
	



	}


