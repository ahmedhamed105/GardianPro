/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ActionBar;
import Facades.ActionBarFacadeLocal;
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
    
    
    
        List<Entities.ActionBar> ActionBar =new ArrayList<>();

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
    
    
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         ActionBar  = actionBarFacade.findAll();
        
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