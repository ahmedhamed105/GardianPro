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
 * @author ahmed.elemam
 */
public class compRole {
    
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
    
    
    RoleHasComponent gocomp;
      
     Role role;
     
    java.sql.Date date ;
    

    public void init(String PageName) {
        
        
        //Login.login = userFacade.find(1);
        try {
            if (Login.login == null /*|| Login.login.getId() == 0*/ ) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                System.out.println("bbbbbbbbbbbbnullll");
                ec.redirect(ec.getRequestContextPath()
                        + "/faces/index.xhtml");

               
                
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
                
                Role roleObj=roleFacade.find(Integer.parseInt(RoleID.trim()));
               //  System.out.println("ahmed"+roleObj.getPrevilegeID());
               //     System.out.println("ahmed"+components.size());
                roleHasComponents = roleHasComponentFacade.find_component_by_role(roleObj);

                
                System.out.println("components List >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+ components.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
             System.out.println("eeeeeeeeeeeeeeee" + e);

             
        }

    }

    public List<RoleHasComponent> getRoleHasComponents() {
        return roleHasComponents;
    }

    public void setRoleHasComponents(List<RoleHasComponent> roleHasComponents) {
        this.roleHasComponents = roleHasComponents;
    }

    public RoleHasComponent getGocomp() {
        return gocomp;
    }

    public void setGocomp(RoleHasComponent gocomp) {
        this.gocomp = gocomp;
    }
    
    

    /**
     * Creates a new instance of compRole
     */
    public compRole() {
    }
    

    
    public String ADD(ActionEvent actionEvent){
         
        if(roleFacade.role_name_find(role.getName())){
            /*start mohammed.ayad*/
               Messages.addInfoMessage("Duplicated",2,2);
               /*end mohammed.ayad*/
        }else{
            /*start mohammed.ayad*/
             Messages.addInfoMessage("ADDED",1,2);
             /*end mohammed.ayad*/
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            role.setCreateDate(date);
            role.setUpdateDate(date);
          roleFacade.create(role);
        }
         
      return "Login";
     }
    
    
    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          RoleHasComponent component =((RoleHasComponent) event.getObject());
                      component.setUpdateDate(date);
                      roleHasComponentFacade.edit(component);  
         Messages.addInfoMessage("Edited "+component.getComponentID().getName(),1,2);
      
          
    }
     
    public void onRowCancel(RowEditEvent event) {
          RoleHasComponent component =((RoleHasComponent) event.getObject());
          Messages.addInfoMessage("cancel "+component.getComponentID().getName(),1,2);
        
    }
    

    
}
