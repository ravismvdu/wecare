

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class UserSignupControl
 */
@WebServlet("/UserSignupControl")
public class UserSignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignupControl() {
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
	
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String mobile = request.getParameter("mobile");
        String add = request.getParameter("add");
       
        try{
        	
       
        Class.forName("oracle.jdbc.driver.OracleDriver");

	
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
          
        PreparedStatement ps=con.prepareStatement("insert into userinfo values(?,?,?,?,?)");

        ps.setString(1, email);
        ps.setString(2, name);
        ps.setString(3,pass );
        ps.setString(4, mobile);
        ps.setString(5, add);
        
        
        int i =  ps.executeUpdate();  
        if(i>0)
        	 out.print("You have successfully registered...");  
        RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");
        request.setAttribute("msg", "registered successfully!!Signin Please");
		rd.include(request, response);
       
       return;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            RequestDispatcher rd=request.getRequestDispatcher("/UserSignup.jsp");
            request.setAttribute("msg", "Already Registered <a href='forget.jsp'>Forget Password</a>");
			rd.forward(request, response);
        }
        RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");
        request.setAttribute("msg", "registered successfully!!Signin Please");
		rd.forward(request, response);
	out.close();
		
	}
}


