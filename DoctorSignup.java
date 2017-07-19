

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorSignup
 */
@WebServlet("/DoctorSignup")
public class DoctorSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorSignup() {
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
	
        String a = request.getParameter("name");
        String b = request.getParameter("email");
        String c = request.getParameter("pass");
        String d = request.getParameter("mobile");
        String e = request.getParameter("spe");
        String f = request.getParameter("exp");
        String g = request.getParameter("qual");
        String h = request.getParameter("work");
       System.out.println(a);
        try{
        	
       
        Class.forName("oracle.jdbc.driver.OracleDriver");

	
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
          
        PreparedStatement ps=con.prepareStatement("insert into doctorinfo values(?,?,?,?,?,?,?,?)");
        
        

        ps.setString(1, a);
        ps.setString(2, b);
        ps.setString(3, c );
        ps.setString(4, d);
        ps.setString(5, e);
        ps.setString(6, f);
        ps.setString(7, g);
        ps.setString(8, h);
        PreparedStatement pst=con.prepareStatement("insert into doctorinfo2 values(?,?,?,?,?,?,?,?)");
        pst.setString(1, a);
        pst.setString(2, b);
        pst.setString(3, c );
        pst.setString(4, d);
        pst.setString(5, e);
        pst.setString(6, f);
        pst.setString(7, g);
        pst.setString(8, h);
        HttpSession session=request.getSession(true);
		session.setAttribute("dname", a);
		session.setAttribute("demail", b);
		session.setAttribute("dpass", c);
		session.setAttribute("dmobile", d);
		session.setAttribute("dspe", e);
		session.setAttribute("dexp", f);
		session.setAttribute("dqual", g);
		session.setAttribute("dwork", h);
        
        int i =  ps.executeUpdate();
       pst.executeUpdate();
        if(i>0)
        	 out.print("You have successfully registered...");  
        RequestDispatcher rd=request.getRequestDispatcher("/DactorSignin.jsp");
        request.setAttribute("msg", "registered successfully!!Signin Please");
		rd.include(request, response);
		 con.close();
       return;
      
        }
        catch(Exception i)
        {
            i.printStackTrace();
            RequestDispatcher rd=request.getRequestDispatcher("/DoctorSignup.jsp");
            request.setAttribute("msg", "Already Registered <a href='forget.jsp'>Forget Password</a>");
			rd.forward(request, response);
        }
       
       try{
        	
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

    	
              Connection  con=DriverManager.getConnection
                         ("jdbc:oracle:thin:@localhost:1521:XE ","RAVI_RAJ","1234");
              
              PreparedStatement ps=con.prepareStatement("insert into doctorinfo2 values(?,?,?,?,?,?,?,?)");
            

            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c );
            ps.setString(4, d);
            ps.setString(5, e);
            ps.setString(6, f);
            ps.setString(7, g);
            ps.setString(8, h);
            HttpSession session=request.getSession(true);
    		session.setAttribute("dname", a);
    		session.setAttribute("demail", b);
    		session.setAttribute("dpass", c);
    		session.setAttribute("dmobile", d);
    		session.setAttribute("dspe", e);
    		session.setAttribute("dexp", f);
    		session.setAttribute("dqual", g);
    		session.setAttribute("dwork", h);
            
            int i =  ps.executeUpdate();  
            if(i>0)
            	 out.print("You have successfully registered...");  
            RequestDispatcher rd=request.getRequestDispatcher("/DactorSignin.jsp");
            request.setAttribute("msg", "registered successfully!!Signin Please");
    		rd.include(request, response);
           
           return;
            }
            catch(Exception i)
            {
                i.printStackTrace();
                RequestDispatcher rd=request.getRequestDispatcher("/DoctorSignup.jsp");
                request.setAttribute("msg", "Already Registered <a href='forget.jsp'>Forget Password</a>");
    			rd.forward(request, response);
            }
        RequestDispatcher rd=request.getRequestDispatcher("/DactorSignin.jsp");
        request.setAttribute("msg", "registered successfully!!Signin Please");
		rd.forward(request, response);
	out.close();
	}

}
