package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		 if(LoginDao.validate(username, password)){  
			 HttpSession session=request.getSession();
			 session.setAttribute("id", username);
			 session.setMaxInactiveInterval(10);
		        request.getRequestDispatcher("adminhome.html").forward(request, response); 
		          
		    }  
		else {
				if(FacultyDao.validate(username, password))
				{
					HttpSession session=request.getSession();
					 session.setAttribute("id", username);
					 session.setMaxInactiveInterval(10);
				        request.getRequestDispatcher("facultyprofile.html").forward(request, response); 
				}
				else{
			 out.println("<center><h1>");
			 out.println("Please Enter correct username and password..");
			 out.println("</h1></center>");
			
			 request.getRequestDispatcher("admin.html").include(request, response);
				}
		 }		
		    out.close();  
		    }  
		
		
	}

