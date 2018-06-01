package Email;


import Entities.EmailLog;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class EmailUtils {
	 public static void send(EmailLog em){  
		//Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",em.getEhost());  
		   props.put("mail.smtp.auth", "true"); //enable AUTH 
		  // props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		   props.put("mail.smtp.port", em.getEPort()); //TLS Port
                   if(em.getETls()==0){
                   props.put("mail.smtp.starttls.enable", "false"); //enable START TLS
                   }else{
                   props.put("mail.smtp.starttls.enable", "true"); //enable START TLS
                   }
		   
		   Session session = Session.getInstance(props,  
		    new javax.mail.Authenticator() {  
                      @Override
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(em.getEfrom(),em.getEpassword());  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(em.getEfrom()));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(em.getEto()));  
		     message.setSubject(em.getEsubject());  
		     message.setText(em.getEtext());  
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		  
                   
		     } catch (MessagingException e) {
                         
                         e.printStackTrace();
                     
                     }  
		 }  
		
}

