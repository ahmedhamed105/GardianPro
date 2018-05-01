/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.InputType;
import Entities.Parameter;
import Entities.ParameterType;
import Facades.InputTypeFacadeLocal;
import Facades.ParameterFacadeLocal;
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
public class parameter {

    @EJB
    private ParameterFacadeLocal parameterFacade;
    
        @EJB
    private UserFacadeLocal userFacade;
        
         @EJB
    private InputTypeFacadeLocal inputTypeFacade;
         
         @EJB
    private ParameterTypeFacadeLocal parameterTypeFacade;
        
        
        
         List<Parameter> parmeters = new ArrayList<Parameter>();
         
         List<InputType> input_types = new ArrayList<InputType>();
         
         List<ParameterType> parmeter_types = new ArrayList<ParameterType>();
         
         Parameter parmeter=new Parameter();
         
         Parameter selectparmeter=new Parameter();
         
          java.sql.Date date ;

    /**
     * Creates a new instance of parameter
     */
    public parameter() {
    }
    
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         parmeters  = parameterFacade.findAll();
         input_types = inputTypeFacade.findAll();
         parmeter_types =parameterTypeFacade.findAll();
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

    public List<Parameter> getParmeters() {
        return parmeters;
    }

    public void setParmeters(List<Parameter> parmeters) {
        this.parmeters = parmeters;
    }

    public Parameter getParmeter() {
        return parmeter;
    }

    public void setParmeter(Parameter parmeter) {
        this.parmeter = parmeter;
    }

    public Parameter getSelectparmeter() {
        return selectparmeter;
    }

    public void setSelectparmeter(Parameter selectparmeter) {
        this.selectparmeter = selectparmeter;
    }

    public List<InputType> getInput_types() {
        return input_types;
    }

    public void setInput_types(List<InputType> input_types) {
        this.input_types = input_types;
    }

    public List<ParameterType> getParmeter_types() {
        return parmeter_types;
    }

    public void setParmeter_types(List<ParameterType> parmeter_types) {
        this.parmeter_types = parmeter_types;
    }
    
    
    
    
      
      
      
         public void remove(ActionEvent actionEvent){
         try {
                   parameterFacade.remove(selectparmeter);
             Messages.addInfoMessage("removed "+selectparmeter.getDisplayName(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectparmeter.getDisplayName()+" return to Admin",2);
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          parmeter=((Parameter) event.getObject());
            parmeter.setUpdateDate(date);
          parameterFacade.edit(parmeter);
          
          Messages.addInfoMessage("Edited "+((Parameter) event.getObject()).getDisplayName(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Parameter) event.getObject()).getDisplayName(),1);
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
         
     //   if(parameterFacade.input_find(parmeter.getType())){
    //           Messages.addInfoMessage("Duplicated",2);
    //    }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            parmeter.setCreateDate(date);
            parmeter.setUpdateDate(date);
          parameterFacade.create(parmeter);
     //   }
         
      return "Login";
     }
       
    
}
