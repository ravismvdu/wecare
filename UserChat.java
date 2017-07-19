

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserChat
 */
@WebServlet("/UserChat")
public class UserChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserChat() {
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
        
        
        String b=request.getParameter("abc");
        String c = request.getParameter("msg");
        HttpSession session = request.getSession();
        String var = (String) session.getAttribute("email");
        String var1 = (String) session.getAttribute("specialization");
		/*String[] list=request.getParameterValues("lst");*/
        
       
       System.out.println(b);
       System.out.println(c);
       System.out.println(var1);
       try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
			System.out.println("Database connected...");
			String p="select email from doctorinfo1";
			PreparedStatement  ps=con.prepareStatement(p);
			
			ps.executeUpdate();
			ResultSet rst=ps.executeQuery();
			
		      
			if(rst.next())
			{
				 try{
			        	
				       
				        
			          
				        PreparedStatement pst=con.prepareStatement("insert into userchat values(?,?,?)");

				        pst.setString(1, var);
				        pst.setString(2, c);
				        pst.setString(3, b);
				       
				         pst.executeUpdate();  
				        
				        out.println("successfully");
				       out.println("<a href=Welcome.jsp>cancil</a>");
				       return;
				        }
				        catch(Exception i)
				        {
				            i.printStackTrace();
				           
				        }
				
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("/UserMenu.jsp");
				request.setAttribute("msg", "please insert above mentioned specialization and doctor name !!");
				rd.forward(request, response);
      
			}
		}	
			catch(Exception i)
	        {
	            i.printStackTrace();
	           
	        }
	}
}
	
	


