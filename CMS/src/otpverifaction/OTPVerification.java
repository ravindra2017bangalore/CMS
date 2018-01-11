package otpverifaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OTPVerification
 */
public class OTPVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPVerification() {
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
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int code=(int)session.getAttribute("vcode");
		String id=(String) session.getAttribute("id1");
		session.setAttribute("id1", id);
		System.out.println(code);
		//int code1=Integer.parseInt(code);
		int otp = Integer.parseInt(request.getParameter("otp"));
		if(code==otp){
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>");
			out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
			out.println("<div class='container'>");
			out.println("<h1> Change password form</h1>");
			out.println("<form action='password_update' method='post' class='form-horizontal'>");
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2'>New Password :</label>");
			out.println("<div class='col-sm-6'>");
			out.println("<input type='password' name='new_password' class='form-control' />");
			out.println("</div></div>");
			out.println("<div class='form-group'>");
			out.println("<label class='control-label col-sm-2'>Confirm Password :</label>");
			out.println("<div class='col-sm-6'>");
			out.println("<input type='password' name='confirm_password' class='form-control'/>");
			out.println("</div></div>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-sm-offset-2 col-sm-10'>");
			out.println("<button type='submit' class='btn btn-default'>SUBMIT</button>");
			out.println("</form>");
			out.println("</div>");
			out.close();	
		}
	}

}
