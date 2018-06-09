/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Component;
import Entities.Role;
import Entities.RoleHasComponent;
import Facades.ComponentFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasComponentFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.ibraheem
 */
@Named(value = "componentsOfRole")
@SessionScoped
public class ComponentsOfRole implements Serializable {

   
    public ComponentsOfRole() {
    }
    
     @EJB
    private ComponentFacadeLocal componentFacade;
    
    @EJB
    private RoleHasComponentFacadeLocal roleHasComponentFacade;

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private UserFacadeLocal userFacade;
    
    String componentID ;
    String RoleID ;
    
   
    List<Role> Roles = new ArrayList<Role>();
    List<RoleHasComponent> roleHasComponents = new ArrayList<RoleHasComponent>();
    List<Component> components = new ArrayList<Component>();
    
    
    private Component selectRole;
      
     Role role;
     
    java.sql.Date date ;
    

    public void init(String PageName) {
        
        
        Login.login = userFacade.find(1);
        try {
            if (Login.login == null /*|| Login.login.getId() == 0*/ ) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                System.out.println("bbbbbbbbbbbbnullll");
                ec.redirect(ec.getRequestContextPath()
                        + "/faces/login.xhtml");

               
                
            } else {
                FacesContext fc=FacesContext.getCurrentInstance();
                Map<String,String> pageParamter=fc.getExternalContext().getRequestParameterMap();
                if(RoleID ==null)
                RoleID = pageParamter.get("roleId");
                if(componentID == null)
                componentID=pageParamter.get("componentId");
                
                
                System.out.println("role_ID v >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ RoleID);
                System.out.println("componentId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ componentID);
                
                components = componentFacade.getChild(Integer.parseInt(componentID));
                Role roleObj=new Role();
                RoleHasComponent rolHasCoponentObj ;
                for (Component component : components) {
                    roleObj=roleFacade.find(RoleID);
                    rolHasCoponentObj= roleHasComponentFacade.find_component_by_role_component(roleObj, component);
                    if (Integer.parseInt(rolHasCoponentObj.getEdit()) == 1) {
                        System.out.println("edit");
                        component.setEdit(true);
                    }
                    if (Integer.parseInt(rolHasCoponentObj.getView()) == 1) {
<<<<<<< HEAD
                         System.out.println("view");
=======
>>>>>>> 1a39a2ad8d2aa1daf01013fb7d564ba446a5d7a4
                        component.setView(true);
                    }
                }
                
                
                System.out.println("components List >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ components.size());
            }

        } catch (Exception e) {
             System.out.println("eeeeeeeeeeeeeeee" + e);
//            try {
//                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//
//               // ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");
//            } catch (IOException ex) {
//               // Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }

    public List<RoleHasComponent> getRoleHasComponents() {
        return roleHasComponents;
    }

    public void setRoleHasComponents(List<RoleHasComponent> roleHasComponents) {
        this.roleHasComponents = roleHasComponents;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Component getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(Component selectRole) {
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

    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }
    
    

    public void remove(ActionEvent actionEvent){
         try {
                   //roleHasComponentFacade.remove(selectRole);
             Messages.addInfoMessage("removed "+selectRole.getDescription(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectRole.getDescription()+" return to Admin",2);
         }
     }
    
    public String ADD(ActionEvent actionEvent){
         
        if(roleFacade.role_name_find(role.getName())){
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
    
    
    public String onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          Role role_object = roleFacade.find(Integer.parseInt(RoleID));
          Component component =((Component) event.getObject());
           RoleHasComponent roleHasComponent = roleHasComponentFacade.find_component_by_role_component(role_object, component);
           if(roleHasComponent == null)
           {
               roleHasComponent = new RoleHasComponent();
               roleHasComponent.setComponentcomponentID(component);
               roleHasComponent.setRoleprevilegeID(role_object);
               roleHasComponent.setCreateDate(date);
               roleHasComponent.setUpdateDate(date);
               if(component.isEdit())  roleHasComponent.setEdit("1"); else roleHasComponent.setEdit("0");
               if(component.isView())  roleHasComponent.setView("1");else roleHasComponent.setView("0");
               roleHasComponentFacade.create(roleHasComponent);
           }
           else 
           {
               roleHasComponent.setUpdateDate(date);
               if(component.isEdit())  roleHasComponent.setEdit("1"); else roleHasComponent.setEdit("0");
               if(component.isView())  roleHasComponent.setView("1");else roleHasComponent.setView("0");
               roleHasComponentFacade.edit(roleHasComponent);
           }
          return "CompinentOfRole.xhtml";
          
    }
     
    public void onRowCancel(RowEditEvent event) {
         
    }
    
    public void loadChild(int componentId)
    {
        components = componentFacade.getChild(componentId);
    }
}
