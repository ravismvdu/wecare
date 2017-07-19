

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PendingDelete
 */
@WebServlet("/PendingDelete")
public class PendingDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("eemail").toString();
		
		
		//Database property
		
     if(request.getParameter("first")!=null)
		
		{
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
				System.out.println("Database connected...");
				String q="delete from doctorinfo where email=?";
				PreparedStatement  pst=con.prepareStatement(q);
				pst.setString(1, id);
				pst.executeUpdate();
				
				con.close();
				System.out.println("Connection closed");
				RequestDispatcher rd=request.getRequestDispatcher("/PendingDoctorInfo.jsp");
				request.setAttribute("msg", "Successfully Deleted");
				rd.include(request, response);
			}
				
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

     else if(request.getParameter("second")!=null)
    	 
     {
    	 try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
				System.out.println("Database connected...");
				
				
				String q="insert into doctorinfo1 select * from doctorinfo where email=?";
				String p="delete from doctorinfo where  email=?";
				PreparedStatement  pst=con.prepareStatement(q);
				PreparedStatement  ps=con.prepareStatement(p);
				pst.setString(1, id);
				pst.executeUpdate();
				ps.setString(1, id);
				ps.executeUpdate();
				
				
				con.close();
				System.out.println("Connection closed");
				RequestDispatcher rd=request.getRequestDispatcher("/PendingDoctorInfo.jsp");
				request.setAttribute("msg", "Successfully Submitted");
				rd.include(request, response);
			}
				
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
     }
		// TODO Auto-generated method stub
		
	}
}
		
	

