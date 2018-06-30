/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

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
    
        public void init(){ FacesContext facesContext = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
if(session==null){
                 try {
                     Login.login=null;
                     ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                     
                     ec.redirect(ec.getRequestContextPath()
                             + "/faces/index.xhtml");
                 } catch (IOException ex) {
                     Logger.getLogger(accessgroup.class.getName()).log(Level.SEVERE, null, ex);
                 }
}
             //Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
         Parts  = partsFacade.findAll();
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 8);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 8);
                /*end mohammed.ayad*/
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
                   /*start mohammed.ayad*/
             Messages.addInfoMessage("removed "+selectpart.getPName(),1,8);
             /*end mohammed.ayad*/
         } catch (Exception e) {
             /*start mohammed.ayad*/
              Messages.addInfoMessage("Not removed "+selectpart.getPName()+" return to Admin "+e.getMessage(),3,8);
              /*end mohammed.ayad*/
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          part=((Parts) event.getObject());
            part.setUpdateDate(date);
          partsFacade.edit(part);
          /*start mohammed.ayad*/
          Messages.addInfoMessage("Edited "+((Parts) event.getObject()).getPName(),1,8);
          /*end mohammed.ayad*/
    }
     
    public void onRowCancel(RowEditEvent event) {
        /*start mohammed.ayad*/
          Messages.addInfoMessage("Cancelled "+((Parts) event.getObject()).getPName(),1,8);
          /*end mohammed.ayad*/
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
         
      if(partsFacade.par_find(part.getPName())){
          /*start mohammed.ayad*/
             Messages.addInfoMessage("Duplicated",2,8);
             /*end mohammed.ayad*/
        }else{
          /*start mohammed.ayad*/
             Messages.addInfoMessage("ADDED",1,8);
             /*end mohammed.ayad*/
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            part.setCreateDate(date);
            part.setUpdateDate(date);
          partsFacade.create(part);
        }
         
      return "Login";
     }
    
}
