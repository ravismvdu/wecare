

import java.io.IOException;
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
 * Servlet implementation class DoctorSigninControl
 */
@WebServlet("/DoctorSigninControl")
public class DoctorSigninControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorSigninControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		//Database Coding
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
			System.out.println("Database connected...");
			String q="select  name from doctorinfo2 where email=? and password=?";
			PreparedStatement  pst=con.prepareStatement(q);
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				String name=rs.getString("name");
				HttpSession session=request.getSession(true);
				session.setAttribute("id", name);
				session.setAttribute("demail", email);
				
				response.sendRedirect("Welcomedoc.jsp");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/DactorSignin.jsp");
				request.setAttribute("msg", "Enter correct ID or Password");
				rd.forward(request, response);
			}
			con.close();
			
	}
catch(Exception e)
		{
	e.printStackTrace();
			}
	}
	}


