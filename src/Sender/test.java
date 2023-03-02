package Sender;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class test {
	
	public boolean mail(String uEmail, String gcode) throws ClassNotFoundException, SQLException {
		
		//ActivationKeyGenerator activecode = new ActivationKeyGenerator();
		
		//String gcode = activecode.nextString(); //fetch the generate code
		
		String message = "Your account activation code is "+gcode;
		String subject = "Account Activation Code";
		
		//send into check
		
		
		
		///sender email information
		String fromEmail = "bd.ttmatro@gmail.com";
		String username = "bd.ttmatro";
		String password = "Matrobdtt";
		
		
    	Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
    	    		
		
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,password);
			}
		});
    	try {
    		//Session mailSession = Session.getDefaultInstance(props, null);
        	
        	MimeMessage mailmsg = new MimeMessage(session);
			mailmsg.setFrom(new InternetAddress(fromEmail));
	    	mailmsg.setRecipient(Message.RecipientType.TO, new InternetAddress(uEmail));
	    	mailmsg.setContent(message, "text/html");
	    	
	    	Transport.send(mailmsg);
	
											
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
    	return true;

	}

}
