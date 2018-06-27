/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Email.FTPLog;
import Entities.Application;
import Entities.ConfigParmeter;
import Entities.EmailLog;
import Facades.ApplicationFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.EmailLogFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.UserFacadeLocal;
import static com.guardian.Login.Login.smtp_host;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.commons.net.ftp.FTPClient;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author ahmed.elemam
 */
public class application {
    
    
    @EJB
    private EmailLogFacadeLocal emailLogFacade;
    
     @EJB
    private FtpMessagesFacadeLocal ftpMessagesFacade;

   

    @EJB
    private ConfigParmeterFacadeLocal configParmeterFacade;

    @EJB
    private ApplicationFacadeLocal applicationFacade;
    
    @EJB
    private UserFacadeLocal userFacade;
    
    
    
      List<Application> applicatios = new ArrayList<Application>();
      
      private Application seletapp= new Application();
      
     Application app= new Application();
     
      java.sql.Date date ;
      
      ConfigParmeter path;
      
      
      private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * Creates a new instance of application
     */
    public application() {
    }
    
    
     public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
          applicatios = applicationFacade.findAll();
           path=configParmeterFacade.getparameter("LOCAL_APP_DIR");
             Login.smtp_host=configParmeterFacade.getparameter("smtp_host").getPValue(); //SMTP Server
		Login.smtp_from=configParmeterFacade.getparameter("smtp_from").getPValue();//from account
		Login.smtp_password=configParmeterFacade.getparameter("smtp_password").getPValue();     //password from account
		Login.smtp_to=configParmeterFacade.getparameter("smtp_to").getPValue();//recipient account
                Login.smtp_port=configParmeterFacade.getparameter("smtp_port").getPValue();//recipient account
                Login.smtp_TLS=Integer.parseInt(configParmeterFacade.getparameter("smtp_TLS").getPValue());//recipient account
                Login.FTP_server = configParmeterFacade.getparameter("FTP_server").getPValue();
                Login.FTP_port = configParmeterFacade.getparameter("FTP_port").getPValue();
                Login.FTP_user = configParmeterFacade.getparameter("FTP_user").getPValue();
                Login.FTP_pass = configParmeterFacade.getparameter("FTP_pass").getPValue();  
                Login.FTP_APP_DIR = configParmeterFacade.getparameter("FTP_APP_DIR").getPValue(); 
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 19);
                /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 19);
                /*end mohammed.ayad*/
            }
}
   
    }

    public List<Application> getApplicatios() {
        return applicatios;
    }

    public void setApplicatios(List<Application> applicatios) {
        this.applicatios = applicatios;
    }

    public Application getSeletapp() {
        return seletapp;
    }

    public void setSeletapp(Application seletapp) {
        this.seletapp = seletapp;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }
    
    
     public void copyFile(String destination,String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination+"/" + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 19);
                /*end mohammed.ayad*/
                }
    }
     
     
     public static long generateRandom(int length) {
    Random random = new Random();
    char[] digits = new char[length];
    digits[0] = (char) (random.nextInt(9) + '1');
    for (int i = 1; i < length; i++) {
        digits[i] = (char) (random.nextInt(10) + '0');
    }
    return Long.parseLong(new String(digits));
}
   

         public String ADD(){
                            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                
              try {
             String filename = file.getFileName(); 
            String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
                  System.out.println(extension);
                  if(extension.toUpperCase().trim().equals(".TMS")){
                      System.out.println("ahmed "+app.getAppName());
                      if(applicationFacade.app_find(app.getAppName())){
                           Messages.addInfoMessage("Please Check Application Name",2,19);
                      }else{
                    String filename_ext = String.valueOf(generateRandom(9))+".tms";
                    
                 copyFile(path.getPValue(),filename_ext, file.getInputstream());
                    
File d=new File(path.getPValue()+"/"+filename_ext);
                          try {
                              
                               FTPLog ftp=new FTPLog();
        ftp.setfPort(Login.FTP_port);
        ftp.setfUsername(Login.FTP_user);
        ftp.setServerip(Login.FTP_server);
        ftp.setFpassword(Login.FTP_pass);
        ftp.setLocalDIR(path.getPValue()+"/");
        ftp.setFilename(filename_ext);
        ftp.setFtpDir(Login.FTP_APP_DIR);
        ftp.setUpdateDate(date);
        ftp.setCreateDate(date);
        ftp.setUserID(Login.login);
        
        FTPClient ftpclien=ftpMessagesFacade.Ftp_open(ftp);                      
                              
                                if(ftpclien !=null){
       
      //  ftp=ftpLogFacade.find(ftp.getId());
         boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,1,ftpclien);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
        }else{
        System.out.println("Not Store file "+ftp_S);
        }
                           if(!ftpMessagesFacade.Ftp_Close(ftpclien, Login.login))
                      email("APP FTP ERROR","username or password is Wrong");
                
               }else{
               email("APP FTP ERROR","username or password is Wrong");
   }
                        
         } catch (Exception e) {
                 /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 19);
                /*end mohammed.ayad*/             
                 
		String subject="Not able to Store tms file in FTP";
		String text="Not able to Store tms file in FTP";
         date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	EmailLog email=new EmailLog();
                email.setEsubject(subject);
                email.setEtext(text);
                email.setUserID(Login.login);
                email.setUpdateDate(date);
                email.setCreateDate(date);
                emailLogFacade.create(email);
             
      //        System.out.println("com.guardian.Login.Terminalgroup.getXML() "+send);
                              
                              
                       
                          }
        
       
                    
               
                      Messages.addInfoMessage("ADDED",1,19);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            app.setAppDir("\\APPLICATION\\"+filename_ext);
            app.setFilename(filename_ext);
            app.setAppSize((int) file.getSize());
            app.setCreateDate(date);
            app.setUpdateDate(date);
            app.setAPPlength((int) d.length());
          applicationFacade.create(app);
                      }
                  }else{
                  Messages.addInfoMessage("Please Check File Type",2,19);
                  }
           
        } catch (IOException e) {
            e.printStackTrace();
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 19);
                /*end mohammed.ayad*/
        }
           

      return "Login";
     }
         
         
         
          public void remove(ActionEvent actionEvent){
         try {
                   applicationFacade.remove(seletapp);
             Messages.addInfoMessage("removed "+seletapp.getAppName(),1,19);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+seletapp.getAppName()+" return to Admin "+e.getMessage(),3,19);
         }
         
     
     }
          
            public  void email(String text,String subject){
         Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	EmailLog email=new EmailLog();
                email.setEsubject(text);
                email.setEtext(subject);
                email.setUserID(Login.login);
                email.setUpdateDate(date);
                email.setCreateDate(date);
                emailLogFacade.create(email);
      }  
    
}