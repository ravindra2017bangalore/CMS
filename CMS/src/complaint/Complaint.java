package complaint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forgetcode.SendMailSSL;
import otpClass.OTP;
import student.registration.StudentRegDao;

public class Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String complaintType=request.getParameter("complainType");
		String urgency=request.getParameter("urgency");
		String name= request.getParameter("name");
		String role = request.getParameter("role");
		String mobile = request.getParameter("mobileno");
		String aadhar = request.getParameter("aadhar");
		String email = request.getParameter("email");
		String branch = request.getParameter("branch");
		String description = request.getParameter("description");
		
		ComplainGetSet cgs = new ComplainGetSet();
		int complaintId=OTP.generateComplaintId();
		cgs.setComplaintId(complaintId);
		cgs.setComplaintType(complaintType);
		cgs.setUrgency(urgency);
		cgs.setName(name);
		cgs.setRole(role);
		cgs.setMobile(mobile);
		cgs.setAadhar(aadhar);
		cgs.setEmail(email);
		cgs.setBranch(branch);
		cgs.setDescription(description);
		
		int status = ComplaintDao.save(email, aadhar,role,cgs);
		
		if(status>0){  
			out.println("<h2 style='color:white;background-color:red;'>");
            out.print("<p>Complaint successfully!</p></h2>");  
            request.getRequestDispatcher("newcomplaintform.html").include(request, response); 
            SendMailSSL.msgComplaint(complaintId,complaintType,
            urgency,name,role,mobile,aadhar,email,branch,description);
            
        }else{ 
        	out.println("<h2 style='color:white;background-color:red;'>");
            out.println("<marquee><p>Try Again !my be Some Problem and plz insert correct information... </p></marquee></h2>");  
            request.getRequestDispatcher("newcomplaintform.html").include(request, response);  
        }  
          
			out.close();
		
	}
		
		}

