package forgetcode;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;

import otpClass.OTP;  
  
public class SendMailSSL {  
 
  private int varificationCode;
  
	public  int call(String email){
		
		 //OTP Code here................
		  OTP otp= new OTP();
		  varificationCode= otp.generateCode();
		  System.out.println(varificationCode);
		  
		  //End of OTP code here..........
		  
 String to=email;//change accordingly  
  
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("parihar.ravindrasingh@gmail.com","ravindrasingh8233337947");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
	 
	  //Email code Start from here.....
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("parihar.ravindrasingh@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("Call Monitoring System");  
   message.setText("your Varification code is = "+varificationCode);  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   return varificationCode;
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
 }
	
		//for worker registration 
	public static void msgWrkrRegister(String email,String fname) {
		// TODO Auto-generated method stub
		String to=email;
		
		//Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("parihar.ravindrasingh@gmail.com","atominside");//change accordingly  
		   }  
		  });  
		   
		//compose message  
		  try {  
			 
			  //Email code Start from here.....
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("parihar.ravindrasingh@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Call Monitoring System");  
		   //message.setContent("<h2 style='color:white;background-color:red;'>"+fname+"</h2>","text/html");
		   message.setText(fname+" " +"You are registered for CMS...THANKS" );  
		     
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		  // return varificationCode;
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		   
		 }

	public static void msgFacRegistration(String email, String fname, String pass) {
		// TODO Auto-generated method stub
        String to=email;
		
		//Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("parihar.ravindrasingh@gmail.com","atominside");//change accordingly  
		   }  
		  });  
		   
		//compose message  
		  try {  
			 
			  //Email code Start from here.....
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("parihar.ravindrasingh@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Call Monitoring System");  
		   message.setContent("<p>"+fname+"You are Register for Cms.<br>"
		   		+ "UserName : "+email
		   		+"Password : "+pass+"</p>","text/html"); 
		   
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		  // return varificationCode;
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		   

		
	}

	public static void msgOtherrRegister(String email ,String fullname) {
		// TODO Auto-generated method stub
		
           String to=email;
		
		//Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("parihar.ravindrasingh@gmail.com","atominside");//change accordingly  
		   }  
		  });  
		   
		//compose message  
		  try {  
			 
			  //Email code Start from here.....
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("parihar.ravindrasingh@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Call Monitoring System");  
		   message.setContent("<p style='color:red;'>Hi.. "+fullname+" " +"You are registered for CMS.</p>","text/html"); 
		   
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		  // return varificationCode;
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		  
		
	}

	public static void msgComplaint(int complaintId, String complaintType, String urgency, String name, String role,
			String mobile, String aadhar, String email, String branch, String description) {
		
String to=email;
		
		//Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("parihar.ravindrasingh@gmail.com","atominside");//change accordingly  
		   }  
		  });  
		   
		//compose message  
		  try {  
			 
			  //Email code Start from here.....
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("parihar.ravindrasingh@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Call Monitoring System");
		   message.setContent("<h1 style='color:red;'>"+name+"</h1>"
		   		+ "<br>"
		   		+ "Complaint Id : "+complaintId+"<br>"
		   		+"Complaint Type : "+complaintType+"<br>"
		   		+"Complaint Description : "+description+"<br><p style='color:red'>Your Complaint has been Post Successfully and Note Your Complaint Id </p>","text/html");		   
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("complaint sent successfully");  
		  // return varificationCode;
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		  
		
		
	}

	
		
	}
	 
	 

