package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDao {
	
	public static Connection getConnection(){
		Connection con=null;  
		try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
		
	
	public static int save(RegGetSet e){  
        int status=0;  
        try{  
            Connection con=RegistrationDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into facregtable1(designation,fname,mname,lname,dob,gender,"
                         + "address,city,state,email,"
                         + "mobile,pass,qualification,aadhar,branch) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getDesignation());  
            ps.setString(2,e.getFname());  
            ps.setString(3,e.getMname());  
            ps.setString(4,e.getLname());  
            ps.setString(5, e.getDob());
            ps.setString(6, e.getGender());
            ps.setString(7, e.getAddress());
            ps.setString(8, e.getCity());
            ps.setString(9, e.getState());
            ps.setString(10, e.getEmail());
            ps.setString(11, e.getMobile());
            ps.setString(12, e.getPass());
            ps.setString(13, e.getQualification());
            ps.setString(14, e.getAadhar());
            ps.setString(15, e.getBranch());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
	
}
