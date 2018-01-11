package otherRegistratinon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forgetcode.SendMailSSL;
import worker.registration.WorkerRegDao;

/**
 * Servlet implementation class OtherRegistration
 */
public class OtherRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fullName = request.getParameter("fullname");
		String mobile = request.getParameter("mobile");
		String aadhar = request.getParameter("aadhar");
		String email = request.getParameter("email");
		
		OtherGetSet ogs= new OtherGetSet();
		ogs.setFullName(fullName);
		ogs.setMobile(mobile);
		ogs.setAadhar(aadhar);
		ogs.setEmail(email);
		
		int status=OtherRegDao.save(ogs);
		if(status>0){  
			out.println("<h2 style='color:white;background-color:red;'>");
            out.print("<p>Registration successfully!</p></h2>");  
            request.getRequestDispatcher("newcomplaintform.html").include(request, response); 
            SendMailSSL.msgOtherrRegister(email,fullName);
            
        }else{ 
        	out.println("<h2 style='color:white;background-color:red;'>");
            out.println("<p>Sorry! unable to save record</p></h2>");  
            request.getRequestDispatcher("admin.html").include(request, response);  
        }  
          
			out.close();
		
	}

}
