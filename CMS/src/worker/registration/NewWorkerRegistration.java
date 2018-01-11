package worker.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.RegistrationDao;

import forgetcode.SendMailSSL;

/**
 * Servlet implementation class NewWorkerRegistration
 */
public class NewWorkerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewWorkerRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		String workerpost=request.getParameter("workerpost");
		String fname = request.getParameter("fname");
		String mname= request.getParameter("mname");
		String lname= request.getParameter("lname");
		String address= request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String mobile = request.getParameter("mobile");
		String aadhar = request.getParameter("aadhar");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		
		WorkerRegGetSet wreg= new WorkerRegGetSet();
		wreg.setWorkerpost(workerpost);
		wreg.setFname(fname);
		wreg.setMname(mname);
		wreg.setLname(lname);
		wreg.setAddress(address);
		wreg.setCity(city);
		wreg.setState(state);
		wreg.setMobile(mobile);
		wreg.setAadhar(aadhar);
		wreg.setEmail(email);
		wreg.setDob(dob);
		wreg.setGender(gender);
		int status=WorkerRegDao.save(wreg);
		if(status>0){  
			out.println("<h2 style='color:white;background-color:red;'>");
            out.print("<p>Registration successfully!</p></h2>");  
            request.getRequestDispatcher("adminhome.html").include(request, response); 
            SendMailSSL.msgWrkrRegister(email,fname);
            
        }else{ 
        	out.println("<h2 style='color:white;background-color:red;'>");
            out.println("<p>Sorry! unable to save record</p></h2>");  
            request.getRequestDispatcher("adminhome.html").include(request, response);  
        }  
          
			out.close();
		
	}

}
