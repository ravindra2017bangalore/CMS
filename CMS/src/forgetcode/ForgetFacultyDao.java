package forgetcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgetFacultyDao {

	public static boolean validate(String email1) {
String email2 =email1;
		
		boolean status=false;
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 

			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cms","root","root"); 

			PreparedStatement st=con.prepareStatement("select * from facregtable1 where email=?");
			st.setString(1, email2);
			ResultSet rs=st.executeQuery();
			
			status=rs.next();
			
			}
		
			catch(Exception e){
				
				e.printStackTrace();
				}  
				return status;  
			} 
	}


