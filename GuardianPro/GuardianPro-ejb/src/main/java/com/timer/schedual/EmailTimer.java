/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;


import Email.Encryption;
import Entities.ConfigEmail;
import Entities.ConfigParmeter;
import Entities.EmailHistory;
import Entities.EmailLog;
import Entities.TerminalParserLog;
import Facades.ConfigEmailFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.EmailHistoryFacadeLocal;
import Facades.EmailLogFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalParserLogFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author martin
 */
//@Startup
@Singleton
@LocalBean
public class EmailTimer {

    @EJB
    private EmailHistoryFacadeLocal emailHistoryFacade;

    @EJB
    private ConfigEmailFacadeLocal configEmailFacade;

    @EJB
    private EmailLogFacadeLocal emailLogFacade;

    @EJB
    TerminalParserLogFacadeLocal terminalLogFile;
    
        @EJB
    private ConfigParmeterFacadeLocal configParmeterFacade;
        
        
        
        
    
       static String smtp_host="smtp.gmail.com"; //SMTP Server
		 String smtp_from="ahmed2000105@gmail.com";//from account
		 String smtp_password="P@ssw0rd0109045227";     //password from account
		 String smtp_to="ahmed.hamed0@me.com";//recipient account
                 String smtp_port="587";//recipient account
                 int smtp_TLS=1;//recipient account
                 String FTP_server = "localhost";
                 String FTP_port = "21";
                 String FTP_user = "ahmed";
                 String FTP_pass = "123456";  
                
                 String FTP_APP_DIR = "\\APPLICATION\\"; 
                 String FTP_APP_Live_DIR = "\\APP\\"; 
                 String FTP_LOCAL_DIR = "C:\\"; 
                 String FTP_XML_Live_DIR = "\\POS\\"; 
    
    
    
    


