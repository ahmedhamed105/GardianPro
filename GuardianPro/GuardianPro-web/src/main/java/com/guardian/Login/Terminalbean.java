/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.ParameterType;
import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TerminalStatus;
import Entities.TerminalTemplate;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TerminalStatusFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
import Facades.TgroupHasTerminalFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class Terminalbean {

    @EJB
    private TgroupHasTerminalFacadeLocal tgroupHasTerminalFacade;

    @EJB
    private TerminalFacadeLocal terminalFacade;

  
    
      @EJB
    private UserFacadeLocal userFacade;
      
      @EJB
    private TerminalTemplateFacadeLocal terminalTemplateFacade;
      @EJB
    private TerminalStatusFacadeLocal terminalStatusFacade;
    
    
    private String date1;
    private String date2;
   
    
    private Terminal term=new Terminal();
    
     List<TerminalTemplate> Terminaltemplate= new ArrayList<TerminalTemplate>();
      TerminalTemplate selecttemplate=new TerminalTemplate();
     
     List<TerminalStatus> Terminalstatus= new ArrayList<TerminalStatus>();
      TerminalStatus selectstatus=new TerminalStatus();
    
     
      List<Terminal> Terminals= new ArrayList<Terminal>();
      
      Terminal selectTerminal=new Terminal();
    
    java.sql.Date date ;
    

    /**
     * Creates a new instance of Terminalbean
     */
    public Terminalbean() {
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
             //Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
        //  parmeter_types = parameterTypeFacade.findAll();
        Terminaltemplate=terminalTemplateFacade.findAll();
        Terminalstatus=terminalStatusFacade.findAll();
        Terminals=terminalFacade.findAll();
            System.out.println("com.guardian.Login.Terminalbean.init() "+Terminals.size());

        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 14);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 14);
                /*end mohammed.ayad*/
            }
}
   
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
      
      
      
      

    public List<TerminalStatus> getTerminalstatus() {
        return Terminalstatus;
    }

    public void setTerminalstatus(List<TerminalStatus> Terminalstatus) {
        this.Terminalstatus = Terminalstatus;
    }

    public TerminalStatus getSelectstatus() {
        return selectstatus;
    }

    public void setSelectstatus(TerminalStatus selectstatus) {
        this.selectstatus = selectstatus;
    }
      
      
      

    public Terminal getSelectTerminal() {
        return selectTerminal;
    }

    public void setSelectTerminal(Terminal selectTerminal) {
        this.selectTerminal = selectTerminal;
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

    public List<Terminal> getTerminals() {
        return Terminals;
    }

    public void setTerminals(List<Terminal> Terminals) {
        this.Terminals = Terminals;
    }
    
    
    
 
       
       
       
           public String Addterminal(ActionEvent actionEvent){
               try {
                   if(terminalFacade.term_find(term.getTid())){
               Messages.addInfoMessage("Duplicated TID",2,14);
        }else{
             Messages.addInfoMessage("ADDED",1,14);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            term.setCreateDate(date);
            term.setUpdateDate(date);
             Date a=new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(date1);  
            term.setScheduleStart(a);
                 Date b=new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(date2);  
            term.setScheduleEnd(b);
            
          terminalFacade.create(term);
        } 
               } catch (Exception e) {
                   Messages.addInfoMessage("Error when add "+e.getMessage(),3,14);
               //    e.printStackTrace();
               }
       
         
      return "Login";
     }
       
       
           
            public void onRowEdit(RowEditEvent event) {
        try {
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            term=((Terminal) event.getObject());
            term.setUpdateDate(date);
            if(!date1.isEmpty() || !"".equals(date1) || date1.length() > 0){
              Date a=new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(date1);  
            term.setScheduleStart(a);
        
            }
             
             if( !date2.isEmpty() || !"".equals(date2) || date2.length() > 0){
                 Date b=new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(date2);  
            term.setScheduleEnd(b);
            }
          
       
            terminalFacade.edit(term);
            
            Messages.addInfoMessage("Edited "+((Terminal) event.getObject()).getTid(),1,14);
        } catch (ParseException ex) {
              Messages.addInfoMessage("Error when update "+ex.getMessage(),3,14);
               ex.printStackTrace();
            //Logger.getLogger(Terminalbean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Terminal) event.getObject()).getTid(),1,14);
    }
    
    
    
         public void remove(ActionEvent actionEvent){
             
             if(tgroupHasTerminalFacade.find_term(selectTerminal)){
             Messages.addInfoMessage("please remove TID from any Terminal Group",2,14);
             }else{
         try {
                   terminalFacade.remove(selectTerminal);
             Messages.addInfoMessage("removed "+selectTerminal.getTid(),1,14);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectTerminal.getTid()+" return to Admin "+e.getMessage(),3,14);
         }
             }
         
     
     }
     
    
    
    
}
