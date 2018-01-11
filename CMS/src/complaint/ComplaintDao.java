package complaint;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.login.RegistrationDao;

public class ComplaintDao {

		public static ComplainGetSet getFullCompaintById(int id)
		{
			
			boolean status1=false;
			ComplainGetSet cgs=null;
				System.out.println("in getByid "+id);
			
			try{
				Connection con=RegistrationDao.getConnection(); 
				Statement ps=con.createStatement();
				ResultSet rs=ps.executeQuery("select * from stdcomplaint where complaintid="+id);  
		         status1=rs.next();
		        if(status1)
		        {
		        	System.out.println(status1);
		        	while(rs.next())
		        	{
		        		System.out.println(rs.getInt("complaintid"));
		        	cgs=new ComplainGetSet();
		        		 cgs.setComplaintId(rs.getInt("complaintid"));
		        		 System.out.println("Get"+cgs.getComplaintType());
		        		 cgs.setComplaintType(rs.getString("typecomplaint"));
		        		 cgs.setUrgency(rs.getString("urgency"));
		        		 cgs.setName(rs.getString("name"));
		        		 cgs.setRole(rs.getString("role"));
		        		 cgs.setMobile(rs.getString("mobile"));
		        		 cgs.setAadhar(rs.getString("aadhar"));
		        		 cgs.setEmail(rs.getString("email"));
		        		 cgs.setBranch(rs.getString("branch"));
		        		 cgs.setDescription(rs.getString("description"));
		        	}
		        	
		        }
		        else{
		        	boolean status2=false;
		        	Statement ps1=con.createStatement();
					String q1="select * from faccomplaint where complaintid ="+id;
					
					ResultSet rs1=ps1.executeQuery(q1);  
			        status2=rs1.next();

		        	if(status2){
		        		while(rs.next())
			        	{
		        				System.out.println(rs.getInt("complaintid"));
			        		 cgs=new ComplainGetSet();
			        		 cgs.setComplaintId(rs.getInt("complaintid"));
			        		 cgs.setComplaintType(rs.getString("typecomplaint"));
			        		 cgs.setUrgency(rs.getString("urgency"));
			        		 cgs.setName(rs.getString("name"));
			        		 cgs.setRole(rs.getString("role"));
			        		 cgs.setMobile(rs.getString("mobile"));
			        		 cgs.setAadhar(rs.getString("aadhar"));
			        		 cgs.setEmail(rs.getString("email"));
			        		 cgs.setBranch(rs.getString("branch"));
			        		 cgs.setDescription(rs.getString("description"));
			        	}
		        		return cgs;
		        	}
		        	else{
		        		boolean status3=false;
		        		Statement ps2=con.createStatement();
		    			String q="select * from othcomplaint where complaintid ="+id;
		   				ResultSet rs2=ps2.executeQuery(q);  
	 			        status3=rs2.next();
	 			        if(status3){
	 			        	while(rs.next())
				        	{	System.out.println(rs.getInt("complaintid"));
				        		 cgs=new ComplainGetSet();
				        		 cgs.setComplaintId(rs.getInt("complaintid"));
				        		 cgs.setComplaintType(rs.getString("typecomplaint"));
				        		 cgs.setUrgency(rs.getString("urgency"));
				        		 cgs.setName(rs.getString("name"));
				        		 cgs.setRole(rs.getString("role"));
				        		 cgs.setMobile(rs.getString("mobile"));
				        		 cgs.setAadhar(rs.getString("aadhar"));
				        		 cgs.setEmail(rs.getString("email"));
				        		 //cgs.setBranch(rs.getString("branch"));
				        		 cgs.setDescription(rs.getString("description"));
				        	}
	 			        }

		        	}
		        }
				
			}catch(Exception e){System.out.println(e);}  
		    
			return cgs;
			 
		}
	public static List<ComplainGetSet> getAllRecordsforOth(){  
	    List<ComplainGetSet> list=new ArrayList<ComplainGetSet>();  
	      
	    try{  
	        Connection con=RegistrationDao.getConnection(); 
	        PreparedStatement ps=con.prepareStatement("select * from othcomplaint");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            ComplainGetSet u=new ComplainGetSet();  
	            u.setComplaintId(rs.getInt("complaintid")); 
	            u.setComplaintType(rs.getString("typecomplaint"));
	            u.setUrgency(rs.getString("urgency"));
	            u.setName(rs.getString("name"));
	            u.setRole(rs.getString("role"));
	            u.setMobile(rs.getString("mobile"));
	            u.setAadhar(rs.getString("aadhar"));
	            u.setEmail(rs.getString("email"));
	           // u.setBranch(rs.getString("branch"));
	            u.setDescription(rs.getString("description"));
	            u.setStatus(rs.getString("status"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	

	//for student
	public static List<ComplainGetSet> getAllRecordsforStd(){  
	    List<ComplainGetSet> list=new ArrayList<ComplainGetSet>();  
	      
	    try{  
	        Connection con=RegistrationDao.getConnection(); 
	        PreparedStatement ps=con.prepareStatement("select * from stdcomplaint");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            ComplainGetSet u=new ComplainGetSet();  
	            u.setComplaintId(rs.getInt("complaintid")); 
	            u.setComplaintType(rs.getString("typecomplaint"));
	            u.setUrgency(rs.getString("urgency"));
	            u.setName(rs.getString("name"));
	            u.setRole(rs.getString("role"));
	            u.setMobile(rs.getString("mobile"));
	            u.setAadhar(rs.getString("aadhar"));
	            u.setEmail(rs.getString("email"));
	            u.setBranch(rs.getString("branch"));
	            u.setDescription(rs.getString("description"));
	            u.setStatus(rs.getString("status"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	

	//for Faculty
	public static List<ComplainGetSet> getAllRecordsforFac(){  
	    List<ComplainGetSet> list=new ArrayList<ComplainGetSet>();  
	      
	    try{  
	        Connection con=RegistrationDao.getConnection(); 
	        PreparedStatement ps=con.prepareStatement("select * from faccomplaint");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            ComplainGetSet u=new ComplainGetSet();  
	            u.setComplaintId(rs.getInt("complaintid")); 
	            u.setComplaintType(rs.getString("typecomplaint"));
	            u.setUrgency(rs.getString("urgency"));
	            u.setName(rs.getString("name"));
	            u.setRole(rs.getString("role"));
	            u.setMobile(rs.getString("mobile"));
	            u.setAadhar(rs.getString("aadhar"));
	            u.setEmail(rs.getString("email"));
	            u.setBranch(rs.getString("branch"));
	            u.setDescription(rs.getString("description"));
	            u.setStatus(rs.getString("status"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	

	//save Record...
	public static int save(String email,String aadhar,String role,ComplainGetSet e) {
		
		 int status1=0;  
	        try{  
	            Connection con=RegistrationDao.getConnection(); 
	            if(role.equals("Faculty")){
	            PreparedStatement ps1=con.prepareStatement("SELECT email from facregtable1 where email=? AND aadhar=?");  
				System.out.println("2");
				ps1.setString(1, email);
				ps1.setString(2, aadhar);
				System.out.println("3");
				ResultSet rs =ps1.executeQuery();
				boolean status=rs.next();
				System.out.println("4");
				//String check=;
				System.out.println(status);
				System.out.println("5");
				
////////////////////////////////////////////
				if(status){
	            
	            
	            PreparedStatement ps=con.prepareStatement(  
   "insert into faccomplaint(complaintid,"
   + "typecomplaint,urgency,name,role,mobile,"
   + "aadhar,email,branch,description) "
     + "values (?,?,?,?,?,?,?,?,?,?)");  
     ps.setInt(1,e.getComplaintId());  
     ps.setString(2,e.getComplaintType());  
     ps.setString(3,e.getUrgency());  
     ps.setString(4,e.getName());  
     ps.setString(5, e.getRole());
     ps.setString(6, e.getMobile());
     ps.setString(7, e.getAadhar());
     ps.setString(8, e.getEmail());
     ps.setString(9, e.getBranch());
     ps.setString(10, e.getDescription());
    
     status1=ps.executeUpdate();  
       
     con.close(); 
			
				}
				}
	            else{
	            	if(role.equals("Student")){
	            			
	            		PreparedStatement ps1=con.prepareStatement("SELECT email from stdregtable1 where email=? AND aadhar=?");  
	    				System.out.println("2");
	    				ps1.setString(1, email);
	    				ps1.setString(2, aadhar);
	    				System.out.println("3");
	    				ResultSet rs =ps1.executeQuery();
	    				boolean status=rs.next();
	    				System.out.println("4");
	    				//String check=;
	    				System.out.println(status);
	    				System.out.println("5");
	    				
	    ////////////////////////////////////////////
	    				if(status){
	    	            
	    					//java.util.Date date1 = new java.util.Date();
	    	            
	    					PreparedStatement ps=con.prepareStatement(  
	       "insert into stdcomplaint(complaintid,"
	       + "typecomplaint,urgency,name,role,mobile,"
	       + "aadhar,email,branch,description) "
	         + "values (?,?,?,?,?,?,?,?,?,?)"); 
	    	         
	         ps.setInt(1,e.getComplaintId());  
	         ps.setString(2,e.getComplaintType());  
	         ps.setString(3,e.getUrgency());  
	         ps.setString(4,e.getName());  
	         ps.setString(5, e.getRole());
	         ps.setString(6, e.getMobile());
	         ps.setString(7, e.getAadhar());
	         ps.setString(8, e.getEmail());
	         ps.setString(9, e.getBranch());
	         ps.setString(10, e.getDescription());
	        
	         status1=ps.executeUpdate();  
	           
	         con.close(); 
	    			
	    				}

	            	}
	            	else{
	            		if(role.equals("Other")){
	            			PreparedStatement ps1=con.prepareStatement("SELECT email from othersignup where email=? AND aadhar=?");  
	        				System.out.println("2");
	        				ps1.setString(1, email);
	        				ps1.setString(2, aadhar);
	        				System.out.println("3");
	        				ResultSet rs =ps1.executeQuery();
	        				boolean status=rs.next();
	        				System.out.println("4");
	        				//String check=;
	        				System.out.println(status);
	        				System.out.println("5");
	        				
	        ////////////////////////////////////////////
	        				if(status){
	        	            
	        	 PreparedStatement ps=con.prepareStatement(  
	           "insert into othcomplaint(complaintid,"
	           + "typecomplaint,urgency,name,role,mobile,"
	           + "aadhar,email,description) "
	             + "values (?,?,?,?,?,?,?,?,?)");  
	             ps.setInt(1,e.getComplaintId());  
	             ps.setString(2,e.getComplaintType());  
	             ps.setString(3,e.getUrgency());  
	             ps.setString(4,e.getName());  
	             ps.setString(5, e.getRole());
	             ps.setString(6, e.getMobile());
	             ps.setString(7, e.getAadhar());
	             ps.setString(8, e.getEmail());
	             ps.setString(9, e.getDescription());
	            
	             status1=ps.executeUpdate();  
	               
	             con.close(); 
	        			
	        				}

	            		}
	            	}
	            }
	            }
				
				catch(Exception ex){ex.printStackTrace();}  
   
		return status1;
	
	}
	}

