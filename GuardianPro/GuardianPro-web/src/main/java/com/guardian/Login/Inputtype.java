/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.InputType;
import Facades.InputTypeFacadeLocal;
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
 * @author ahmed.elemam
 */
public class Inputtype {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private InputTypeFacadeLocal inputTypeFacade;
    
     
     
    
    
     List<InputType> input_types = new ArrayList<InputType>();
    java.sql.Date date ;
     
     InputType type=new InputType();;
    
    /**
     * Creates a new instance of Inputtype
     */
    public Inputtype() {
    }
    
    
     public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         input_types  = inputTypeFacade.findAll();

        }
        
        } catch (Exception e) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmeter.class.getName()).log(Level.SEVERE, null, ex);
            }
}
   
    }

    public List<InputType> getInput_types() {
        return input_types;
    }

    public void setInput_types(List<InputType> input_types) {
        this.input_types = input_types;
    }



    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          type=((InputType) event.getObject());
            type.setUpdateDate(date);
          inputTypeFacade.edit(type);
          
          Messages.addInfoMessage("Edited "+((InputType) event.getObject()).getType(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((InputType) event.getObject()).getType(),1);
    }
       
    
    
}
