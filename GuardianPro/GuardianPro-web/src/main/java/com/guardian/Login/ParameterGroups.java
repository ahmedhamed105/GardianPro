/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.GroupHasParameter;
import Entities.Parameter;
import Entities.ParameterGroup;
import Facades.GroupHasParameterFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
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
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author ahmed.elemam
 */
public class ParameterGroups {

    @EJB
    private GroupHasParameterFacadeLocal groupHasParameterFacade;

    @EJB
    private ParameterGroupFacadeLocal parameterGroupFacade;
    
    @EJB
    private ParameterFacadeLocal parameterFacade;

        @EJB
    private UserFacadeLocal userFacade;
        
        
        

    private TreeNode root;
    
     Entities.ParameterGroup paraGroup= new ParameterGroup();
     
     List<ParameterGroup> Gpara= new ArrayList<ParameterGroup>();
     
      List<GroupHasParameter> para= new ArrayList<GroupHasParameter>();
      
      
       List<Parameter> parameter= new ArrayList<Parameter>();
       
        List<Parameter> selparameter= new ArrayList<Parameter>();
        
        ParameterGroup selectgroup=new ParameterGroup();
     
      java.sql.Date date ;
      
      PGroup_tree selectdelte=new PGroup_tree();

    /**
     * Creates a new instance of ParameterGroup
     */
    public ParameterGroups() {
    }
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
            selectgroup=new ParameterGroup();
            selparameter= new ArrayList<Parameter>();
             Gpara=parameterGroupFacade.findAll();
             parameter=parameterFacade.findAll();
     
       root = new DefaultTreeNode(new PGroup_tree("Groups",Gpara.size(),0,"root"), null);
      for(int i=0;i<Gpara.size();i++){
          try {
              para  = groupHasParameterFacade.get_para_group(Gpara.get(i));
              
              System.out.println("group "+Gpara.get(i).getGroupname()+para.size());
              DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Gpara.get(i).getGroupname(),para.size(),Gpara.get(i).getId(),"GROUP"), root);
         
              for(int j=0;j<para.size();j++){
                   System.out.println("para "+para.get(j).getParameterID().getDisplayName());
             DefaultTreeNode documentss = new DefaultTreeNode(new PGroup_tree(para.get(j).getParameterID().getDisplayName(),1,para.get(j).getId(),"Parameter"), documents);
        
              }
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Gpara.get(i).getGroupname(),0,Gpara.get(i).getId(),"GROUP"), root);
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

    public ParameterGroup getParaGroup() {
        return paraGroup;
    }

    public void setParaGroup(ParameterGroup paraGroup) {
        this.paraGroup = paraGroup;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    public List<Parameter> getSelparameter() {
        return selparameter;
    }

    public void setSelparameter(List<Parameter> selparameter) {
        this.selparameter = selparameter;
    }

    public ParameterGroup getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(ParameterGroup selectgroup) {
        this.selectgroup = selectgroup;
    }

    public List<ParameterGroup> getGpara() {
        return Gpara;
    }

    public void setGpara(List<ParameterGroup> Gpara) {
        this.Gpara = Gpara;
    }

    public PGroup_tree getSelectdelte() {
        return selectdelte;
    }

    public void setSelectdelte(PGroup_tree selectdelte) {
        this.selectdelte = selectdelte;
    }

    
   
       
       public String joingroup(ActionEvent actionEvent){
         for(int i=0;i<selparameter.size();i++){
  GroupHasParameter a=new GroupHasParameter();
  a.setParameterGroupID(selectgroup);
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            a.setCreateDate(date);
            a.setUpdateDate(date);
            a.setParameterID(selparameter.get(i));
          groupHasParameterFacade.create(a);
         }
       
         
      return "Login";
     }
    
    
    
       public String ADD(ActionEvent actionEvent){
         
      if(parameterGroupFacade.Pgroup_find(paraGroup.getGroupname())){
              Messages.addInfoMessage("Duplicated",2);
     }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            paraGroup.setUserID(Login.login);
            paraGroup.setCreateDate(date);
            paraGroup.setUpdateDate(date);
          parameterGroupFacade.create(paraGroup);
       }
      
       Gpara=parameterGroupFacade.findAll();
             parameter=parameterFacade.findAll();
         
      return "Login";
     }
       
       
                public void remove(ActionEvent actionEvent){
                    
                    if(selectdelte.getType().toUpperCase().equals("GROUP")){
                    Messages.addInfoMessage("all para tp group  removed",1);
                    }else{
                           try {
                  
                 GroupHasParameter a=groupHasParameterFacade.find(selectdelte.getId());
                               
                   groupHasParameterFacade.remove(a);
             Messages.addInfoMessage("removed "+a.getParameterID().getDisplayName()+" from "+a.getParameterGroupID().getGroupname(),1);
         } catch (Exception e) {
                 Messages.addInfoMessage("not removed",1);
    }
                    }
  
         
     
     }
    
    
    
    
}