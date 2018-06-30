/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.ConfigEmail;
import Entities.ConfigParmeter;
import Entities.RParameter;
import Entities.Reports;
import Facades.ConfigEmailFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.RParameterFacadeLocal;
import Facades.ReportsFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
           
            @EJB
    private RParameterFacadeLocal rParameterFacade;

    @EJB
    private ReportsFacadeLocal reportsFacade;
           
                      List<Entities.Reports> Reports = new ArrayList<Entities.Reports>();
         
         Entities.Reports selectReports=new Entities.Reports();
         
         
            List<Entities.RParameter> RParameter = new ArrayList<Entities.RParameter>();
         
         Entities.RParameter selectRParameter=new Entities.RParameter();
         
           List<Entities.ConfigParmeter> ConfigParmeterh = new ArrayList<Entities.ConfigParmeter>();
         
         Entities.ConfigParmeter selectconfigh=new Entities.ConfigParmeter();
         
         
                    List<Entities.ConfigEmail> ConfigEmail = new ArrayList<Entities.ConfigEmail>();
         
         Entities.ConfigEmail selectEmail=new Entities.ConfigEmail();
         
          java.sql.Date date ;

    /**
     * Creates a new instance of Pconfig
     */
          
    public Pconfig() {
    }

    public List<Reports> getReports() {
        return Reports;
    }

    public void setReports(List<Reports> Reports) {
        this.Reports = Reports;
    }

    public List<RParameter> getRParameter() {
        return RParameter;
    }

    public void setRParameter(List<RParameter> RParameter) {
        this.RParameter = RParameter;
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
    
    
    


    public ConfigParmeter getSelectconfigh() {
        return selectconfigh;
    }

    public void setSelectconfigh(ConfigParmeter selectconfigh) {
        this.selectconfigh = selectconfigh;
    }

    public List<ConfigParmeter> getConfigParmeterh() {
        return ConfigParmeterh;
    }

    public void setConfigParmeterh(List<ConfigParmeter> ConfigParmeterh) {
        this.ConfigParmeterh = ConfigParmeterh;
    }

   

  

    public Reports getSelectReports() {
        return selectReports;
    }

    public void setSelectReports(Reports selectReports) {
        this.selectReports = selectReports;
    }

    public RParameter getSelectRParameter() {
        return selectRParameter;
    }

    public void setSelectRParameter(RParameter selectRParameter) {
        this.selectRParameter = selectRParameter;
    }
    
    
    
         public void init(){ FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
if(session==null){
                 try {
                     Login.login=null;
                     ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                     
                     ec.redirect(ec.getRequestContextPath()
                             + "/faces/index.xhtml");
                 } catch (IOException ex) {
                     Logger.getLogger(accessgroup.class.getName()).log(Level.SEVERE, null, ex);
                 }
}
             //Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
         ConfigParmeterh  = configParmeterFacade.findAll();
         ConfigEmail=configEmailFacade.findAll();
         RParameter=rParameterFacade.findAll();
         Reports=reportsFacade.findAll();
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 9);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 9);
                /*end mohammed.ayad*/
            }
}
   
    }
        
                 public void onRowEditrp(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectRParameter=((RParameter) event.getObject());
            selectRParameter.setUpdateDate(date);
          rParameterFacade.edit(selectRParameter);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((RParameter) event.getObject()).getRpara(),1,9);
          /*end mohammed.ayad*/
    }
     
    public void onRowCancelrp(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((RParameter) event.getObject()).getRpara(),1,9);
          /*end mohammed.ayad*/
    }
        
            public void onRowEditr(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectReports=((Reports) event.getObject());
            selectReports.setUpdateDate(date);
          reportsFacade.edit(selectReports);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((Reports) event.getObject()).getReportname(),1,9);
          /*end mohammed.ayad*/
    }
     
    public void onRowCancelr(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((Reports) event.getObject()).getReportname(),1,9);
          /*end mohammed.ayad*/
    }
        
        
          public void onRowEditdf(RowEditEvent event) {
        
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectconfigh=((ConfigParmeter) event.getObject());        
          if(selectconfigh.getEncryption()== 1){
         selectconfigh.setPValue(Encryption.encrypt(selectconfigh.getPValue()));
          }
            selectconfigh.setUpdateDate(date);
          configParmeterFacade.edit(selectconfigh);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((ConfigParmeter) event.getObject()).getParameter(),1,9);
          /*end mohammed.ayad*/
    }
          
     
    public void onRowCanceldf(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((ConfigParmeter) event.getObject()).getParameter(),1,9);
          /*end mohammed.ayad*/
    }
    
       public void onERowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selectEmail=((ConfigEmail) event.getObject());
            selectEmail.setUpdateDate(date);
          configEmailFacade.edit(selectEmail);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((ConfigEmail) event.getObject()).getEmail(),1,9);
          /*end mohammed.ayad*/
    }
     
    public void onERowCancel(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((ConfigEmail) event.getObject()).getEmail(),1,9);
          /*end mohammed.ayad*/
    }
    
    
    
      public String ADD(ActionEvent actionEvent){
          if(configEmailFacade.email_find(selectEmail.getEmail())){
              /*start mohammed.ayad*/
             Messages.addInfoMessage("Duplicated",2,9);
             /*end mohammed.ayad*/
        }else{
              /*start mohammed.ayad*/
             Messages.addInfoMessage("ADDED",1,9);
             /*end mohammed.ayad*/
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            selectEmail.setCreateDate(date);
            selectEmail.setUpdateDate(date);
            selectEmail.setUserID(Login.login);
          configEmailFacade.create(selectEmail);
        }
         
      return "Login";
     }
    
    
}
