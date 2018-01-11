package changepassword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession httpSession = request.getSession();
		String email=(String)httpSession.getAttribute("id");
		httpSession.setAttribute("email1", email);
		String currentpass= request.getParameter("current_password");
		String newpass= request.getParameter("new_password");
		String confirmpass= request.getParameter("confirm_password");
			
		ChangePasswordBean cpb = new ChangePasswordBean();
		cpb.setCurrentpass(currentpass);
		cpb.setNewpass(newpass);
		cpb.setConfirmpass(confirmpass);
		 
		if(newpass.equals(confirmpass)){
			int status = ChangePasswordDao.update(cpb,email);
			if(status>0){  
	            out.print("<p style='color:white;background-color:red;'>Your Password successfully changed!</p>");  
	            request.getRequestDispatcher("facultyprofile.html").include(request, response);  
	        }else{  
	            out.println("<P style='color:white;background-color:red;'> Sorry! Check Fields...</p>");  
	            request.getRequestDispatcher("facultyprofile.html").include(request, response);  
	        }  
	          
				out.close();
			

		}
	}

}
