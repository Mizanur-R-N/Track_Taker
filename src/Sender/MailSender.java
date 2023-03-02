package Sender;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/MailSender")
public class MailSender extends HttpServlet {
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
    	
    	
    		
    		PrintWriter out = response.getWriter();
    		
    		String uEmail = request.getParameter("email");
    		
    		ActivationKeyGenerator activecode = new ActivationKeyGenerator();
    		
    		String gcode = activecode.nextString(); //fetch the generate code 
    		   		
			
			String message = "Your account activation code is "+gcode;
			String subject = "Account Activation Code";
			
			//send into check
			checker cc = new checker();
    		//cc.getGenerateCode(gcode);
			
			
			///sender email information
			String fromEmail = "bd.ttmatro@gmail.com";
			String username = "bd.ttmatro";
			String password = "Matrobdtt";
    		
    		
        	Properties props = System.getProperties();
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtp.port", "587");
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.starttls.enable", "true");
        	    		
    		out.println("up to session");
        	
    		
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
		    	
		    	out.println("set to send an email");
		    	
		    	/*Transport transport = mailSession.getTransport("smtp");
		    	transport.connect("smtp.gmail.com", username, password);
		    	
		    	out.println("collect domain mail");
				transport.send(mailmsg, mailmsg.getAllRecipients());*/
		    	Transport.send(mailmsg);
				response.sendRedirect("confirmation.jsp");
				
					
					
				
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
	    	

		
	}


}
