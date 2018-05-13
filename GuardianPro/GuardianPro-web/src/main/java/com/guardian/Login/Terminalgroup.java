/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.AccessoryGroup;
import Entities.ApplicationGroup;
import Entities.GroupHasParameter;
import Entities.ParameterGroup;
import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TgroupHasAccesory;
import Entities.TgroupHasGparameter;
import Entities.TgroupHasParameter;
import Entities.TgroupHasSoftware;
import Entities.TgroupHasTerminal;
import Facades.AccessoryGroupFacadeLocal;
import Facades.ApplicationGroupFacadeLocal;
import Facades.GroupHasParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TgroupHasAccesoryFacadeLocal;
import Facades.TgroupHasGparameterFacadeLocal;
import Facades.TgroupHasParameterFacadeLocal;
import Facades.TgroupHasSoftwareFacadeLocal;
import Facades.TgroupHasTerminalFacadeLocal;
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
public class Terminalgroup {
    
     @EJB
    private GroupHasParameterFacadeLocal groupHasParameterFacade;

    @EJB
    private TgroupHasParameterFacadeLocal tgroupHasParameterFacade;

    @EJB
    private TgroupHasAccesoryFacadeLocal tgroupHasAccesoryFacade;

    @EJB
    private TgroupHasGparameterFacadeLocal tgroupHasGparameterFacade;

    @EJB
    private TgroupHasSoftwareFacadeLocal tgroupHasSoftwareFacade;

    @EJB
    private TgroupHasTerminalFacadeLocal tgroupHasTerminalFacade;

    @EJB
    private ParameterGroupFacadeLocal parameterGroupFacade;

    @EJB
    private AccessoryGroupFacadeLocal accessoryGroupFacade;

    @EJB
    private ApplicationGroupFacadeLocal applicationGroupFacade;
    
      @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
      
        @EJB
    private UserFacadeLocal userFacade;
        
         @EJB
    private TerminalFacadeLocal terminalFacade;
         
         
         
         
         
         
      
      
       private TerminalGroup termgroup=new TerminalGroup();
       
        java.sql.Date date ;
        
        List<Terminal> Terminals= new ArrayList<Terminal>();
        
        List<Terminal> selectTerminals= new ArrayList<Terminal>();
        
        
         List<ApplicationGroup> Appgroup= new ArrayList<ApplicationGroup>();
        
        List<ApplicationGroup> selectAppgroup= new ArrayList<ApplicationGroup>();
        
        
           List<AccessoryGroup> Acessorygroup= new ArrayList<AccessoryGroup>();
        
        List<AccessoryGroup> selectAcessorygroup= new ArrayList<AccessoryGroup>();
        
        
            List<ParameterGroup> paragroup= new ArrayList<ParameterGroup>();
        
        List<ParameterGroup> selectparagroup= new ArrayList<ParameterGroup>();
        
        
         List<Entities.TerminalGroup> Terminalsgroup= new ArrayList<TerminalGroup>();
         
         List<TgroupHasTerminal> groupHasTerminal= new ArrayList<TgroupHasTerminal>();
         
          List<TgroupHasGparameter> groupHasGparameter= new ArrayList<TgroupHasGparameter>();
          
           List<TgroupHasParameter> groupHasParameter= new ArrayList<TgroupHasParameter>();
        
           List<TgroupHasSoftware> groupHasSoftware= new ArrayList<TgroupHasSoftware>();
       // List<Terminal> selectTerminals= new ArrayList<Terminal>();
        
        

    private TreeNode root;
      
    private TreeNode selectdelte;
      
      
    private TreeNode root1;
      
    private TreeNode selectdelte1;
    
    
        private TreeNode root2;
      
    private TreeNode selectdelte2;
      
        
    /**
     * Creates a new instance of Terminalgroup
     */
    public Terminalgroup() {
    }

    public TreeNode getRoot2() {
        return root2;
    }

    public void setRoot2(TreeNode root2) {
        this.root2 = root2;
    }

    public TreeNode getSelectdelte2() {
        return selectdelte2;
    }

    public void setSelectdelte2(TreeNode selectdelte2) {
        this.selectdelte2 = selectdelte2;
    }
    
    

