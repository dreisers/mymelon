package net.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	//?¬?©?κ³ μ ?? λ©μΌ?λ²μ? ?Έμ¦λ°?? κ³μ /λΉλ²
  
	private PasswordAuthentication pa;

	public MyAuthenticator() {
	  pa = new PasswordAuthentication("soldesk@pretyimo.cafe24.com", "soldesk6901");
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

	
	
		
	
	
}//class end
