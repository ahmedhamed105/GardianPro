/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Accessory;
import Entities.ComponentName;
import Entities.Role;
import Facades.ComponentNameFacadeLocal;
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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.ibraheem
 */


public class ComponentValue {
   
    
    @EJB
    private ComponentNameFacadeLocal componentNameFacade;
     @EJB
    private UserFacadeLocal userFacade;
    
    
     List<ComponentName> ComponentNames= new ArrayList<ComponentName>();
     
     java.sql.Date date ;
     
          ComponentName Component=new ComponentName();
     
    
    
    public ComponentValue(){
       
    }
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         ComponentNames  = componentNameFacade.findAll();    
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 24);
                /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 24);
                /*end mohammed.ayad*/
            }
}
   
    }

    public List<ComponentName> getComponentNames() {
        return ComponentNames;
    }

    public void setComponentNames(List<ComponentName> ComponentNames) {
        this.ComponentNames = ComponentNames;
    }
      
          public void onRowEdit(RowEditEvent event) {
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Component = ((ComponentName) event.getObject());
        Component.setUpdateDate(date);
        componentNameFacade.edit(Component);

        Messages.addInfoMessage("Edited " + ((ComponentName) event.getObject()).getName(), 1,24);
    }

    public void onRowCancel(RowEditEvent event) {
        Messages.addInfoMessage("Cancelled " + ((ComponentName) event.getObject()).getName(), 1,24);
    }
    
    public String getValueById(int id){
    
        ComponentName cn= componentNameFacade.find(id);
        return cn.getValue();
    }
    
}
