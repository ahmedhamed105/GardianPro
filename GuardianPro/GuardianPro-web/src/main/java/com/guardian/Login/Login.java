/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Component;
import Entities.Groups;
import Entities.GroupsHasUser;
import Entities.Role;
import Entities.RoleHasComponent;
import Entities.RoleHasGroups;
import Entities.User;
import Facades.ComponentFacadeLocal;
import Facades.GroupsFacadeLocal;
import Facades.GroupsHasUserFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasComponentFacadeLocal;
import Facades.RoleHasGroupsFacadeLocal;
import Facades.UserFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ahmed.elemam
 */
@ManagedBean
@SessionScoped
public class Login {

    @EJB
    private RoleHasComponentFacadeLocal roleHasComponentFacade;

    @EJB
    private RoleHasGroupsFacadeLocal roleHasGroupsFacade;

    @EJB
    private GroupsHasUserFacadeLocal groupsHasUserFacade;

    @EJB
    private ComponentFacadeLocal componentFacade;

    @EJB
    private RoleFacadeLocal roleFacade;

    @EJB
    private GroupsFacadeLocal groupsFacade;

    @EJB
    private UserFacadeLocal userFacade;

    List<Groups> groups = new ArrayList<Groups>();
    List<GroupsHasUser> groupsHasUsers = new ArrayList<GroupsHasUser>();
    List<Role> Roles = new ArrayList<Role>();
    List<Component> components = new ArrayList<Component>();
    List<RoleHasGroups> roleHasGroupses = new ArrayList<RoleHasGroups>();
    List<RoleHasComponent> roleHasComponents = new ArrayList<RoleHasComponent>();

    boolean remeber;
    String username;
    String password;
    static User login = new User();

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public User getLogin() {
        return login;
    }

    public void setLogin(User login) {
        Login.login = login;
    }

    public boolean isRemeber() {
        return remeber;
    }

    public void setRemeber(boolean remeber) {
        this.remeber = remeber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String Login_submit(ActionEvent actionEvent) {

        try {
            User u1 = userFacade.search_username(username).get(0);
            if (u1.getUserPasswordID().getPassword().equals(password)) {
                switch (userFacade.user_status(u1)) {
                    case 1:
                        Messages.addInfoMessage("Login ok!!", 1);
                        login = u1;

                        //ahmed.ibraheem
                        // Load All Rolls
                        groupsHasUsers = groupsHasUserFacade.find_groups_by_user(u1);
                        if (groupsHasUsers != null) {

                            for (GroupsHasUser groupsHasUser : groupsHasUsers) {

                                groups.add((Groups) groupsFacade.find(groupsHasUser.getGroupsGroupid()));
                            }
                        }
                        if (groups != null) {
                            for (Groups group : groups) {
                                if (group != null) {
                                    roleHasGroupses.add((RoleHasGroups) roleHasGroupsFacade.find_role_by_group(group));
                                }
                            }
                        }

                        if (roleHasGroupses != null) {
                            for (RoleHasGroups rhg : roleHasGroupses) {
                                if (rhg != null) {
                                    Roles.add(roleFacade.find(rhg.getRoleprevilegeID()));
                                }
                            }
                        }

                        if (Roles != null) {
                            for (Role role : Roles) {
                                if (role != null) {
                                    roleHasComponents.add((RoleHasComponent) roleHasComponentFacade.find_component_by_role(role));
                                }
                            }
                        }

                        if (roleHasGroupses != null) {
                            for (RoleHasComponent rhc : roleHasComponents) {
                                components.add(componentFacade.find(rhc.getComponentcomponentID()));
                            }
                        }

                        //ahmed.ibraheem
                        // Load All Rolls
                        return "Login";
                    case 2:
                        Messages.addInfoMessage("Login Error User Closed !!", 2);
                        return "Error";
                    case 3:
                        Messages.addInfoMessage("Login Error User Locked !!", 2);
                        return "Error";
                    case 4:
                        Messages.addInfoMessage("Login Error User not Have Email Activation !!", 2);
                        return "Error";
                    default:
                        Messages.addInfoMessage("Login Error Check status !!", 2);
                        return "Error";
                }

            } else {
                Messages.addInfoMessage("Login Error Wrong password!!", 2);
                return "Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addInfoMessage("Login Error!!", 2);
            return "Error";
        }

    }

}
