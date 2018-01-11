package forgetcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgetAdminDao {
	
	public static boolean validate(String email) {
		// TODO Auto-generated method stub
		String email1 =email;
		
		boolean status=false;
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 

			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cms","root","root"); 

			PreparedStatement st=con.prepareStatement("select * from admintab where uname=?");
			st.setString(1, email1);
			ResultSet rs=st.executeQuery();
			
			status=rs.next();
			
			}
		
			catch(Exception e){
				
				e.printStackTrace();
				}  
				return status;  
			}  
}
