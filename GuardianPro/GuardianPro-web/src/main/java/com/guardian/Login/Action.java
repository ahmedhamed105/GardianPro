/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import Email.FTPLog;
import javax.servlet.http.HttpSession;

import Entities.ActionBar;
import Entities.EmailLog;
import Entities.FtpMessages;
import Entities.LogScreen;
import Facades.ActionBarFacadeLocal;
import Facades.EmailLogFacade;
import Facades.EmailLogFacadeLocal;
import Facades.FtpMessagesFacade;
import Facades.FtpMessagesFacadeLocal;
import Facades.LogScreenFacade;
import Facades.LogScreenFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed.elemam
 */
public class Action {
    
          @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private ActionBarFacadeLocal actionBarFacade;
    
     @EJB
    private EmailLogFacadeLocal EmailLogfacade;
     
     @EJB
    private FtpMessagesFacadeLocal FtpMessagesfacade;
     
          @EJB
    private LogScreenFacadeLocal LogScreenfacade;
    
    
    
        List<Entities.ActionBar> ActionBar =new ArrayList<>();
        
           List<String> Log =new ArrayList<>();

    /**
     * Creates a new instance of Action
     */
    public Action() {
    }

    public List<ActionBar> getActionBar() {
        return ActionBar;
    }

    public void setActionBar(List<ActionBar> ActionBar) {
        this.ActionBar = ActionBar;
    }

    public List<String> getLog() {
        return Log;
    }

    public void setLog(List<String> Log) {
        this.Log = Log;
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
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//
//    ec.redirect(ec.getRequestContextPath()
//            + "/faces/index.xhtml");

        }else{
         ActionBar  = actionBarFacade.findAll();
         List<EmailLog> a=EmailLogfacade.findAll();
         List<FtpMessages> b=FtpMessagesfacade.findAll();
        List<LogScreen> c= LogScreenfacade.findAll();
         
        if(a != null){
        Log.add(a.get(a.size()-1).getEtext());
        }
        
           if(b != null){
        Log.add(b.get(b.size()-1).getFmessages());
        }
           
             if(c != null){
        Log.add(c.get(c.size()-1).getTRXdesc());
        }
         
         
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 1);
            /*end mohammed.ayad*/
//            try {
//                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//                
//                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
//            } catch (IOException ex) {
//                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
//                /*start mohammed.ayad*/
//                Messages.addInfoMessage(e.getMessage(), 3, 1);
//                /*end mohammed.ayad*/
//            }
}
   
    }
    
}
