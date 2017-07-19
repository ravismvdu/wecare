

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
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
		response.setContentType("text/html");
        
        String name1="Admin";
        String Pass1="nopassword";
        String name=request.getParameter("id");
        String pass=request.getParameter("pass");
        if(name.equals(name1)&&pass.equals(Pass1))
        {
        	
			HttpSession session=request.getSession(true);
			session.setAttribute("id", name1);
			
        	RequestDispatcher rd=request.getRequestDispatcher("/AdminWelcome.jsp");
			
			rd.forward(request, response);
        }
        else
        {
        	RequestDispatcher rd=request.getRequestDispatcher("/Admin.jsp");
			request.setAttribute("msg", "Enter correct ID or Password");
			rd.include(request, response);
        }
        	
	}

}
