/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Application;
import Entities.ConfigParmeter;
import Facades.ApplicationFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.UserFacadeLocal;
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
           path=configParmeterFacade.getparameter("APP_DIR");
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
              
              try {
             String filename = file.getFileName(); 
            String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
                  System.out.println(extension);
                  if(extension.toUpperCase().trim().equals(".TMS")){
                      System.out.println("ahmed "+app.getAppName());
                      if(applicationFacade.app_find(app.getAppName())){
                           Messages.addInfoMessage("Please Check Application Name",2);
                      }else{
                    String filename_ext = String.valueOf(generateRandom(16));
                   copyFile(path.getPValue(),filename_ext, file.getInputstream());
                      Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            app.setAppDir(path.getPValue()+'/'+filename_ext);
            app.setFilename(filename_ext);
            app.setCreateDate(date);
            app.setUpdateDate(date);
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