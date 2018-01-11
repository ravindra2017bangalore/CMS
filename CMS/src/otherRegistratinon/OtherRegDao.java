package otherRegistratinon;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.login.RegistrationDao;

import worker.registration.WorkerRegGetSet;

public class OtherRegDao {
	
	public static int save(OtherGetSet e) {
		// TODO Auto-generated method stub
		 int status=0;  
	        try{  
	            Connection con=RegistrationDao.getConnection(); 
	            
	            PreparedStatement ps=con.prepareStatement(  
         "insert into othersignup(name,mobile,aadhar,email) "
           + "values (?,?,?,?)");  
           ps.setString(1,e.getFullName());  
           ps.setString(2,e.getMobile());  
           ps.setString(3,e.getAadhar());  
           ps.setString(4,e.getEmail());  
           
           status=ps.executeUpdate();  
             
           con.close();  
       }catch(Exception ex){ex.printStackTrace();}  
         
       return status;  
	}
	
	
}
