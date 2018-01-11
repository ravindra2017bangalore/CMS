package passwordUPDATE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   boolean status=false;
    public PasswordUpdate() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String password = request.getParameter("new_password");
		String cPassword= request.getParameter("confirm_password");
		if(password.equals(cPassword)){
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("id1");
		//System.out.println(id);
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cms","root","root"); 
			System.out.println("1");
			PreparedStatement ps=con.prepareStatement("SELECT email from admintab where email=?");  
			System.out.println("2");
			ps.setString(1, id);
			System.out.println("3");
			ResultSet rs =ps.executeQuery();
			status=rs.next();
			System.out.println("4");
			//String check=;
			System.out.println(status);
			System.out.println("5");
			if(status){
				System.out.println("6");
			PreparedStatement ps1=con.prepareStatement(  
			"UPDATE admintab SET pwd = ?  WHERE email = ?");  
			ps1.setString(1,cPassword);  
			ps1.setString(2,id);  
			      int i=ps1.executeUpdate();
			      System.out.println(i+"for admin");
			      out.println("<center><h1>");
					 out.println("Your password Successfuly Changed...");
					 out.println("</h1></center>");
					 request.getRequestDispatcher("admin.html").include(request, response);
			   }
			else{
				PreparedStatement ps2=con.prepareStatement(  
			"UPDATE facregtable1 SET pass = ?  WHERE email = ?");  
			ps2.setString(1,cPassword);  
			ps2.setString(2,id);  
		    int i=ps2.executeUpdate();
            System.out.println(i+"for faculty");
	        out.println("<center><h1>");
			out.println("Your password Successfuly Changed...");
			out.println("</h1></center>");
			request.getRequestDispatcher("admin.html").include(request, response);

			}
			}
			catch(Exception e)
			{
				System.out.println(e);
				}  
		}
		  else{out.println("Please Enter Correct Confirm Password... ");}
		
	}
	
}
