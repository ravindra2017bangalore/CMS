package student.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StdRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String studentname,dob,gender,branch,mobile,aadhar,email;
		studentname=request.getParameter("studentname");
		dob= request.getParameter("dob");
		gender= request.getParameter("gender");
		branch = request.getParameter("branch");
		mobile= request.getParameter("mobile");
		aadhar= request.getParameter("aadhar");
		email = request.getParameter("email");
			
		StdRegGetSet sreg= new StdRegGetSet();
		sreg.setStudentname(studentname);
		sreg.setDob(dob);
		sreg.setGender(gender);
		sreg.setBranch(branch);
		sreg.setMobile(mobile);
		sreg.setAadhar(aadhar);
		sreg.setEmail(email);
		
		int status = StudentRegDao.save(sreg);
		
		if(status>0){  
            out.print("<h2 style='color:white;background-color:red'><p>Registration successfully!</p></h2>");  
            request.getRequestDispatcher("facultyprofile.html").include(request, response);  
        }else{  
            out.println("<h2 style='color:white;background-color:red'><p>Sorry! unable to save record</p></h2>");  
            request.getRequestDispatcher("facultyprofile.html").include(request, response);  
        }  
          
        out.close(); 
		
	}

}
