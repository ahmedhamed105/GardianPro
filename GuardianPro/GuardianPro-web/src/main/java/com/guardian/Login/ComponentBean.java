/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Component;
import Entities.ParameterType;
import Facades.ComponentFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.ibraheem
 */
@Named(value = "componentBean")
@Dependent
public class ComponentBean {

    @EJB
    private UserFacadeLocal userFacade;

    
    
    @EJB
    private ComponentFacadeLocal componentFacade;

    /**
     * Creates a new instance of ComponentBean
     */
    
    List<Component> Components = new ArrayList<Component>();
      
      private Component selectComponent= new Component();
      
     Component comp= new Component();
     
      java.sql.Date date ;
    
    public ComponentBean() {
    }
    
    public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
          Components = componentFacade.findAll();

        }
        
        } catch (Exception e) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Component.class.getName()).log(Level.SEVERE, null, ex);
            }
}
   
    }

    public List<Component> getComponents() {
        return Components;
    }

    public void setComponents(List<Component> Components) {
        this.Components = Components;
    }

    public Component getSelectComponent() {
        return selectComponent;
    }

    public void setSelectComponent(Component selectComponent) {
        this.selectComponent = selectComponent;
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public void remove(ActionEvent actionEvent){
         try {
                   componentFacade.remove(selectComponent);
             Messages.addInfoMessage("removed "+selectComponent.getDescription(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectComponent.getDescription()+" return to Admin",2);
         }
         
     
     }
    
    
    public String ADD(ActionEvent actionEvent){
         
        if(componentFacade.Component_find(comp.getDescription())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            comp.setCreateDate(date);
            comp.setUpdateDate(date);
          componentFacade.create(comp);
        }
         
      return "Login";
     }
    
    
    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          comp=((Component) event.getObject());
            comp.setUpdateDate(date);
          componentFacade.edit(comp);
          
          Messages.addInfoMessage("Edited "+((Component) event.getObject()).getDescription(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Component) event.getObject()).getDescription(),1);
    }
}
