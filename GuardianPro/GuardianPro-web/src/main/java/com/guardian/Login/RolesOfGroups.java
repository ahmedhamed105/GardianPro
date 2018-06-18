/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.GroupHasParameter;
import Entities.Groups;
import Entities.GroupsHasUser;
import Entities.Role;
import Entities.RoleHasGroups;
import Entities.User;
import Facades.GroupsFacadeLocal;
import Facades.GroupsHasUserFacadeLocal;
import Facades.RoleFacadeLocal;
import Facades.RoleHasGroupsFacadeLocal;
import Facades.UserFacadeLocal;
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
 * @author ahmed.elemam
 */
public class RolesOfGroups {

    @EJB
    private GroupsHasUserFacadeLocal groupsHasUserFacade;

    
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
    List<Groups> Groups = new ArrayList<Groups>();
    List<User> Users = new ArrayList<User>();
    Groups selectGroupA;
    User selectuser;
     List<Role> selectRole= new ArrayList<Role>();
    
    
    RoleHasGroups selectGroup;
    
    
    
    java.sql.Date date;
    String roleId;
    String groupId;
    /**
     * Creates a new instance of RolesOfGroups
     */
    public RolesOfGroups() {
    }
    
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
              Groups=groupsFacade.findAll();
                Users=userFacade.findAll();
                  System.out.println("componentId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + Users.size());
            Roles = roleFacade.findAll();
            Groups  GroupA = groupsFacade.find(Integer.parseInt(groupId));
            roleHasGroupses = roleHasGroupsFacade.find_role_by_group(GroupA);
              selectRole= new ArrayList<Role>();
              selectGroupA=new Groups();
              selectuser=new User();
                

            }
        } catch (Exception e) {
            e.printStackTrace();
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 12);
            /*end mohammed.ayad*/
        }
    }

    public List<Role> getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(List<Role> selectRole) {
        this.selectRole = selectRole;
    }

 
    
    

    public List<Groups> getGroups() {
        return Groups;
    }

    public void setGroups(List<Groups> Groups) {
        this.Groups = Groups;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> Users) {
        this.Users = Users;
    }

    public Groups getSelectGroupA() {
        return selectGroupA;
    }

    public void setSelectGroupA(Groups selectGroupA) {
        this.selectGroupA = selectGroupA;
    }

    public User getSelectuser() {
        return selectuser;
    }

    public void setSelectuser(User selectuser) {
        this.selectuser = selectuser;
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



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RoleHasGroups getSelectGroup() {
        return selectGroup;
    }

    public void setSelectGroup(RoleHasGroups selectGroup) {
        this.selectGroup = selectGroup;
    }



   
    
    
    public void remove(ActionEvent actionEvent){
        
         try {
                   roleHasGroupsFacade.remove(selectGroup);
             Messages.addInfoMessage("removed "+selectGroup.getRoleID(),1,12);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectGroup.getRoleID()+" return to Admin "+e.getMessage(),3,12);
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
               roleHasGroup.setGroupsID(group_object);
               roleHasGroup.setRoleID(role_object);
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
    
    
          public String joingroup(ActionEvent actionEvent){
                 date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
              
         for(int i=0;i<selectRole.size();i++){
             RoleHasGroups a=new RoleHasGroups();
            a.setGroupsID(selectGroupA);
            a.setRoleID(selectRole.get(i));
            /*start mohammed.ayad*/
             Messages.addInfoMessage("ADDED",1,7);
             /*start mohammed.ayad*/

            a.setCreateDate(date);
            a.setUpdateDate(date);
          roleHasGroupsFacade.create(a);      
         }
         
              GroupsHasUser b=new GroupsHasUser();
              b.setUserID(selectuser);
              b.setGroupsID(selectGroupA);
              b.setCreateDate(date);
              b.setUpdateDate(date);
              groupsHasUserFacade.create(b);
              
                Groups  GroupA = groupsFacade.find(Integer.parseInt(groupId));
            roleHasGroupses = roleHasGroupsFacade.find_role_by_group(GroupA);
       
         
      return "Login";
     }
    
}
