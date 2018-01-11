package worker.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.login.RegistrationDao;

public class WorkerRegDao {

	public static int save(WorkerRegGetSet e) {
		// TODO Auto-generated method stub
		 int status=0;  
	        try{  
	            Connection con=RegistrationDao.getConnection(); 
	            
	            PreparedStatement ps=con.prepareStatement(  
         "insert into wrkregtable1(workerpost,fname,"
         + "mname,lname,address,city,state,mobile,"
           + "aadhar,email,dob,gender) "
           + "values (?,?,?,?,?,?,?,?,?,?,?,?)");  
           ps.setString(1,e.getWorkerpost());  
           ps.setString(2,e.getFname());  
           ps.setString(3,e.getMname());  
           ps.setString(4,e.getLname());  
           ps.setString(5, e.getAddress());
           ps.setString(6, e.getCity());
           ps.setString(7, e.getState());
           ps.setString(8, e.getMobile());
           ps.setString(9, e.getAadhar());
           ps.setString(10, e.getEmail());
           ps.setString(11, e.getDob());
           ps.setString(12, e.getGender());
          
           status=ps.executeUpdate();  
             
           con.close();  
       }catch(Exception ex){ex.printStackTrace();}  
         
       return status;  
	}
	
	
}
