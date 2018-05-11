/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TerminalTemplate;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
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
public class Terminalbean {

    @EJB
    private TerminalFacadeLocal terminalFacade;

    @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      @EJB
    private TerminalTemplateFacadeLocal terminalTemplateFacade;
      
      
    
    
    private TerminalGroup termgroup=new TerminalGroup();
    
    private Terminal term=new Terminal();
    
     List<TerminalTemplate> Terminaltemplate= new ArrayList<TerminalTemplate>();
     
     TerminalTemplate selecttemplate=new TerminalTemplate();
    
    java.sql.Date date ;
    

    /**
     * Creates a new instance of Terminalbean
     */
    public Terminalbean() {
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
        Terminaltemplate=terminalTemplateFacade.findAll();

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

    public TerminalGroup getTermgroup() {
        return termgroup;
    }

    public void setTermgroup(TerminalGroup termgroup) {
        this.termgroup = termgroup;
    }

    public Terminal getTerm() {
        return term;
    }

    public void setTerm(Terminal term) {
        this.term = term;
    }

    public List<TerminalTemplate> getTerminaltemplate() {
        return Terminaltemplate;
    }

    public void setTerminaltemplate(List<TerminalTemplate> Terminaltemplate) {
        this.Terminaltemplate = Terminaltemplate;
    }

    public TerminalTemplate getSelecttemplate() {
        return selecttemplate;
    }

    public void setSelecttemplate(TerminalTemplate selecttemplate) {
        this.selecttemplate = selecttemplate;
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
       
       
       
           public String Addterminal(ActionEvent actionEvent){
         
        if(terminalFacade.term_find(term.getTid())){
               Messages.addInfoMessage("Duplicated TID",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            term.setCreateDate(date);
            term.setUpdateDate(date);
            
          terminalFacade.create(term);
        }
         
      return "Login";
     }
       
       
     
    
    
    
}
