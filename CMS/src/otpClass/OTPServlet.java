package otpClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OTPServlet
 */
public class OTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public OTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession hSession = request.getSession();
		String id =(String) hSession.getAttribute("id");
		hSession.setAttribute("id1", id);
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
		out.println("<div class='container'>");
		out.println("<form action='otpverifactionservlet' method='post' class='form-inline'>");
		out.println("<div class='input-group' style='margin-top: 60px'>");
		out.println("<p style='color:red;'>Enter OTP Here...</p>");
		out.println("<input type='text' name='otp' class='form-control' placeholder='Enter OTP Here' required/>");
		out.println("<div class='input-group-btn'>");
		out.println("<input type='submit' value='SUBMIT' class='btn btn-danger'/></div>");
		out.println("</form>");
		out.close();
	}
	

}
