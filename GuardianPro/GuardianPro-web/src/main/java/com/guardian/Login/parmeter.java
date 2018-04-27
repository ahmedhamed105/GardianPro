/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ParameterType;
import Facades.ParameterTypeFacadeLocal;
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
public class parmeter {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private ParameterTypeFacadeLocal parameterTypeFacade;
    
    
      List<ParameterType> parmeter_types = new ArrayList<ParameterType>();
      
     ParameterType para= new ParameterType();
     
      java.sql.Date date ;
    

    /**
     * Creates a new instance of parmeter
     */
    public parmeter() {
   
    }
    
    public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
          parmeter_types = parameterTypeFacade.findAll();

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

    public List<ParameterType> getParmeter_types() {
        return parmeter_types;
    }

    public void setParmeter_types(List<ParameterType> parmeter_types) {
        this.parmeter_types = parmeter_types;
    }
    
    

    public ParameterType getPara() {
        return para;
    }

    public void setPara(ParameterType para) {
        this.para = para;
    }
    
     public String ADD(ActionEvent actionEvent){
         
        if(parameterTypeFacade.Paremter_find(para.getType())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            para.setCreateDate(date);
            para.setUpdateDate(date);
          parameterTypeFacade.create(para);
        }
         
      return "Login";
     }
     
     
      public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          para=((ParameterType) event.getObject());
            para.setUpdateDate(date);
          parameterTypeFacade.edit(para);
          
          Messages.addInfoMessage("Edited "+((ParameterType) event.getObject()).getType(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ParameterType) event.getObject()).getType(),1);
    }
    
}
