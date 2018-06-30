/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.Component;
import Entities.Groups;
import Entities.Role;
import Entities.RoleHasComponent;
import Entities.RoleHasGroups;
import Facades.GroupsFacadeLocal;
import Facades.GroupsHasUserFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasGroupsFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class groups implements Serializable {

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private RoleHasGroupsFacadeLocal roleHasGroupsFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private GroupsFacadeLocal groupsFacadeLocal;
    
    @EJB
    private GroupsHasUserFacadeLocal groupsHasUserFacade;
    
    

    List<Groups> groups = new ArrayList<Groups>();
    java.sql.Date date;
    List<Groups> filterdGroups = new ArrayList<Groups>();
    Groups group = new Groups();
    Groups selectGroup = new Groups();

    List<RoleHasComponent> enabledComponents = new ArrayList<RoleHasComponent>();
    Map<RoleHasComponent, String> componentView = new HashMap<RoleHasComponent,String>();
    Map<RoleHasComponent, String> componentEdit = new HashMap<RoleHasComponent,String>();
    List<RoleHasGroups> roleHasGroupses = new ArrayList<RoleHasGroups>();
    List<Role> roles= new ArrayList<Role>();

    public groups() {
    }

    public void init() {
        System.out.println("com.guardian.Login.Groups1.init()");
        //Login.login = userFacade.find(1);
        
        System.out.println("com.guardian.Login.Groups1.init()");
        try {
            if (Login.login == null || Login.login.getId() == 0) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                ec.redirect(ec.getRequestContextPath()
                        + "/faces/index.xhtml");

               
                
            } else {
                groups = groupsFacadeLocal.findAll();

//                System.out.println(groups.get(0).getDescription());
            }

        } catch (Exception e) {
            e.printStackTrace();
            /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 20);
                /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 20);
                /*end mohammed.ayad*/
            }
        }

    }

    public UserFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public GroupsFacadeLocal getGroupsFacadeLocal() {
        return groupsFacadeLocal;
    }

    public void setGroupsFacadeLocal(GroupsFacadeLocal groupsFacadeLocal) {
        this.groupsFacadeLocal = groupsFacadeLocal;
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

    public List<Groups> getFilterdGroups() {
        return filterdGroups;
    }

    public void setFilterdGroups(List<Groups> filterdGroups) {
        this.filterdGroups = filterdGroups;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Groups getSelectGroup() {
        return selectGroup;
    }

    public void setSelectGroup(Groups selectGroup) {
        this.selectGroup = selectGroup;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    
    public void remove(ActionEvent actionEvent) {
        
        
        try {
            
            groupsFacadeLocal.remove(selectGroup);
            Messages.addInfoMessage("removed " + selectGroup.getDescription(), 1,20);
        } catch (Exception e) {
            Messages.addInfoMessage("Not removed " + selectGroup.getDescription() + " return to Admin "+e.getMessage(), 3,20);
        }
    }

    public void onRowEdit(RowEditEvent event) {
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        group = ((Groups) event.getObject());
        group.setUpdateDate(date);
        
    
      
        groupsFacadeLocal.edit(group);

        Messages.addInfoMessage("Edited " + ((Groups) event.getObject()).getName(), 1,20);
    }

    public void onRowCancel(RowEditEvent event) {
        Messages.addInfoMessage("Cancelled " + ((Groups) event.getObject()).getName(), 1,20);
    }

    public String ADD(ActionEvent actionEvent) {

        if (groupsFacadeLocal.input_find(group.getDescription())) {
            Messages.addInfoMessage("Duplicated", 2,20);
        } else {
            Messages.addInfoMessage("ADDED", 1,20);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            group.setCreateDate(date);
            group.setUpdateDate(date);
            groupsFacadeLocal.create(group);
        }

        return "Login";
    }
    
    
    
}