    @Schedule(hour = "*", minute = "*/10", persistent = false)
    public void execute(Timer timer) {

        System.out.println("Email Executing ...");

        System.out.println("Execution Time : " + new Date());
        
         smtp_host=configParmeterFacade.getparameter("smtp_host").getPValue(); //SMTP Server
              if(configParmeterFacade.getparameter("smtp_host").getEncryption()==1){
                smtp_host=Encryption.decrypt(configParmeterFacade.getparameter("smtp_host").getPValue());
                }
		smtp_from=configParmeterFacade.getparameter("smtp_from").getPValue();//from account
                if(configParmeterFacade.getparameter("smtp_from").getEncryption()==1){
                smtp_from=Encryption.decrypt(configParmeterFacade.getparameter("smtp_from").getPValue());
                }
		smtp_password=configParmeterFacade.getparameter("smtp_password").getPValue();     //password from account
		 if(configParmeterFacade.getparameter("smtp_password").getEncryption()==1){
                smtp_password=Encryption.decrypt(configParmeterFacade.getparameter("smtp_password").getPValue());
                }
                smtp_to=configParmeterFacade.getparameter("smtp_to").getPValue();//recipient account
                 if(configParmeterFacade.getparameter("smtp_to").getEncryption()==1){
                smtp_to=Encryption.decrypt(configParmeterFacade.getparameter("smtp_to").getPValue());
                }
                smtp_port=configParmeterFacade.getparameter("smtp_port").getPValue();//recipient account
                 if(configParmeterFacade.getparameter("smtp_port").getEncryption()==1){
                smtp_port=Encryption.decrypt(configParmeterFacade.getparameter("smtp_port").getPValue());
                }
                smtp_TLS=Integer.parseInt(configParmeterFacade.getparameter("smtp_TLS").getPValue());//recipient account
                 if(configParmeterFacade.getparameter("smtp_TLS").getEncryption()==1){
                smtp_TLS=Integer.parseInt(Encryption.decrypt(configParmeterFacade.getparameter("smtp_TLS").getPValue()));
                }
                FTP_server = configParmeterFacade.getparameter("FTP_server").getPValue();
                 if(configParmeterFacade.getparameter("FTP_server").getEncryption()==1){
                FTP_server=Encryption.decrypt(configParmeterFacade.getparameter("FTP_server").getPValue());
                }
                FTP_port = configParmeterFacade.getparameter("FTP_port").getPValue();
                 if(configParmeterFacade.getparameter("FTP_port").getEncryption()==1){
                FTP_port=Encryption.decrypt(configParmeterFacade.getparameter("FTP_port").getPValue());
                }
                FTP_user = configParmeterFacade.getparameter("FTP_user").getPValue();
                 if(configParmeterFacade.getparameter("FTP_user").getEncryption()==1){
                FTP_user=Encryption.decrypt(configParmeterFacade.getparameter("FTP_user").getPValue());
                }
                FTP_pass = configParmeterFacade.getparameter("FTP_pass").getPValue();  
                 if(configParmeterFacade.getparameter("FTP_pass").getEncryption()==1){
                FTP_pass=Encryption.decrypt(configParmeterFacade.getparameter("FTP_pass").getPValue());
                }
                FTP_APP_DIR = configParmeterFacade.getparameter("FTP_APP_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_APP_DIR").getEncryption()==1){
                FTP_APP_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_APP_DIR").getPValue());
                }
                FTP_APP_Live_DIR = configParmeterFacade.getparameter("FTP_APP_Live_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_APP_Live_DIR").getEncryption()==1){
                FTP_APP_Live_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_APP_Live_DIR").getPValue());
                }
                FTP_LOCAL_DIR = configParmeterFacade.getparameter("FTP_LOCAL_DIR").getPValue(); 
                 if(configParmeterFacade.getparameter("FTP_LOCAL_DIR").getEncryption()==1){
                FTP_LOCAL_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_LOCAL_DIR").getPValue());
                }
                FTP_XML_Live_DIR = configParmeterFacade.getparameter("FTP_XML_Live_DIR").getPValue(); 
                if(configParmeterFacade.getparameter("FTP_XML_Live_DIR").getEncryption()==1){
                FTP_XML_Live_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_XML_Live_DIR").getPValue());
                } 
                
                
              Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());   
        
        
        List<EmailLog> emails=emailLogFacade.findAll();
        System.out.println("emails "+emails);
        if(emails != null){
        for(EmailLog email:emails){
            
            if(email.getPending() == 0){
              List<ConfigEmail> senders=configEmailFacade.findAll();
              
              if(senders !=null){
                  
                    for(ConfigEmail send:senders){
                      
                  EmailHistory history=new EmailHistory();
                  history.setEmail(send.getEmail());
                  history.setEmaillogID(email);
                  history.setEsendnot(0);
                  history.setConfigemailID(send);
                  history.setCreateDate(date);
                  history.setUpdateDate(date);
                  emailHistoryFacade.create(history);
              
              }
                    
                       email.setPending(1);
                  email.setUpdateDate(date);
                  emailLogFacade.edit(email);
              
              }
               
            }
    
        }
       
        
        
          List<EmailHistory> Hemails=emailHistoryFacade.findAll();
        System.out.println("emails "+Hemails);
        if(Hemails != null){
        for(EmailHistory email:Hemails){
     
            if(email.getEsendnot() == 0){
              boolean sendok = send(email.getConfigemailID().getEmail(),email.getEmaillogID().getEsubject(),email.getEmaillogID().getEtext());  
  
         System.out.println("send "+sendok);
             if(sendok){       
                  email.setEsendnot(1);
                  email.setUpdateDate(date);
                  emailHistoryFacade.edit(email);
             }
            }
    
              }
       
        }
        
        }

    }

    @PostConstruct
    public void init() {
        System.out.println("intit..............");
//        parseTerminalsLogFiles("E:\\3yad\\private\\projects\\GardianPro\\20180602_001014_40000001.LOG");
       
    }
    
    
     public  boolean send(String email,String subject,String main){  
             
              
             
		//Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",smtp_host);  
		   props.put("mail.smtp.auth", "true"); //enable AUTH 
		  // props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		   props.put("mail.smtp.port", smtp_port); //TLS Port
                   if(smtp_TLS==0){
                   props.put("mail.smtp.starttls.enable", "false"); //enable START TLS
                   }else{
                   props.put("mail.smtp.starttls.enable", "true"); //enable START TLS
                   }
		   
		   Session session = Session.getInstance(props,  
		    new javax.mail.Authenticator() {  
                      @Override
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(smtp_from,smtp_password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(smtp_from));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
		     message.setSubject(subject);  
		     message.setText(main);  
		                      try {
                              Transport.send(message);  
                              return true;
                        } catch (Exception e) {
                              return false;
                        }
		    //send the message  
		   
		  
		    
		  
                   
		     } catch (MessagingException e) {
                             return false;
                        // e.printStackTrace();
                     
                     }  
		 }  
		



    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
