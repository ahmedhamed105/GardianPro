/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.InputType;
import Entities.Parameter;
import Entities.ParameterType;
import Entities.Parts;
import Facades.PartsFacadeLocal;
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
public class Partsbean {

    @EJB
    private PartsFacadeLocal partsFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      
      
       List<Entities.Parts> Parts = new ArrayList<Entities.Parts>();

         Entities.Parts part=new Entities.Parts();
         
         Entities.Parts selectpart=new Entities.Parts();
         
          java.sql.Date date ;

    /**
     * Creates a new instance of Parts
     */
    public Partsbean() {
    }
    
       public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         Parts  = partsFacade.findAll();
        
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

    public List<Entities.Parts> getParts() {
        return Parts;
    }

    public void setParts(List<Entities.Parts> Parts) {
        this.Parts = Parts;
    }

    public Parts getPart() {
        return part;
    }

    public void setPart(Parts part) {
        this.part = part;
    }

    public Parts getSelectpart() {
        return selectpart;
    }

    public void setSelectpart(Parts selectpart) {
        this.selectpart = selectpart;
    }

  
       
          public void remove(ActionEvent actionEvent){
         try {
                   partsFacade.remove(selectpart);
             Messages.addInfoMessage("removed "+selectpart.getPName(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectpart.getPName()+" return to Admin",2);
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          part=((Parts) event.getObject());
            part.setUpdateDate(date);
          partsFacade.edit(part);
          
          Messages.addInfoMessage("Edited "+((Parameter) event.getObject()).getDisplayName(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Parameter) event.getObject()).getDisplayName(),1);
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
         
      if(partsFacade.par_find(part.getPName())){
             Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            part.setCreateDate(date);
            part.setUpdateDate(date);
          partsFacade.create(part);
        }
         
      return "Login";
     }
    
}
