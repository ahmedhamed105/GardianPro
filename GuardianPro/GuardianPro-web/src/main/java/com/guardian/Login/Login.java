/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;
import javax.servlet.http.HttpSession;

import Entities.Component;
import Entities.Groups;
import Entities.GroupsHasUser;
import Entities.Role;
import Entities.RoleHasComponent;
import Entities.RoleHasGroups;
import Entities.User;
import Entities.UserStatus;
import Facades.ComponentFacadeLocal;
import Facades.ConfigParmeterFacadeLocal;
import Facades.GroupsFacadeLocal;
import Facades.GroupsHasUserFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasComponentFacadeLocal;
import Facades.RoleHasGroupsFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
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
    private ConfigParmeterFacadeLocal configParmeterFacade;

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
    List<Component> allComponent = new ArrayList<Component>();
    Map<Component, Boolean> componentView = new HashMap<Component, Boolean>();
    Map<Component, Boolean> componentEdit = new HashMap<Component, Boolean>();
    List<Integer> componentID = new ArrayList<Integer>();

    boolean remeber;
    String username;
    String password;
    static User login = null;

    static String smtp_host = "smtp.gmail.com"; //SMTP Server
    static String smtp_from = "spectra.test.v1@gmail.com";//from account
    static String smtp_password = "P@ssw0rdspectra";     //password from account
    static String smtp_to = "spectra.test.v1@gmail.com";//recipient account
    static String smtp_port = "587";//recipient account
    static int smtp_TLS = 1;//recipient account
    static String FTP_server = "localhost";
    static String FTP_port = "21";
    static String FTP_user = "spectra";
    static String FTP_pass = "123456";
    static String FTP_APP_DIR = "\\APPLICATION\\";

    /**
     * Creates a new instance of Login
     */
    public Login() {
 //       loadViewEdit();
    }
    
     public void init(){
           Login.login = null;
             
             

FacesContext facesContext = FacesContext.getCurrentInstance();
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
    
    public String logout(ActionEvent actionEvent) {
    login=null;
    return "index.xhtml";
    }

    public String Login_submit(ActionEvent actionEvent) {

          login = null;
        try {
            User u1 = userFacade.search_username(username).get(0);

            String decrypted = Encryption.encrypt(password);
            if (u1.getUserPasswordID().getPassword().equals(decrypted)) {
                
                int a=userFacade.user_status(u1);
                
                System.out.println("com.guardian.Login.Login.Login_submit() "+a);
                
                switch (a) {
                    case 1:
                        
                          login = u1;
                        /*start mohammed.ayad*/
                        Messages.addInfoMessage("Login ok!!", 1, 5);
                        /*end mohammed.ayad*/
                      


                        smtp_host = configParmeterFacade.getparameter("smtp_host").getPValue(); //SMTP Server
                        smtp_from = configParmeterFacade.getparameter("smtp_from").getPValue();//from account
                        smtp_password = configParmeterFacade.getparameter("smtp_password").getPValue();     //password from account
                        smtp_to = configParmeterFacade.getparameter("smtp_to").getPValue();//recipient account
                        smtp_port = configParmeterFacade.getparameter("smtp_port").getPValue();//recipient account
                        smtp_TLS = Integer.parseInt(configParmeterFacade.getparameter("smtp_TLS").getPValue());//recipient account
                        FTP_server = configParmeterFacade.getparameter("FTP_server").getPValue();
                        FTP_port = configParmeterFacade.getparameter("FTP_port").getPValue();
                        FTP_user = configParmeterFacade.getparameter("FTP_user").getPValue();
                        FTP_pass = configParmeterFacade.getparameter("FTP_pass").getPValue();
                        FTP_APP_DIR = configParmeterFacade.getparameter("FTP_APP_DIR").getPValue();


                        
                smtp_host=configParmeterFacade.getparameter("smtp_host").getPValue(); //SMTP Server
                if(configParmeterFacade.getparameter("smtp_host").getEncryption()==1){
                smtp_host=Encryption.decrypt(configParmeterFacade.getparameter("smtp_host").getPValue());
                }
		smtp_from=configParmeterFacade.getparameter("smtp_from").getPValue();//from account
                   if(configParmeterFacade.getparameter("smtp_from").getEncryption()==1){
                smtp_from=Encryption.decrypt(configParmeterFacade.getparameter("smtp_from").getPValue());
                }
		smtp_password=configParmeterFacade.getparameter("smtp_password").getPValue();     //password from account
		   if(configParmeterFacade.getparameter("smtp_password").getEncryption()==1){
                smtp_password=Encryption.decrypt(configParmeterFacade.getparameter("smtp_password").getPValue());
                }
                smtp_to=configParmeterFacade.getparameter("smtp_to").getPValue();//recipient account
                  if(configParmeterFacade.getparameter("smtp_to").getEncryption()==1){
                smtp_to=Encryption.decrypt(configParmeterFacade.getparameter("smtp_to").getPValue());
                }
                smtp_port=configParmeterFacade.getparameter("smtp_port").getPValue();//recipient account
                  if(configParmeterFacade.getparameter("smtp_port").getEncryption()==1){
                smtp_port=Encryption.decrypt(configParmeterFacade.getparameter("smtp_port").getPValue());
                } 
                smtp_TLS=Integer.parseInt(configParmeterFacade.getparameter("smtp_TLS").getPValue());//recipient account
                   if(configParmeterFacade.getparameter("smtp_TLS").getEncryption()==1){
                smtp_TLS=Integer.parseInt(Encryption.decrypt(configParmeterFacade.getparameter("smtp_TLS").getPValue()));
                }
                FTP_server = configParmeterFacade.getparameter("FTP_server").getPValue();
                  if(configParmeterFacade.getparameter("FTP_server").getEncryption()==1){
                FTP_server=Encryption.decrypt(configParmeterFacade.getparameter("FTP_server").getPValue());
                }
                FTP_port = configParmeterFacade.getparameter("FTP_port").getPValue();
                   if(configParmeterFacade.getparameter("FTP_port").getEncryption()==1){
                FTP_port=Encryption.decrypt(configParmeterFacade.getparameter("FTP_port").getPValue());
                }
                FTP_user = configParmeterFacade.getparameter("FTP_user").getPValue();
                   if(configParmeterFacade.getparameter("FTP_user").getEncryption()==1){
                FTP_user=Encryption.decrypt(configParmeterFacade.getparameter("FTP_user").getPValue());
                }
                FTP_pass = configParmeterFacade.getparameter("FTP_pass").getPValue();  
                  if(configParmeterFacade.getparameter("FTP_pass").getEncryption()==1){
                FTP_pass=Encryption.decrypt(configParmeterFacade.getparameter("FTP_pass").getPValue());
                }
                FTP_APP_DIR = configParmeterFacade.getparameter("FTP_APP_DIR").getPValue(); 
                         if(configParmeterFacade.getparameter("FTP_APP_DIR").getEncryption()==1){
                FTP_APP_DIR=Encryption.decrypt(configParmeterFacade.getparameter("FTP_APP_DIR").getPValue());
                }
                        //ahmed.ibraheem
                        // Load All Rolls
                        groupsHasUsers = groupsHasUserFacade.find_groups_by_user(u1);
                        if (groupsHasUsers != null) {

                            for (GroupsHasUser groupsHasUser : groupsHasUsers) {

                                groups.add(groupsHasUser.getGroupsID());
                            }
                        }
                        if (groups != null) {
                            for (Groups group : groups) {
                                if (group != null) {
                                    roleHasGroupses.addAll((List<RoleHasGroups>) roleHasGroupsFacade.find_role_by_group(group));
                                }
                            }
                        }

                        if (roleHasGroupses != null) {
                            for (RoleHasGroups rhg : roleHasGroupses) {
                                if (rhg != null) {
                                    Roles.add(rhg.getRoleID());
                                }
                            }
                        }

                        if (Roles != null) {
                            for (Role role : Roles) {
                                if (role != null) {
                                    roleHasComponents.addAll((List<RoleHasComponent>) roleHasComponentFacade.find_component_by_role(role));
                                }
                            }
                        }

                        if (roleHasGroupses != null) {
                            for (RoleHasComponent rhc : roleHasComponents) {
                                components.add(rhc.getComponentID());
                            }
                        }

                        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                        Map<String, Object> sessionMap = externalContext.getSessionMap();
                        if (Roles != null) {
                            sessionMap.put("RolesMap", Roles);
                        }
                        if (components != null) {
                            sessionMap.put("roleHasComponentMap", roleHasComponents);
                        }
                        if (groups != null) {
                            sessionMap.put("GroupsMap", groups);
                        }

                        loadViewEdit();
                        //ahmed.ibraheem
                        // Load All Rolls
                        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                        ec.redirect(ec.getRequestContextPath()
                                + "/faces/Main.xhtml");
                       return "login";
                    case 2:
                        login = null;
                        /*start mohammed.ayad*/
                        Messages.addInfoMessage("Login Error User Closed !!", 2, 5);
                        /*end mohammed.ayad*/             
                    case 3:
                          login = null;
                        /*start mohammed.ayad*/
                        Messages.addInfoMessage("Login Error User Locked !!", 2, 5);
                        /*end mohammed.ayad*/
                       
                    case 4:
                          login = null;
                        /*start mohammed.ayad*/
                        Messages.addInfoMessage("Login Error User not Have Email Activation !!", 2, 5);
                        /*end mohammed.ayad*/
                      
                    default:
                          login = null;
                        /*start mohammed.ayad*/
                        Messages.addInfoMessage("Login Error Check status !!", 2, 5);
                        /*end mohammed.ayad*/
                    
                }

            } else {
                  login = null;
                /*start mohammed.ayad*/
                Messages.addInfoMessage("Login Error Wrong password!!", 2, 5);
                /*end mohammed.ayad*/
               
            }
        } catch (Exception e) {
              login = null;
            e.printStackTrace();
            /*start mohammed.ayad*/
            Messages.addInfoMessage("Login Error!! User Not Exist", 3, 5);
            /*end mohammed.ayad*/
     
        }
        
            ExternalContext ec1 = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec1.redirect(ec1.getRequestContextPath()+ "/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                       return "login";

    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

    public List<GroupsHasUser> getGroupsHasUsers() {
        return groupsHasUsers;
    }

    public void setGroupsHasUsers(List<GroupsHasUser> groupsHasUsers) {
        this.groupsHasUsers = groupsHasUsers;
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<RoleHasGroups> getRoleHasGroupses() {
        return roleHasGroupses;
    }

    public void setRoleHasGroupses(List<RoleHasGroups> roleHasGroupses) {
        this.roleHasGroupses = roleHasGroupses;
    }

    public List<RoleHasComponent> getRoleHasComponents() {
        return roleHasComponents;
    }

    public void setRoleHasComponents(List<RoleHasComponent> roleHasComponents) {
        this.roleHasComponents = roleHasComponents;
    }

    public List<Component> getAllComponent() {
        return allComponent;
    }

    public void setAllComponent(List<Component> allComponent) {
        this.allComponent = allComponent;
    }

    public Map<Component, Boolean> getComponentView() {
        return componentView;
    }

    public void setComponentView(Map<Component, Boolean> componentView) {
        this.componentView = componentView;
    }

    public Map<Component, Boolean> getComponentEdit() {
        return componentEdit;
    }

    public void setComponentEdit(Map<Component, Boolean> componentEdit) {
        this.componentEdit = componentEdit;
    }

    public void loadViewEdit() {
       allComponent = new ArrayList<Component>();
        System.out.println("com.guardian.Login.Login.loadViewEdit() "+componentFacade.find(64));
        allComponent = componentFacade.findAll();
        
         
        for (Component component : allComponent) {
            componentView.put(component, false);
            componentEdit.put(component, true);

            for (RoleHasComponent comPriv : roleHasComponents) {
                if (component.equals(comPriv.getComponentID())) {
                    if (comPriv.getView() == true) {
                        componentView.replace(component, true);
                    }

                    if (comPriv.getEdit() == true) {
                        componentEdit.replace(component, false);
                    }
                }
            }
        }
        //return allComponent;
    }

    public boolean isViewed(String componentName) {
     //List<Component>  allComponent1= loadViewEdit();
        Component component = null;
        for (Component com : allComponent) {
            if (com.getName().equalsIgnoreCase(componentName)) {
                component = com;
            }
        }
        if (component != null) {
            return componentView.get(component);
        } else {
            return false;
        }
    }

    public boolean isEdit(String componentName) {
     //   loadViewEdit();
        Component component = null;
        for (Component com : allComponent) {
            if (com.getName().equalsIgnoreCase(componentName)) {
                component = com;
            }
        }
        if (component != null) {
            return componentEdit.get(component);
        } else {
            return true;
        }
    }
    
    


public void activeListener() {
        try {
            login=null;
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
}

}
