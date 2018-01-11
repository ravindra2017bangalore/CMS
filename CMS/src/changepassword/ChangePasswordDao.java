package changepassword;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.login.RegistrationDao;

public class ChangePasswordDao {

	public static int update(ChangePasswordBean e, String email) {
		int status=0;  
		String email;
        try{  
            Connection con=RegistrationDao.getConnection(); 
            
            PreparedStatement ps=con.prepareStatement(  
     "update facregtable1 set pass=? where pass=?");  
       ps.setString(1,e.getNewpass());  
       ps.setString(2,e.getCurrentpass());  
       
       status=ps.executeUpdate();  
         System.out.println(status);
       con.close();  
   }catch(Exception ex){ex.printStackTrace();}  
     
   return status; 
	}
	
	
}
