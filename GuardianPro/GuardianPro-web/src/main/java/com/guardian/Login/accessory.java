/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Accessory;
import Entities.Parameter;
import Facades.AccessoryFacadeLocal;
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
public class accessory {

    @EJB
    private AccessoryFacadeLocal accessoryFacade;
    
    @EJB
    private UserFacadeLocal userFacade;
    
    
    
     List<Entities.Accessory> Accessories = new ArrayList<Accessory>();
     
      Accessory Accessory=new Accessory();
         
         Accessory selectacc=new Accessory();
         
          java.sql.Date date ;

    /**
     * Creates a new instance of accessory
     */
    public accessory() {
    }
    
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         Accessories  = accessoryFacade.findAll();    
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

    public List<Accessory> getAccessories() {
        return Accessories;
    }

    public void setAccessories(List<Accessory> Accessories) {
        this.Accessories = Accessories;
    }

    public Accessory getAccessory() {
        return Accessory;
    }

    public void setAccessory(Accessory Accessory) {
        this.Accessory = Accessory;
    }

    public Accessory getSelectacc() {
        return selectacc;
    }

    public void setSelectacc(Accessory selectacc) {
        this.selectacc = selectacc;
    }

  
      
        public void remove(ActionEvent actionEvent){
         try {
                   accessoryFacade.remove(selectacc);
             Messages.addInfoMessage("removed "+selectacc.getAccName(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectacc.getAccName()+" return to Admin",2);
         }
         
     
     }
        
        
        
          public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          Accessory=((Accessory) event.getObject());
            Accessory.setUpdateDate(date);
          accessoryFacade.edit(Accessory);
          
          Messages.addInfoMessage("Edited "+((Accessory) event.getObject()).getAccName(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Accessory) event.getObject()).getAccName(),1);
    }
    
    
    public String ADD(ActionEvent actionEvent){
         
      if(accessoryFacade.access_find(Accessory.getAccName())){
             Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Accessory.setCreateDate(date);
            Accessory.setUpdateDate(date);
          accessoryFacade.create(Accessory);
        }
         
      return "Login";
     }
    
}
