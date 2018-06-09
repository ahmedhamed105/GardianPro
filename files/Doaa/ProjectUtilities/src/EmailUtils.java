import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class EmailUtils {
	 public static void send(Email em){  
		//Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",em.getHost());  
		   props.put("mail.smtp.auth", "true"); //enable AUTH 
		   props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		   props.put("mail.smtp.port", "587"); //TLS Port
		   props.put("mail.smtp.starttls.enable", "true"); //enable START TLS
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(em.getFrom(),em.getPassword());  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(em.getFrom()));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(em.getTo()));  
		     message.setSubject(em.getSubject());  
		     message.setText(em.getText());  
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		 }  
		
}

