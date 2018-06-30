/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.ParameterType;
import Facades.ParameterTypeFacadeLocal;
import Facades.UserFacadeLocal;
import com.tutorialspoint.interceptor.LibraryBeanRemote;
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
public class parmetertype {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private ParameterTypeFacadeLocal parameterTypeFacade;
    
    @EJB
    private LibraryBeanRemote liberaryBean;
    
      List<ParameterType> parmeter_types = new ArrayList<ParameterType>();
      
      private ParameterType selectparmeter= new ParameterType();
      
     ParameterType para= new ParameterType();
     
      java.sql.Date date ;
    

    /**
     * Creates a new instance of parmeter
     */
    public parmetertype() {
   
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
        liberaryBean.addBook("aaa");
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
          parmeter_types = parameterTypeFacade.findAll();

        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 22);
                /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 22);
                /*end mohammed.ayad*/
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

    

    public ParameterType getSelectparmeter() {
        return selectparmeter;
    }

    public void setSelectparmeter(ParameterType selectparmeter) {
        this.selectparmeter = selectparmeter;
    }
    
    
     public void remove(ActionEvent actionEvent){
         try {
                   parameterTypeFacade.remove(selectparmeter);
             Messages.addInfoMessage("removed "+selectparmeter.getType(),1,22);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectparmeter.getType()+" return to Admin "+e.getMessage(),3,22);
         }
         
     
     }
   
    
    
     public String ADD(ActionEvent actionEvent){
         
        if(parameterTypeFacade.Paremter_find(para.getType())){
               Messages.addInfoMessage("Duplicated",2,22);
        }else{
             Messages.addInfoMessage("ADDED",1,22);
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
          
          Messages.addInfoMessage("Edited "+((ParameterType) event.getObject()).getType(),1,22);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ParameterType) event.getObject()).getType(),1,22);
    }
    
}
