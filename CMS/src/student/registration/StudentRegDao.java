package student.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.login.RegistrationDao;

public class StudentRegDao {

	public static int save(StdRegGetSet e) {
		 int status=0;  
	        try{  
	            Connection con=RegistrationDao.getConnection(); 
	            
	            PreparedStatement ps=con.prepareStatement(  
      "insert into stdregtable1(studentname,"
      + "dob,gender,branch,mobile,aadhar,email) "
        + "values (?,?,?,?,?,?,?)");  
        ps.setString(1,e.getStudentname());  
        ps.setString(2,e.getDob());  
        ps.setString(3,e.getGender());  
        ps.setString(4,e.getBranch());  
        ps.setString(5, e.getMobile());
        ps.setString(6, e.getAadhar());
        ps.setString(7, e.getEmail());
       
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return status;  
	}

}
