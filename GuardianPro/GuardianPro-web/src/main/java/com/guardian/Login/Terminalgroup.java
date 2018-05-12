/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ApplicationGroup;
import Entities.Terminal;
import Entities.TerminalGroup;
import Facades.ApplicationGroupFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
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

/**
 *
 * @author ahmed.elemam
 */
public class Terminalgroup {

    @EJB
    private ApplicationGroupFacadeLocal applicationGroupFacade;
    
      @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
      
        @EJB
    private UserFacadeLocal userFacade;
        
         @EJB
    private TerminalFacadeLocal terminalFacade;
         
         
      
      
       private TerminalGroup termgroup=new TerminalGroup();
       
        java.sql.Date date ;
        
        List<Terminal> Terminals= new ArrayList<Terminal>();
        
        List<Terminal> selectTerminals= new ArrayList<Terminal>();
        
        
         List<ApplicationGroup> Appgroup= new ArrayList<ApplicationGroup>();
        
        List<ApplicationGroup> selectAppgroup= new ArrayList<ApplicationGroup>();
        

    /**
     * Creates a new instance of Terminalgroup
     */
    public Terminalgroup() {
    }

    public TerminalGroup getTermgroup() {
        return termgroup;
    }

    public void setTermgroup(TerminalGroup termgroup) {
        this.termgroup = termgroup;
    }

    public List<Terminal> getTerminals() {
        return Terminals;
    }

    public void setTerminals(List<Terminal> Terminals) {
        this.Terminals = Terminals;
    }

    public List<Terminal> getSelectTerminals() {
        return selectTerminals;
    }

    public void setSelectTerminals(List<Terminal> selectTerminals) {
        this.selectTerminals = selectTerminals;
    }

    public List<ApplicationGroup> getAppgroup() {
        return Appgroup;
    }

    public void setAppgroup(List<ApplicationGroup> Appgroup) {
        this.Appgroup = Appgroup;
    }

    public List<ApplicationGroup> getSelectAppgroup() {
        return selectAppgroup;
    }

    public void setSelectAppgroup(List<ApplicationGroup> selectAppgroup) {
        this.selectAppgroup = selectAppgroup;
    }
    
    
    
    
    
    
       public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
        //  parmeter_types = parameterTypeFacade.findAll();
         Terminals=terminalFacade.findAll();
           Appgroup=applicationGroupFacade.findAll();

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

    
          public String Addgroup(ActionEvent actionEvent){
         
        if(terminalGroupFacade.group_find(termgroup.getGroupname())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            termgroup.setCreateDate(date);
            termgroup.setUpdateDate(date);
          terminalGroupFacade.create(termgroup);
        }
         
      return "Login";
     }
    
}
