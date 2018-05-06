/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Application;
import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Entities.GroupHasParameter;
import Entities.Parameter;
import Entities.ParameterGroup;
import Facades.ApplicationFacadeLocal;
import Facades.ApplicationGroupFacadeLocal;
import Facades.ApplicationHasGroupFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author ahmed.elemam
 */
public class appgroup {

    @EJB
    private ApplicationHasGroupFacadeLocal applicationHasGroupFacade;

    @EJB
    private ApplicationGroupFacadeLocal applicationGroupFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      @EJB
    private ApplicationFacadeLocal applicationFacade;
      
      
      
      
      
        private TreeNode root;
    
     Entities.ApplicationGroup appGroup= new ApplicationGroup();
     
     List<ApplicationGroup> Apara= new ArrayList<ApplicationGroup>();
     
      List<ApplicationHasGroup> app_group= new ArrayList<ApplicationHasGroup>();
      
      
       List<Application> app= new ArrayList<Application>();
       
        List<Application> selapp= new ArrayList<Application>();
        
        ApplicationGroup selectgroup=new ApplicationGroup();
     
      java.sql.Date date ;
      
      private TreeNode selectdelte;
      

       public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
            selectgroup=new ApplicationGroup();
            selapp= new ArrayList<Application>();
             Apara=applicationGroupFacade.findAll();
             app=applicationFacade.findAll();
     
       root = new DefaultTreeNode(new PGroup_tree("Groups",Apara.size(),0,"root"), null);
      for(int i=0;i<Apara.size();i++){
          try {
              app_group  = applicationHasGroupFacade.get_app_group(Apara.get(i));
              
              System.out.println("group "+Apara.get(i).getGroupname()+app_group.size());
              DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Apara.get(i).getGroupname(),app_group.size(),Apara.get(i).getId(),"GROUP"), root);
         
              for(int j=0;j<app_group.size();j++){
                   System.out.println("para "+app_group.get(j).getApplicationID().getAppName());
             DefaultTreeNode documentss = new DefaultTreeNode(new PGroup_tree(app_group.get(j).getApplicationID().getAppName(),1,app_group.get(j).getId(),"Parameter"), documents);
        
              }
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Apara.get(i).getGroupname(),0,Apara.get(i).getId(),"GROUP"), root);
          }
         
      
      }
      
    
      
      
        }
        
        } catch (Exception e) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
            }
}
   
    }

    public List<ApplicationHasGroup> getApp_group() {
        return app_group;
    }

    public void setApp_group(List<ApplicationHasGroup> app_group) {
        this.app_group = app_group;
    }
       
       
       

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public ApplicationGroup getAppGroup() {
        return appGroup;
    }

    public void setAppGroup(ApplicationGroup appGroup) {
        this.appGroup = appGroup;
    }

    public List<ApplicationGroup> getApara() {
        return Apara;
    }

    public void setApara(List<ApplicationGroup> Apara) {
        this.Apara = Apara;
    }

    public List<Application> getApp() {
        return app;
    }

    public void setApp(List<Application> app) {
        this.app = app;
    }

    public List<Application> getSelapp() {
        return selapp;
    }

    public void setSelapp(List<Application> selapp) {
        this.selapp = selapp;
    }

    public ApplicationGroup getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(ApplicationGroup selectgroup) {
        this.selectgroup = selectgroup;
    }

    public TreeNode getSelectdelte() {
        return selectdelte;
    }

    public void setSelectdelte(TreeNode selectdelte) {
        this.selectdelte = selectdelte;
    }
      
       
       
      

    /**
     * Creates a new instance of appgroup
     */
    public appgroup() {
    }
    
}
