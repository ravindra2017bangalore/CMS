package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public static boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		boolean status=false;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cms","root","root"); 
			PreparedStatement ps=con.prepareStatement(  
			"select * from admintab where email=? and pwd=?");  
			ps.setString(1,username);  
			ps.setString(2,password);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			          
			}
			catch(Exception e)
			{
				System.out.println(e);
				}  
		System.out.println(status);
					return status;  
					
			}  
			
	}


