package otpClass;

public class OTP {
	//for otp code
	public int generateCode(){
		
		int x=(int) (Math.random()*10000);
		if(x<999)
			{x = x+1000;}
		return x;
		
		}

		//for complaintId
        public static int generateComplaintId(){
		
		int x=(int) (Math.random()*1000000);
		if(x<9999999)
			{x = x+1000000;}
		return x;
		
		}

}