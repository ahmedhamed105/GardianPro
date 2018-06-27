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
import javax.faces.event.ActionEvent;
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
     List<InputType> filteredtype = new ArrayList<InputType>();
     InputType type=new InputType();
     InputType selecttype=new InputType();
    
    /**
     * Creates a new instance of Inputtype
     */
    public Inputtype() {
    }
    
    
        public void init(){
                //Login.login = userFacade.find(1);
           try {
           if(Login.login==null || Login.login.getId() == 0){
           ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

       ec.redirect(ec.getRequestContextPath()
               + "/faces/login.xhtml");

           }else{
            input_types  = inputTypeFacade.findAll();

           }

           } catch (Exception e) {
               /*start mohammed.ayad*/
               Messages.addInfoMessage(e.getMessage(), 3, 4);
               /*end mohammed.ayad*/
               try {
                   ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                   ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
               } catch (IOException ex) {
                   Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                   /*start mohammed.ayad*/
                    Messages.addInfoMessage(ex.getMessage(), 3, 4);
                    /*end mohammed.ayad*/
               }
   }

       }

    public InputType getSelecttype() {
        return selecttype;
    }

    public void setSelecttype(InputType selecttype) {
        this.selecttype = selecttype;
    }
     
     

    public List<InputType> getInput_types() {
        return input_types;
    }

    public void setInput_types(List<InputType> input_types) {
        this.input_types = input_types;
    }

    public InputType getType() {
        return type;
    }

    public void setType(InputType type) {
        this.type = type;
    }

    public List<InputType> getFilteredtype() {
        return filteredtype;
    }

    public void setFilteredtype(List<InputType> filteredtype) {
        this.filteredtype = filteredtype;
    }

    
     public void remove(ActionEvent actionEvent){
         try {
                   inputTypeFacade.remove(selecttype);
             /*start mohammed.ayad*/
             Messages.addInfoMessage("removed "+selecttype.getType(),1,4);
             /*end mohammed.ayad*/
         } catch (Exception e) {
             /*start mohammed.ayad*/
              Messages.addInfoMessage("Not removed "+selecttype.getType()+" return to Admin",3,4);
              /*end mohammed.ayad*/
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          type=((InputType) event.getObject());
            type.setUpdateDate(date);
          inputTypeFacade.edit(type);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((InputType) event.getObject()).getType(),1,4);
          /*end mohammed.ayad*/
    }
     
    public void onRowCancel(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((InputType) event.getObject()).getType(),1,4);
          /*end mohammed.ayad*/
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
         
        if(inputTypeFacade.input_find(type.getType())){
            /*start mohammed.ayad*/
               Messages.addInfoMessage("Duplicated",2,4);
             /*end mohammed.ayad*/
        }else{
            /*start mohammed.ayad*/
             Messages.addInfoMessage("ADDED",1,4);
             /*end mohammed.ayad*/
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            type.setCreateDate(date);
            type.setUpdateDate(date);
          inputTypeFacade.create(type);
        }
         
      return "Login";
     }
       
    
    
}