    public TreeNode getRoot1() {
        return root1;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public TreeNode getSelectdelte1() {
        return selectdelte1;
    }

    public void setSelectdelte1(TreeNode selectdelte1) {
        this.selectdelte1 = selectdelte1;
    }

    
    public TerminalGroup getTermgroup() {
        return termgroup;
    }

    public void setTermgroup(TerminalGroup termgroup) {
        this.termgroup = termgroup;
    }

    public List<Terminal> getTerminals() {
        return Terminals;
    }

    public void setTerminals(List<Terminal> Terminals) {
        this.Terminals = Terminals;
    }

    public List<Terminal> getSelectTerminals() {
        return selectTerminals;
    }

    public void setSelectTerminals(List<Terminal> selectTerminals) {
        this.selectTerminals = selectTerminals;
    }

    public List<ApplicationGroup> getAppgroup() {
        return Appgroup;
    }

    public void setAppgroup(List<ApplicationGroup> Appgroup) {
        this.Appgroup = Appgroup;
    }

    public List<ApplicationGroup> getSelectAppgroup() {
        return selectAppgroup;
    }

    public void setSelectAppgroup(List<ApplicationGroup> selectAppgroup) {
        this.selectAppgroup = selectAppgroup;
    }

    public List<AccessoryGroup> getAcessorygroup() {
        return Acessorygroup;
    }

    public void setAcessorygroup(List<AccessoryGroup> Acessorygroup) {
        this.Acessorygroup = Acessorygroup;
    }

    public List<AccessoryGroup> getSelectAcessorygroup() {
        return selectAcessorygroup;
    }

    public void setSelectAcessorygroup(List<AccessoryGroup> selectAcessorygroup) {
        this.selectAcessorygroup = selectAcessorygroup;
    }

    public List<ParameterGroup> getParagroup() {
        return paragroup;
    }

    public void setParagroup(List<ParameterGroup> paragroup) {
        this.paragroup = paragroup;
    }

    public List<ParameterGroup> getSelectparagroup() {
        return selectparagroup;
    }

    public void setSelectparagroup(List<ParameterGroup> selectparagroup) {
        this.selectparagroup = selectparagroup;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectdelte() {
        return selectdelte;
    }

    public void setSelectdelte(TreeNode selectdelte) {
        this.selectdelte = selectdelte;
    }
    
    
    
    
    
    
       public void init(){
             Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
        //  parmeter_types = parameterTypeFacade.findAll();
         Terminals=terminalFacade.findAll();
        Terminalsgroup=terminalGroupFacade.findAll();
          List<TgroupHasTerminal> grouphasterminal= new ArrayList<TgroupHasTerminal>();
           grouphasterminal= tgroupHasTerminalFacade.findAll();
           for(TgroupHasTerminal tgroupHasTerminal:grouphasterminal){
           Terminals.remove(tgroupHasTerminal.getTerminalID());
           }
           Appgroup=applicationGroupFacade.findAll();
           Acessorygroup=accessoryGroupFacade.findAll();
           paragroup=parameterGroupFacade.findAll();
           
             root = new DefaultTreeNode(new PGroup_tree("Groups",Terminalsgroup.size(),0,"root"), null);
              for(int i=0;i<Terminalsgroup.size();i++){
          try {
              groupHasTerminal  = tgroupHasTerminalFacade.find_term_groups(Terminalsgroup.get(i));
              
            //  System.out.println("group "+Gpara.get(i).getGroupname()+para.size());
              DefaultTreeNode documents = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",groupHasTerminal.size(),Terminalsgroup.get(i).getId(),"GROUP"), root);
               for(int j=0;j<groupHasTerminal.size();j++){
                   System.out.println("para "+groupHasTerminal.get(j).getTerminalID().getTid());
             DefaultTreeNode documentss = new DefaultTreeNode(new Pterminal_group(groupHasTerminal.get(j).getTerminalID().getTid(),groupHasTerminal.get(j).getTerminalID().getPOSSerialNo(),groupHasTerminal.get(j).getTerminalID().getShopName(),1,groupHasTerminal.get(j).getId(),"Terminal"), documents);
        
              }
          
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",0,Terminalsgroup.get(i).getId(),"GROUP"), root);
          }
         
      
      }
              
              
              
               root1 = new DefaultTreeNode(new PGroup_tree("Groups",Terminalsgroup.size(),0,"root"), null);
              for(int i=0;i<Terminalsgroup.size();i++){
          try {
              groupHasGparameter  = tgroupHasGparameterFacade.find_term_groups(Terminalsgroup.get(i));
              
            //  System.out.println("group "+Gpara.get(i).getGroupname()+para.size());
              DefaultTreeNode documents1 = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",groupHasGparameter.size(),Terminalsgroup.get(i).getId(),"GROUP"), root1);
               for(int j=0;j<groupHasGparameter.size();j++){
                   System.out.println("para "+groupHasGparameter.get(j).getParameterGroupID().getGroupname());
             DefaultTreeNode documentss1 = new DefaultTreeNode(new Pterminal_group(groupHasGparameter.get(j).getParameterGroupID().getGroupname(),groupHasGparameter.get(j).getParameterGroupID().getGroupname(),groupHasGparameter.get(j).getParameterGroupID().getGroupname(),1,groupHasTerminal.get(j).getId(),"Parmeter_Group"), documents1);
       
              }
          
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",0,Terminalsgroup.get(i).getId(),"GROUP"), root1);
          }
         
      
      }
              
              
              
                     
               root2 = new DefaultTreeNode(new PGroup_tree("Groups",Terminalsgroup.size(),0,"root"), null);
              for(int i=0;i<Terminalsgroup.size();i++){
          try {
              groupHasSoftware  = tgroupHasSoftwareFacade.find_term_groups(Terminalsgroup.get(i));
              
            //  System.out.println("group "+Gpara.get(i).getGroupname()+para.size());
              DefaultTreeNode documents2 = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",groupHasSoftware.size(),Terminalsgroup.get(i).getId(),"GROUP"), root2);
               for(int j=0;j<groupHasSoftware.size();j++){
                   System.out.println("para "+groupHasSoftware.get(j).getApplicationGroupID().getGroupname());
             DefaultTreeNode documentss1 = new DefaultTreeNode(new Pterminal_group(groupHasSoftware.get(j).getApplicationGroupID().getGroupname(),groupHasSoftware.get(j).getApplicationGroupID().getGroupname(),groupHasSoftware.get(j).getApplicationGroupID().getGroupname(),1,groupHasSoftware.get(j).getId(),"App_Group"), documents2);
       
              }
          
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new Pterminal_group(Terminalsgroup.get(i).getGroupname(),"","",0,Terminalsgroup.get(i).getId(),"GROUP"), root2);
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

    
          public String Addgroup(ActionEvent actionEvent){
         
        if(terminalGroupFacade.group_find(termgroup.getGroupname())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            termgroup.setCreateDate(date);
            termgroup.setUpdateDate(date);
            termgroup.setUserID(Login.login);
          terminalGroupFacade.create(termgroup);
          
          for(int i=0;i<selectTerminals.size();i++){
              TgroupHasTerminal a=new TgroupHasTerminal();
              a.setTerminalGroupID(termgroup);
              a.setTerminalID(selectTerminals.get(i));
              
              tgroupHasTerminalFacade.create(a);
          }
          
         
           for(int i=0;i<selectAcessorygroup.size();i++){
               TgroupHasAccesory a=new TgroupHasAccesory();
              a.setTerminalGroupID(termgroup);
              a.setAccessoryGroupID(selectAcessorygroup.get(i));
              a.setCreateDate(date);
            a.setUpdateDate(date);
              tgroupHasAccesoryFacade.create(a);
          }
    
           
               for(int i=0;i<selectAppgroup.size();i++){
                   TgroupHasSoftware a=new TgroupHasSoftware();
              a.setTerminalGroupID(termgroup);
              a.setApplicationGroupID(selectAppgroup.get(i));
               a.setCreateDate(date);
            a.setUpdateDate(date);
              tgroupHasSoftwareFacade.create(a);
          }
               
               
          for(int i=0;i<selectparagroup.size();i++){
              TgroupHasGparameter a=new TgroupHasGparameter();
              a.setTerminalGroupID(termgroup);
              a.setParameterGroupID(selectparagroup.get(i));
               a.setCreateDate(date);
            a.setUpdateDate(date);
              tgroupHasGparameterFacade.create(a);
            List<GroupHasParameter> b=groupHasParameterFacade.get_para_group(selectparagroup.get(i));
            for(int j=0;j<b.size();j++){
                TgroupHasParameter v=new TgroupHasParameter();
                v.setParameterID(b.get(j).getParameterID());
                v.setTgrouphasGparameterID(a);
                if(b.get(j).getParameterID().getDefaultvalue()==null){
                      v.setParmetervalue("0");
                }else{
                 v.setParmetervalue(b.get(j).getParameterID().getDefaultvalue());

                }
              
                 v.setCreateDate(date);
            v.setUpdateDate(date);
                tgroupHasParameterFacade.create(v);
            }
              
          }
          
        }
         
      return "Login";
     }
    
}
