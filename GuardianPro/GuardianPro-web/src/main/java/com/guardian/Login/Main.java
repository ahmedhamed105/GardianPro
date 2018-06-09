/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Facades.TerminalGroupFacadeLocal;
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
public class Main {

    @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      
      
      
           List<Entities.TerminalGroup> TerminalGroup = new ArrayList<Entities.TerminalGroup>();


    /**
     * Creates a new instance of Main
     */
    public Main() {
    }
    
    
    public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         TerminalGroup  = terminalGroupFacade.findAll();
        
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
    
}
