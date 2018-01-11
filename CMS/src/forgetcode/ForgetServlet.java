package forgetcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgetServlet
 */
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    
    	HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();response.setContentType("text/html");
		String email1= request.getParameter("forget_email");
		if(ForgetAdminDao.validate(email1))
		{
			SendMailSSL sms= new SendMailSSL();
			int vc=sms.call(email1);
			session.setAttribute("vcode", vc);
			session.setAttribute("id", email1);
			response.sendRedirect("OTPServlet");
		}
		else{
			
			if(ForgetFacultyDao.validate(email1)){
				SendMailSSL sms= new SendMailSSL();
				int vc=sms.call(email1);
				session.setAttribute("vcode", vc);
				session.setAttribute("id", email1);
				response.sendRedirect("OTPServlet");
			}
			else{
				out.println("<p style='color:white;background-color:red;'>Please Enter Correct Email Address...</p>");
			}
		}
			
    }

}
