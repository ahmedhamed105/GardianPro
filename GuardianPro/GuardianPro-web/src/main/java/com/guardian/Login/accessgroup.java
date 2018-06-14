/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Accessory;
import Entities.AccessoryGroup;
import Entities.AccessoryHasGroup;
import Entities.Application;
import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Facades.AccessoryFacadeLocal;
import Facades.AccessoryGroupFacadeLocal;
import Facades.AccessoryHasGroupFacadeLocal;
import Facades.UserFacadeLocal;
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
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author ahmed.elemam
 */
public class accessgroup {

    @EJB
    private AccessoryHasGroupFacadeLocal accessoryHasGroupFacade;

    @EJB
    private AccessoryGroupFacadeLocal accessoryGroupFacade;

    @EJB
    private AccessoryFacadeLocal accessoryFacade;
    
     @EJB
    private UserFacadeLocal userFacade;
     
      private TreeNode root;
    
     Entities.AccessoryGroup appGroup= new AccessoryGroup();
     
     List<AccessoryGroup> Apara= new ArrayList<AccessoryGroup>();
     
      List<Entities.AccessoryHasGroup> app_group= new ArrayList<AccessoryHasGroup>();
      
      
       List<Entities.Accessory> app= new ArrayList<Accessory>();
       
        List<Accessory> selapp= new ArrayList<Accessory>();
        
        AccessoryGroup selectgroup=new AccessoryGroup();
     
      java.sql.Date date ;
      
      private TreeNode selectdelte;
      
      
     

    /**
     * Creates a new instance of accessgroup
     */
    public accessgroup() {
    }
    
     public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
            selectgroup=new AccessoryGroup();
            selapp= new ArrayList<Accessory>();
             Apara=accessoryGroupFacade.findAll();
             app=accessoryFacade.findAll();
     
       root = new DefaultTreeNode(new PGroup_tree("Groups",Apara.size(),0,"root"), null);
      for(int i=0;i<Apara.size();i++){
          try {
              app_group  = accessoryHasGroupFacade.get_app_group(Apara.get(i));
              
              System.out.println("group "+Apara.get(i).getGroupname()+app_group.size());
              DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Apara.get(i).getGroupname(),app_group.size(),Apara.get(i).getId(),"GROUP"), root);
         
