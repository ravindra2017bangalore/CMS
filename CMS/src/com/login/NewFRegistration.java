package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forgetcode.SendMailSSL;


public class NewFRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	int  status;
    public NewFRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		String designation= request.getParameter("designation");
		String fname= request.getParameter("fname");
		String mname= request.getParameter("mname");
		String lname= request.getParameter("lname");
		String dob = request.getParameter("dob");
		String gender =request.getParameter("gender");
		String address= request.getParameter("address");
		String city=request.getParameter("city");
		String state= request.getParameter("state");
		String email=request.getParameter("email");
		String mobile= request.getParameter("mobile");
		String pass = request.getParameter("pass");
		String repwd = request.getParameter("repass");
		String qualification= request.getParameter("qualification");
		String aadhar = request.getParameter("aadhar");
		String branch = request.getParameter("branch");
		if(pass.equals(repwd)){
		RegGetSet reg = new RegGetSet();
		reg.setDesignation(designation);
		reg.setFname(fname);
		reg.setMname(mname);
		reg.setLname(lname);
		reg.setDob(dob);
		reg.setGender(gender);
		reg.setAddress(address);
		reg.setCity(city);
		reg.setState(state);
		reg.setEmail(email);
		reg.setMobile(mobile);
		reg.setPass(pass);
		reg.setQualification(qualification);
		reg.setAadhar(aadhar);
		reg.setBranch(branch);
		
		  status=RegistrationDao.save(reg);
		}
		 if(status>0){  
	            out.print("<h2 style='color:white;background-color:red;'><p>Registration successfully!</p></h2>");  
	            request.getRequestDispatcher("adminhome.html").include(request, response);  
	            SendMailSSL.msgFacRegistration( email,fname,pass);
	        }else{  
	            out.println("<h2 style='color:white;background-color:red;'><p>Sorry! unable to save record</p></h2>");  
	            request.getRequestDispatcher("adminhome.html").include(request, response);  
	        }  
	          
	        out.close();  
	    } 
	}

