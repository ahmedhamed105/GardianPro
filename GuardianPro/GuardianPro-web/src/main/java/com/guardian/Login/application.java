/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Application;
import Entities.ConfigParmeter;
import Entities.EmailLog;
import Entities.FtpLog;
import Facades.ApplicationFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.EmailLogFacadeLocal;
import Facades.FtpLogFacadeLocal;
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
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
    private FtpLogFacadeLocal ftpLogFacade;

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
            + "/faces/login.xhtml");

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
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
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
                           Messages.addInfoMessage("Please Check Application Name",2);
                      }else{
                    String filename_ext = String.valueOf(generateRandom(9))+".tms";
                    
                 copyFile(path.getPValue(),filename_ext, file.getInputstream());
                    
File d=new File(path.getPValue()+"/"+filename_ext);
                          try {
                               FtpLog ftp=new FtpLog();
        ftp.setServerip(Login.FTP_server);
        ftp.setFPort(Login.FTP_port);
        ftp.setFUsername(Login.FTP_user);
        ftp.setFpassword(Login.FTP_pass);
        ftp.setLocalDIR(path.getPValue()+"/");
        ftp.setFilename(filename_ext);
        ftp.setFtpDir(Login.FTP_APP_DIR);
        ftp.setUpdateDate(date);
        ftp.setCreateDate(date);
        ftp.setUserID(Login.login);
        ftpLogFacade.create(ftp);
      //  ftp=ftpLogFacade.find(ftp.getId());
         boolean ftp_S=ftpMessagesFacade.Ftp_action(ftp,1);
        if(ftp_S){
        System.out.println("Store file "+ftp_S);
        }else{
        System.out.println("Not Store file "+ftp_S);
        }
                        
         } catch (Exception e) {
                              
                 
		String subject="Not able to Store tms file in FTP";
		String text="Not able to Store tms file in FTP";
         date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	EmailLog email=new EmailLog();
                email.setEhost(Login.smtp_host);
                email.setEfrom(Login.smtp_from);
                email.setEpassword(Login.smtp_password);
                email.setEto(Login.smtp_to);
                email.setEsubject(subject);
                email.setEtext(text);
                email.setEPort(Login.smtp_port);
                email.setETls(Login.smtp_TLS);
                email.setUserID(Login.login);
                email.setEsendnot(0);
                email.setUpdateDate(date);
                email.setCreateDate(date);
                emailLogFacade.create(email);
             boolean send= emailLogFacade.send_email(email);            
             if(send){
                  email.setEsendnot(1);
                  emailLogFacade.edit(email);
             }
             
              System.out.println("com.guardian.Login.Terminalgroup.getXML() "+send);
                              
                              
                       
                          }
        
       
                    
               
                      Messages.addInfoMessage("ADDED",1);
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
                  Messages.addInfoMessage("Please Check File Type",2);
                  }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
           

      return "Login";
     }
         
         
         
          public void remove(ActionEvent actionEvent){
         try {
                   applicationFacade.remove(seletapp);
             Messages.addInfoMessage("removed "+seletapp.getAppName(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+seletapp.getAppName()+" return to Admin",2);
         }
         
     
     }
    
}