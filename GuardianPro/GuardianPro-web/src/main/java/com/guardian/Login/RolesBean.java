/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.ActionLog;
import Entities.Component;
import Entities.ParameterType;
import Entities.Role;
import Entities.RoleHasComponent;
import Facades.ActionLogFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasComponentFacadeLocal;
import Facades.UserFacadeLocal;
import com.guardian.util.ActionlogingUtil;
import com.tutorialspoint.interceptor.LibraryBeanRemote;
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
public class RolesBean implements Serializable {

    @EJB
    private RoleHasComponentFacadeLocal roleHasComponentFacade;

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private LibraryBeanRemote liberaryBean;

    @EJB
    ActionLogFacadeLocal actionLoging;

    List<ActionLog> actionlogs = new ArrayList<ActionLog>();

    List<Role> Roles = new ArrayList<Role>();
    List<RoleHasComponent> roleHasComponents = new ArrayList<RoleHasComponent>();
    List<Component> components = new ArrayList<Component>();

    private Role selectRole;

    Role role;

    java.sql.Date date;

    public RolesBean() {
        role = new Role();
        selectRole = new Role();
    }

    public void init(String pagename) {

        Login.login = userFacade.find(1);
        try {
            if (Login.login == null || Login.login.getId() == 0) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                ec.redirect(ec.getRequestContextPath()
                        + "/faces/login.xhtml");

            } else {
                Roles = roleFacade.findAll();
                actionlogs = actionLoging.getListofLogs(Login.login, pagename);
               // System.out.println(Roles.get(0).getDescription());
            }

        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 11);
            /*end mohammed.ayad*/
           
           // e.printStackTrace();
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");
            } catch (IOException ex) {
                // Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 11);
                /*end mohammed.ayad*/
            }
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

    public void remove(ActionEvent actionEvent) {
        try {
            roleFacade.remove(selectRole);
            Messages.addInfoMessage("removed " + selectRole.getDescription(), 1,11);
        } catch (Exception e) {
            Messages.addInfoMessage("Not removed " + selectRole.getDescription() + " return to Admin "+e.getMessage(), 3,11);
        }
    }

    public String ADD(ActionEvent actionEvent) {

        if (roleFacade.role_name_find(role.getName())) {
            Messages.addInfoMessage("Duplicated", 2,11);
        } else {
            Messages.addInfoMessage("ADDED", 1,11);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            role.setCreateDate(date);
            role.setUpdateDate(date);
            roleFacade.create(role);
            actionLoging.create(  ActionlogingUtil.addToLogging("Roles.xhtml", Login.login, "Role has been added sucessfully"+ role.getDescription()) );
        }

        return "Login";
    }

    public void onRowEdit(RowEditEvent event) {
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        role = ((Role) event.getObject());
        role.setUpdateDate(date);
        roleFacade.edit(role);
        roleHasComponents = roleHasComponentFacade.find_component_by_role(role);

        Messages.addInfoMessage("Edited " + ((Role) event.getObject()).getDescription(), 1,11);
    }

    public void onRowCancel(RowEditEvent event) {
        Messages.addInfoMessage("Cancelled " + ((Role) event.getObject()).getDescription(), 1,11);
    }

    public void setActionlogs(List<ActionLog> actionlogs) {
        this.actionlogs = actionlogs;
    }

    public List<ActionLog> getActionlogs() {
        return actionlogs;
    }
}
