/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ParameterType;
import Entities.Role;
import Facades.RoleFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
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
 * @author ahmed.ibraheem
 */
@Named(value = "rolesBean")
@SessionScoped
public class RolesBean implements Serializable {

    @EJB
    private UserFacadeLocal userFacade;

    
    @EJB
    private RoleFacadeLocal roleFacade;

    /**
     * Creates a new instance of RolesBean
     */
    
    
    
    List<Role> roles = new ArrayList<Role>();
      
      private Role selectRole= new Role();
      
     Role role= new Role();
     
      java.sql.Date date ;
    
    
    public RolesBean() {
    }
    
    
    public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
          roles = roleFacade.findAll();

        }
        
        } catch (Exception e) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
            }
}
   
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(Role selectRole) {
        this.selectRole = selectRole;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public void remove(ActionEvent actionEvent){
         try {
                   roleFacade.remove(selectRole);
             Messages.addInfoMessage("removed "+selectRole.getDescription(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectRole.getDescription()+" return to Admin",2);
         }
     }
    
    public String ADD(ActionEvent actionEvent){
         
        if(roleFacade.Role_find(role.getDescription())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            role.setCreateDate(date);
            role.setUpdateDate(date);
          roleFacade.create(role);
        }
         
      return "Login";
     }
     
     
      public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          role=((Role) event.getObject());
            role.setUpdateDate(date);
          roleFacade.edit(role);
          
          Messages.addInfoMessage("Edited "+((Role) event.getObject()).getDescription(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((Role) event.getObject()).getDescription(),1);
    }
}
