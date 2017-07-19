

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
 * Servlet implementation class WelcomeDoctor
 */
@WebServlet("/WelcomeDoctor")
public class WelcomeDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeDoctor() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		HttpSession session = request.getSession();
        String var = (String) session.getAttribute("demail");
        System.out.println(var);
        
        try{
         	
        
         Class.forName("oracle.jdbc.driver.OracleDriver");

 	
           Connection  con=DriverManager.getConnection
                      ("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
           
         PreparedStatement ps=con.prepareStatement("select * from doctorinfo1 where email=?");

         ps.setString(1, var);
         
        
          ps.executeUpdate(); 
          ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("varivied");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				out.println("<br />");
				out.println("<h3/>"+"<center>"+"<a href=verifieddoctorwelcome.jsp>"+"continue"+"</a>"+"</center>");
			}
			else
			{
				out.println("Sorry Wait Till Verification By Admin");
				out.println("<h3/>"+"<center>"+"<a href=DactorSignin.jsp>"+"cancil"+"</a>"+"</center>");
			}
			
			
         
       
        
        return;
         }
         catch(Exception i)
         {
             i.printStackTrace();
            
         }
       
 	
 	
 	}
 	
	}


