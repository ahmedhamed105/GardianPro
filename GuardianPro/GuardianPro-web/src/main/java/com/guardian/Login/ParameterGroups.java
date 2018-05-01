/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

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
     
      java.sql.Date date ;

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
            
             Gpara=parameterGroupFacade.findAll();
      //   parmeters  = parameterFacade.findAll();
       root = new DefaultTreeNode(new PGroup_tree("Groups",Gpara.size(),0), null);
      for(int i=0;i<Gpara.size();i++){
         DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Gpara.get(i).getGroupname(),Gpara.size(),Gpara.get(i).getId()), root);
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
         
      return "Login";
     }
    
    
    
    
}