              for(int j=0;j<app_group.size();j++){
                   System.out.println("para "+app_group.get(j).getAccessoryID().getAccName());
             DefaultTreeNode documentss = new DefaultTreeNode(new PGroup_tree(app_group.get(j).getAccessoryID().getAccName(),1,app_group.get(j).getId(),"Accessory"), documents);
        
              }
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Apara.get(i).getGroupname(),0,Apara.get(i).getId(),"GROUP"), root);
                 /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 16);
                /*end mohammed.ayad*/
          }
         
      
      }
      
    
      
      
        }
        
        } catch (Exception e) {
            Messages.addInfoMessage(e.getMessage(), 3, 16);
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                Messages.addInfoMessage(ex.getMessage(), 3, 16);
            }
}
   
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

     
     
    public AccessoryGroup getAppGroup() {
        return appGroup;
    }

    public void setAppGroup(AccessoryGroup appGroup) {
        this.appGroup = appGroup;
    }

    public List<AccessoryGroup> getApara() {
        return Apara;
    }

    public void setApara(List<AccessoryGroup> Apara) {
        this.Apara = Apara;
    }

    public List<AccessoryHasGroup> getApp_group() {
        return app_group;
    }

    public void setApp_group(List<AccessoryHasGroup> app_group) {
        this.app_group = app_group;
    }

    public List<Accessory> getApp() {
        return app;
    }

    public void setApp(List<Accessory> app) {
        this.app = app;
    }

    public List<Accessory> getSelapp() {
        return selapp;
    }

    public void setSelapp(List<Accessory> selapp) {
        this.selapp = selapp;
    }

    public AccessoryGroup getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(AccessoryGroup selectgroup) {
        this.selectgroup = selectgroup;
    }

    public TreeNode getSelectdelte() {
        return selectdelte;
    }

    public void setSelectdelte(TreeNode selectdelte) {
        this.selectdelte = selectdelte;
    }
     
     
     
        public String ADD(ActionEvent actionEvent){
         
      if(accessoryGroupFacade.Pgroup_find(appGroup.getGroupname())){
              Messages.addInfoMessage("Duplicated",2,16);
     }else{
             Messages.addInfoMessage("ADDED",1,16);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            appGroup.setUserID(Login.login);
            appGroup.setCreateDate(date);
            appGroup.setUpdateDate(date);
          accessoryGroupFacade.create(appGroup);
          
       }
      
        Apara=accessoryGroupFacade.findAll();
             app=accessoryFacade.findAll();
         
      return "Login";
     }
      
      
      
         public String joingroup(ActionEvent actionEvent){
         for(int i=0;i<selapp.size();i++){
             AccessoryHasGroup a=new AccessoryHasGroup();
            a.setAccessoryGroupID(selectgroup);
             Messages.addInfoMessage("ADDED",1,16);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            a.setCreateDate(date);
            a.setUpdateDate(date);
            a.setAccessoryID(selapp.get(i));
          accessoryHasGroupFacade.create(a);
         }
               Apara=accessoryGroupFacade.findAll();
             app=accessoryFacade.findAll();
         
      return "Login";
     }
         
         
         
         
         
         public void removeGroup(ActionEvent actionEvent){
      if(((PGroup_tree)selectdelte.getData()).getType().toUpperCase().equals("GROUP")){
          try {
              AccessoryGroup a=   accessoryGroupFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                    List<AccessoryHasGroup> b=  accessoryHasGroupFacade.get_app_group(a);
                        for (AccessoryHasGroup accessoryHasGroup : b) {
                            try {
                            accessoryHasGroupFacade.remove(accessoryHasGroup);
                            Messages.addInfoMessage("removed "+accessoryHasGroup.getAccessoryID().getAccName()+" from "+accessoryHasGroup.getAccessoryGroupID().getGroupname(),1,16);
       
                            } catch (Exception e) {
                                  Messages.addInfoMessage("NO app Linked "+e.getMessage(),3,16);
                            }
                
                        //    Messages.addInfoMessage("all para"+groupHasParameter.getId()+" group  removed",1);
                        } 
                        
                        accessoryGroupFacade.remove(a);
                          Messages.addInfoMessage("removed "+a.getGroupname(),1,16);
       
                           
                        
          } catch (Exception e) {
               Messages.addInfoMessage("Problem in system "+e.getMessage(),3,16);
          }
                    
                   
                    }
    
}
       
       
public void remove(ActionEvent actionEvent){
                    
                    if(((PGroup_tree)selectdelte.getData()).getType().toUpperCase().equals("GROUP")){
                        try{
                     AccessoryGroup a=   accessoryGroupFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                    List<AccessoryHasGroup> b=  accessoryHasGroupFacade.get_app_group(a);
                        for (AccessoryHasGroup accessoryHasGroup : b) {
                            
                       accessoryHasGroupFacade.remove(accessoryHasGroup);
                     Messages.addInfoMessage("removed "+accessoryHasGroup.getAccessoryID().getAccName()+" from "+accessoryHasGroup.getAccessoryGroupID().getGroupname(),1,16);
    
                        //    Messages.addInfoMessage("all para"+groupHasParameter.getId()+" group  removed",1);
                        }
                           } catch (Exception e) {
               Messages.addInfoMessage("Problem in system "+e.getMessage(),3,16);
          }
                   
                    }else{
                           try {
                  
                 AccessoryHasGroup a=accessoryHasGroupFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                               
                   accessoryHasGroupFacade.remove(a);
             Messages.addInfoMessage("removed "+a.getAccessoryID().getAccName()+" from "+a.getAccessoryGroupID().getGroupname(),1,16);
         } catch (Exception e) {
                 Messages.addInfoMessage("not removed "+e.getMessage(),3,16);
    }
                    }
  
         
     
     }
    
    
}
