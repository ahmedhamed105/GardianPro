/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Component;
import Entities.Groups;
import Entities.Role;
import Entities.RoleHasComponent;
import Entities.RoleHasGroups;
import Facades.GroupsFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasGroupsFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.ibraheem
 */
@Named(value = "RolesOfGroup")
@SessionScoped
public class RolesOfGroup implements Serializable {

    public RolesOfGroup() {
    }

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private GroupsFacadeLocal groupsFacade;

    @EJB
    private RoleHasGroupsFacadeLocal roleHasGroupsFacade;

    List<Role> Roles = new ArrayList<Role>();
    List<RoleHasGroups> roleHasGroupses = new ArrayList<RoleHasGroups>();
    List<Groups> groups = new ArrayList<Groups>();

    Groups selectGroup;
    java.sql.Date date;
    String roleId;
    String groupId;
    RoleHasGroups selectRoleHasGroups;

    public void init(String PageName) {

        try {
            if (Login.login == null /*|| Login.login.getId() == 0*/) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                System.out.println("bbbbbbbbbbbbnullll");
                ec.redirect(ec.getRequestContextPath()
                        + "/faces/login.xhtml");
            } else {

                FacesContext fc = FacesContext.getCurrentInstance();
                Map<String, String> pageParamter = fc.getExternalContext().getRequestParameterMap();
                if (roleId == null) {
                    roleId = pageParamter.get("roleId");
                }
                if (groupId == null) {
                    groupId = pageParamter.get("groupId");
                }

                System.out.println("role_ID v >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + roleId);
                System.out.println("componentId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + groupId);

                Roles = roleFacade.findAll();
                selectGroup = groupsFacade.find(Integer.parseInt(groupId));
                roleHasGroupses = roleHasGroupsFacade.find_role_by_group(selectGroup);
                
                

            }
        } catch (Exception e) {
            e.printStackTrace();
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 12);
            /*end mohammed.ayad*/
        }
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }

    public List<RoleHasGroups> getRoleHasGroupses() {
        return roleHasGroupses;
    }

    public void setRoleHasGroupses(List<RoleHasGroups> roleHasGroupses) {
        this.roleHasGroupses = roleHasGroupses;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Groups getSelectGroup() {
        return selectGroup;
    }

    public void setSelectGroup(Groups selectGroup) {
        this.selectGroup = selectGroup;
    }

    public RoleHasGroups getSelectRoleHasGroups() {
        return selectRoleHasGroups;
    }

    public void setSelectRoleHasGroups(RoleHasGroups selectRoleHasGroups) {
        this.selectRoleHasGroups = selectRoleHasGroups;
    }

    
    
    public void remove(ActionEvent actionEvent){
         try {
                   roleHasGroupsFacade.remove(selectRoleHasGroups);
             Messages.addInfoMessage("removed "+selectRoleHasGroups.getRoleprevilegeID(),1,12);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectRoleHasGroups.getRoleprevilegeID()+" return to Admin "+e.getMessage(),3,12);
         }
     }
    
     public String onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          Groups group_object = groupsFacade.find(Integer.parseInt(groupId));
          Role role_object =((Role) event.getObject());
           RoleHasGroups roleHasGroup = roleHasGroupsFacade.findByGroupRole(group_object, role_object);
           if(roleHasGroup == null)
           {
               roleHasGroup = new RoleHasGroups();
               roleHasGroup.setGroupsGroupid(group_object);
               roleHasGroup.setRoleprevilegeID(role_object);
               roleHasGroup.setCreateDate(date);
               roleHasGroup.setUpdateDate(date);
               
               roleHasGroupsFacade.create(roleHasGroup);
           }
           else 
           {
               roleHasGroup.setUpdateDate(date);
               roleHasGroupsFacade.edit(roleHasGroup);
           }
          return "roleOfGroup.xhtml";
          
    }
     
    public void onRowCancel(RowEditEvent event) {
         
    }
}
