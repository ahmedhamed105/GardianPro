/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ConfigEmail;
import Entities.ConfigParmeter;
import Entities.EmailLog;
import Entities.FtpLog;
import Entities.Parts;
import Facades.ConfigEmailFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.UserFacadeLocal;
import static com.guardian.Login.application.generateRandom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.elemam
 */
public class Pconfig {

    @EJB
    private ConfigEmailFacadeLocal configEmailFacade;
    
         @EJB
    private ConfigParmeterFacadeLocal configParmeterFacade;
         
           @EJB
    private UserFacadeLocal userFacade;
           
           
         
           List<Entities.ConfigParmeter> ConfigParmeter = new ArrayList<Entities.ConfigParmeter>();
         
         Entities.ConfigParmeter selectconfig=new Entities.ConfigParmeter();
         
         
                    List<Entities.ConfigEmail> ConfigEmail = new ArrayList<Entities.ConfigEmail>();
         
         Entities.ConfigEmail selectEmail=new Entities.ConfigEmail();
         
          java.sql.Date date ;

    /**
     * Creates a new instance of Pconfig
     */
    public Pconfig() {
    }

    public List<ConfigEmail> getConfigEmail() {
        return ConfigEmail;
    }

    public void setConfigEmail(List<ConfigEmail> ConfigEmail) {
        this.ConfigEmail = ConfigEmail;
    }

    public ConfigEmail getSelectEmail() {
        return selectEmail;
    }

    public void setSelectEmail(ConfigEmail selectEmail) {
        this.selectEmail = selectEmail;
    }
    
    
    

    public List<ConfigParmeter> getConfigParmeter() {
        return ConfigParmeter;
    }

    public void setConfigParmeter(List<ConfigParmeter> ConfigParmeter) {
        this.ConfigParmeter = ConfigParmeter;
    }

   

    public ConfigParmeter getSelectconfig() {
        return selectconfig;
    }

    public void setSelectconfig(ConfigParmeter selectconfig) {
        this.selectconfig = selectconfig;
    }
    
        public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         ConfigParmeter  = configParmeterFacade.findAll();
        
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
        
        
          public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectconfig=((ConfigParmeter) event.getObject());
            selectconfig.setUpdateDate(date);
          configParmeterFacade.edit(selectconfig);
          
          Messages.addInfoMessage("Edited "+((ConfigParmeter) event.getObject()).getParameter(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ConfigParmeter) event.getObject()).getParameter(),1);
    }
    
       public void onERowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectEmail=((ConfigEmail) event.getObject());
            selectEmail.setUpdateDate(date);
          configEmailFacade.edit(selectEmail);
          
          Messages.addInfoMessage("Edited "+((ConfigEmail) event.getObject()).getEmail(),1);
    }
     
    public void onERowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ConfigEmail) event.getObject()).getEmail(),1);
    }
    
    
    
     public String ADD(){
          if(configEmailFacade.email_find(selectEmail.getEmail())){
             Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            selectEmail.setCreateDate(date);
            selectEmail.setUpdateDate(date);
          configEmailFacade.create(selectEmail);
        }
         
      return "Login";
     }
    
    
}
