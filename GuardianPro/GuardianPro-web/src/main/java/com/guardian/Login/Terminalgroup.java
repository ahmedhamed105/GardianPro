/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Accessory;
import Entities.AccessoryGroup;
import Entities.ApplicationGroup;
import Entities.GroupHasParameter;
import Entities.Parameter;
import Entities.ParameterGroup;
import Entities.ParameterValues;
import Entities.Pgchild;
import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TerminalTemplate;
import Entities.TgroupHasAccesory;
import Entities.TgroupHasGparameter;
import Entities.TgroupHasSoftware;
import Entities.TgroupHasTerminal;
import Facades.AccessoryGroupFacadeLocal;
import Facades.ApplicationGroupFacadeLocal;
import Facades.GroupHasParameterFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
import Facades.ParameterValuesFacadeLocal;
import Facades.PgchildFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
import Facades.TgroupHasAccesoryFacadeLocal;
import Facades.TgroupHasGparameterFacadeLocal;
import Facades.TgroupHasSoftwareFacadeLocal;
import Facades.TgroupHasTerminalFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ahmed.elemam
 */
public class Terminalgroup {



    @EJB
    private PgchildFacadeLocal pgchildFacade;

    @EJB
    private ParameterValuesFacadeLocal parameterValuesFacade;


    @EJB
    private ParameterFacadeLocal parameterFacade;
    
     @EJB
    private GroupHasParameterFacadeLocal groupHasParameterFacade;

   
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
         
          @EJB
    private TerminalTemplateFacadeLocal terminalTemplateFacade;
          
          
          
          
             private TreeNode root1;
     
    private TreeNode root2;
     
    private TreeNode selectedNode1;
     
    private TreeNode selectedNode2;
    
    
        List<ParameterValues> TParameterValues= new ArrayList<ParameterValues>();
        ParameterValues seletParameterValues=new ParameterValues();
         
    
         
          List<TgroupHasTerminal> S_grouphasterminal= new ArrayList<TgroupHasTerminal>();
         
      
      
       private TerminalGroup termgroup=new TerminalGroup();
       
        java.sql.Date date ;
        
        List<Terminal> Terminals= new ArrayList<Terminal>();
        
        List<Terminal> selectTerminals= new ArrayList<Terminal>();
        
        
        List<TerminalGroup> TGroup= new ArrayList<TerminalGroup>();
        TerminalGroup seletermgroup=new TerminalGroup();
        
        
        List<TgroupHasTerminal> groupHasTerminal= new ArrayList<TgroupHasTerminal>();
        TgroupHasTerminal selegroupHasTerminal= new TgroupHasTerminal();
        List<TerminalTemplate> Terminaltemplate= new ArrayList<TerminalTemplate>();
        
        
        List<TgroupHasSoftware> groupHasSoftware= new ArrayList<TgroupHasSoftware>();
        TgroupHasSoftware selegroupHasSoftware=new TgroupHasSoftware();
         List<ApplicationGroup> Appgroup= new ArrayList<ApplicationGroup>();
        List<ApplicationGroup> selectAppgroup= new ArrayList<ApplicationGroup>();
        
        
        
        List<TgroupHasAccesory> groupHasAccesory= new ArrayList<TgroupHasAccesory>();
        TgroupHasAccesory selegroupHasAccesory= new TgroupHasAccesory();
        List<AccessoryGroup> Acessorygroup= new ArrayList<AccessoryGroup>();
        List<AccessoryGroup> selectAcessorygroup= new ArrayList<AccessoryGroup>();
        
        
        List<TgroupHasGparameter> groupHasGparameter= new ArrayList<TgroupHasGparameter>();
        List<Parameter> para= new ArrayList<Parameter>(); 
        List<Parameter> selectpara= new ArrayList<Parameter>();
        List<ParameterGroup> paragroup= new ArrayList<ParameterGroup>(); 
        List<ParameterGroup> selectparagroup= new ArrayList<ParameterGroup>();
        
        
         List<Entities.TerminalGroup> Terminalsgroup= new ArrayList<TerminalGroup>();
         
        
           
      
       // List<Terminal> selectTerminals= new ArrayList<Terminal>();
           
           
 
        
        

   
      
  
      
      
  
        
    /**
     * Creates a new instance of Terminalgroup
     */
    public Terminalgroup() {
    }

    public List<ParameterValues> getTParameterValues() {
        return TParameterValues;
    }

    public void setTParameterValues(List<ParameterValues> TParameterValues) {
        this.TParameterValues = TParameterValues;
    }

    public ParameterValues getSeletParameterValues() {
        return seletParameterValues;
    }

    public void setSeletParameterValues(ParameterValues seletParameterValues) {
        this.seletParameterValues = seletParameterValues;
    }

    
    
    



    

  

    
    

    public List<TgroupHasAccesory> getGroupHasAccesory() {
        return groupHasAccesory;
    }

    public void setGroupHasAccesory(List<TgroupHasAccesory> groupHasAccesory) {
        this.groupHasAccesory = groupHasAccesory;
    }

    public TgroupHasAccesory getSelegroupHasAccesory() {
        return selegroupHasAccesory;
    }

    public void setSelegroupHasAccesory(TgroupHasAccesory selegroupHasAccesory) {
        this.selegroupHasAccesory = selegroupHasAccesory;
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

    

    public List<TerminalGroup> getTGroup() {
        return TGroup;
    }

    public void setTGroup(List<TerminalGroup> TGroup) {
        this.TGroup = TGroup;
    }

    public TerminalGroup getSeletermgroup() {
        return seletermgroup;
    }

    public void setSeletermgroup(TerminalGroup seletermgroup) {
        this.seletermgroup = seletermgroup;
    }

    public List<TgroupHasTerminal> getGroupHasTerminal() {
        return groupHasTerminal;
    }

    public void setGroupHasTerminal(List<TgroupHasTerminal> groupHasTerminal) {
        this.groupHasTerminal = groupHasTerminal;
    }

    public TgroupHasTerminal getSelegroupHasTerminal() {
        return selegroupHasTerminal;
    }

    public void setSelegroupHasTerminal(TgroupHasTerminal selegroupHasTerminal) {
        this.selegroupHasTerminal = selegroupHasTerminal;
    }

    public List<TerminalTemplate> getTerminaltemplate() {
        return Terminaltemplate;
    }

    public void setTerminaltemplate(List<TerminalTemplate> Terminaltemplate) {
        this.Terminaltemplate = Terminaltemplate;
    }

    public List<TgroupHasSoftware> getGroupHasSoftware() {
        return groupHasSoftware;
    }

    public void setGroupHasSoftware(List<TgroupHasSoftware> groupHasSoftware) {
        this.groupHasSoftware = groupHasSoftware;
    }

    public TgroupHasSoftware getSelegroupHasSoftware() {
        return selegroupHasSoftware;
    }

    public void setSelegroupHasSoftware(TgroupHasSoftware selegroupHasSoftware) {
        this.selegroupHasSoftware = selegroupHasSoftware;
    }

    public List<Parameter> getPara() {
        return para;
    }

    public void setPara(List<Parameter> para) {
        this.para = para;
    }

    public List<Parameter> getSelectpara() {
        return selectpara;
    }

    public void setSelectpara(List<Parameter> selectpara) {
        this.selectpara = selectpara;
    }

    public TreeNode getRoot1() {
        return root1;
    }

    public void setRoot1(TreeNode root1) {
        this.root1 = root1;
    }

    public TreeNode getRoot2() {
        return root2;
    }

    public void setRoot2(TreeNode root2) {
        this.root2 = root2;
    }

    public TreeNode getSelectedNode1() {
        return selectedNode1;
    }

    public void setSelectedNode1(TreeNode selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }

    public TreeNode getSelectedNode2() {
        return selectedNode2;
    }

    public void setSelectedNode2(TreeNode selectedNode2) {
        this.selectedNode2 = selectedNode2;
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
        TGroup=terminalGroupFacade.findAll();
        
           Terminaltemplate=terminalTemplateFacade.findAll();
        Terminalsgroup=terminalGroupFacade.findAll();
        
         Terminals=terminalFacade.findAll();
         
        
         
           S_grouphasterminal= tgroupHasTerminalFacade.findAll();
           for(TgroupHasTerminal tgroupHasTerminal:S_grouphasterminal){
           Terminals.remove(tgroupHasTerminal.getTerminalID());
           }
           
           
                paragroup=parameterGroupFacade.findAll();
                para=parameterFacade.findAll();
           List<TgroupHasGparameter> groupHasGparam= new ArrayList<TgroupHasGparameter>();
              groupHasGparam= tgroupHasGparameterFacade.findAll();
           for(TgroupHasGparameter tgroupHasTerminal:groupHasGparam){
           paragroup.remove(tgroupHasTerminal.getParameterGroupID());
           }
           
           Appgroup=applicationGroupFacade.findAll();
           Acessorygroup=accessoryGroupFacade.findAll();
      
           
             
             
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
          
        
          
        }
         
      return "Login";
     }
          
          
          

            
public String onFlowProcess(FlowEvent event) {
                 
        if(event.getOldStep().equals("Gtermainal") && event.getNewStep().equals("terminal")){
                  if(seletermgroup != null){    

                           groupHasTerminal=tgroupHasTerminalFacade.find_term_groups(seletermgroup);
             
                   
                    
                    // System.out.println(groupHasTerminal.size());
                     return "terminal";
                 }else{
                 return  "Gtermainal";
                 }
        }else if(event.getOldStep().equals("terminal") && event.getNewStep().equals("Application")){
               
                     groupHasSoftware=tgroupHasSoftwareFacade.find_term_groups(seletermgroup);
                     return "Application";
                 
        }else if(event.getOldStep().equals("Application") && event.getNewStep().equals("accessory")){
               
                     groupHasAccesory=tgroupHasAccesoryFacade.find_term_groups(seletermgroup);
                     return "accessory";
                 
        }else if(event.getOldStep().equals("accessory") && event.getNewStep().equals("Parameter")){
           
          //  groupHasparameter=tgroupHasParameterFacade.find_term_groups(seletermgroup);
            //  root = new DefaultTreeNode(new PGroup_tree("Groups",0,0,"root"), null); 
              
          //   groupHasGparameter=tgroupHasGparameterFacade.find_term_groups(seletermgroup);
               paragroup=parameterGroupFacade.findAll();
            
             
             root1 = new DefaultTreeNode(new PGroup_tree("Groups",0,0,"root"), null);
             for(ParameterGroup b:paragroup){
         new DefaultTreeNode(new PGroup_tree(b.getGroupname(),0,b.getId(),b.getParametertypeID().getType()), root1);
        
             }
      

       groupHasGparameter=tgroupHasGparameterFacade.find_term_groups(seletermgroup);
        root2 = new DefaultTreeNode(new PGroup_tree("Groups",0,0,"root"), null);
           root2.setExpanded(true);
        TreeNode item0 = new DefaultTreeNode(new PGroup_tree("XML root",0,0,"root"), root2);
         item0.setExpanded(true);
         List<TreeNode> roots=new ArrayList<TreeNode>();
         List<TreeNode> child1=new ArrayList<TreeNode>();
       
        for(TgroupHasGparameter sl:groupHasGparameter){
             try {
                 List<Pgchild> ad= pgchildFacade.childs_find(sl);
                 
                 for(Pgchild pa:ad){
                  if(pa.getRoot()==1){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(sl.getParameterGroupID().getGroupname(),sl.getId(),sl.getParameterGroupID().getId(),sl.getParameterGroupID().getParametertypeID().getType()), item0);
                  roots.add(f);
                   f.setExpanded(true);
                  }
                  }

                 
                   } catch (Exception e) {
                   }
        }
        
        if(!roots.isEmpty()){
            for(TreeNode f1:roots){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
            System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 1){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                  child1.add(f);   
                   f.setExpanded(true);
                     }
                  }
            
            }
            
            
            roots.clear();
             if(!child1.isEmpty()){
            for(TreeNode f1:child1){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
            System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 2){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                  roots.add(f);  
                   f.setExpanded(true);
                     }
                  }
            
            }
            
            
          child1.clear();
             if(!roots.isEmpty()){
            for(TreeNode f1:roots){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
         //   System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 3){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                     f.setExpanded(true);
                     }
                  }
            
            }
            
            
            
            
        
        }   
            
        
        }
            
        
        }
        
        
        
        
        
       
            
                     return "Parameter";
                 
        }else{
                    return  "Gtermainal";
        }
                
            
    }
             
             
    public void onRowEditTGroup(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          seletermgroup=((TerminalGroup) event.getObject());
            seletermgroup.setUpdateDate(date);
          terminalGroupFacade.edit(seletermgroup);
          
          Messages.addInfoMessage("Edited "+((TerminalGroup) event.getObject()).getGroupname(),1);
    }  
    public void onRowCancelTGroup(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TerminalGroup) event.getObject()).getGroupname(),1);
    }
    public void removeTGroup(ActionEvent actionEvent){
              if(seletermgroup != null){  
          // please add remove group
         try {
                   terminalGroupFacade.remove(seletermgroup);
                                   Terminals=terminalFacade.findAll();
             for(TgroupHasTerminal tgroupHasTerminal:S_grouphasterminal){
           Terminals.remove(tgroupHasTerminal.getTerminalID());
           }
                   
                   
             Messages.addInfoMessage("removed "+seletermgroup.getGroupname(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+seletermgroup.getGroupname()+" return to Admin",2);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2);
   
              }
         
     
     }
      
      
      
      
    public void onRowEditT(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasTerminal=((TgroupHasTerminal) event.getObject());
           selegroupHasTerminal.setUpdateDate(date);
          tgroupHasTerminalFacade.edit(selegroupHasTerminal);
          selegroupHasTerminal.getTerminalID().setUpdateDate(date);
          terminalFacade.edit(selegroupHasTerminal.getTerminalID());
          Messages.addInfoMessage("Edited "+((TgroupHasTerminal) event.getObject()).getTerminalID().getTid(),1);
    } 
    public void onRowCancelT(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasTerminal) event.getObject()).getTerminalID().getTid(),1);
    }
    public void removeT(ActionEvent actionEvent){
              if(selegroupHasTerminal != null){  
          // please add remove group
         try {
                   tgroupHasTerminalFacade.remove(selegroupHasTerminal);
                   
           
             try {
                   Terminals=terminalFacade.findAll();
                   S_grouphasterminal= tgroupHasTerminalFacade.findAll();
                   if(Terminals.size()>0){
            for(TgroupHasTerminal tgroupHasTerminal:S_grouphasterminal){
           Terminals.remove(tgroupHasTerminal.getTerminalID());
           }
                   }
             } catch (Exception e) {
                 e.printStackTrace();
             }
           groupHasTerminal=tgroupHasTerminalFacade.find_term_groups(seletermgroup);
             
                   
                   
             Messages.addInfoMessage("removed "+selegroupHasTerminal.getTerminalID().getTid(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasTerminal.getTerminalID().getTid()+" return to Admin",2);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal",2);
   
              }
         
     
     }      
    public void ADDT(ActionEvent actionEvent){
              if(selectTerminals != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {
               
                 for(int i=0;i<selectTerminals.size();i++){
              TgroupHasTerminal a=new TgroupHasTerminal();
              a.setTerminalGroupID(seletermgroup);
              a.setTerminalID(selectTerminals.get(i)); 
              a.setCreateDate(date);
              a.setUpdateDate(date);
              tgroupHasTerminalFacade.create(a);
               Messages.addInfoMessage("ADD "+selectTerminals.get(i).getTid()+" to "+seletermgroup.getGroupname(),1);
          }
                   
            try {
                   Terminals=terminalFacade.findAll();
                   S_grouphasterminal= tgroupHasTerminalFacade.findAll();
                   if(Terminals.size()>0){
            for(TgroupHasTerminal tgroupHasTerminal:S_grouphasterminal){
           Terminals.remove(tgroupHasTerminal.getTerminalID());
           }
                   }
             } catch (Exception e) {
             }
                 groupHasTerminal=tgroupHasTerminalFacade.find_term_groups(seletermgroup);
             
                       
            
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin",2);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2);
   
              }
         
     
     }
    
    
    
    public void onRowEditTS(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasSoftware=((TgroupHasSoftware) event.getObject());
          selegroupHasSoftware.setUpdateDate(date);
          tgroupHasSoftwareFacade.edit(selegroupHasSoftware);
          selegroupHasSoftware.getApplicationGroupID().setUpdateDate(date);
          applicationGroupFacade.edit(selegroupHasSoftware.getApplicationGroupID());
          Messages.addInfoMessage("Edited "+((TgroupHasSoftware) event.getObject()).getApplicationGroupID().getGroupname(),1);
    }
    public void onRowCancelTS(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasSoftware) event.getObject()).getApplicationGroupID().getGroupname(),1);
    }
    public void removeTS(ActionEvent actionEvent){
              if(selegroupHasSoftware != null){  
          // please add remove group
         try {
                   tgroupHasSoftwareFacade.remove(selegroupHasSoftware);
                   
           
        groupHasSoftware=tgroupHasSoftwareFacade.find_term_groups(seletermgroup);
         
                   
             Messages.addInfoMessage("removed "+selegroupHasSoftware.getApplicationGroupID().getGroupname(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasSoftware.getApplicationGroupID().getGroupname()+" return to Admin",2);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose APP Group",2);
   
              }
         
     
     }      
    public void ADDTS(ActionEvent actionEvent){
              if(selectAppgroup != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {
               
          for(int i=0;i<selectAppgroup.size();i++){
              try {
                  TgroupHasSoftware a=new TgroupHasSoftware();
              a.setTerminalGroupID(seletermgroup);
              a.setApplicationGroupID(selectAppgroup.get(i));
               a.setCreateDate(date);
            a.setUpdateDate(date);
              tgroupHasSoftwareFacade.create(a);
                   Messages.addInfoMessage("ADD "+selectAppgroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1);
         
              } catch (Exception e) {
                  e.printStackTrace();
              }
                    
          }
  
              groupHasSoftware=tgroupHasSoftwareFacade.find_term_groups(seletermgroup);
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin",2);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2);
   
              }
         
     
     }
    
    
    
    public void onRowEditA(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasAccesory=((TgroupHasAccesory) event.getObject());
          selegroupHasAccesory.setUpdateDate(date);
          tgroupHasAccesoryFacade.edit(selegroupHasAccesory);
          selegroupHasAccesory.getAccessoryGroupID().setUpdateDate(date);
          accessoryGroupFacade.edit(selegroupHasAccesory.getAccessoryGroupID());
          Messages.addInfoMessage("Edited "+((TgroupHasAccesory) event.getObject()).getAccessoryGroupID().getGroupname(),1);
    }
    public void onRowCancelA(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasAccesory) event.getObject()).getAccessoryGroupID().getGroupname(),1);
    }
    public void removeA(ActionEvent actionEvent){
              if(selegroupHasAccesory != null){  
          // please add remove group
         try {
                   tgroupHasAccesoryFacade.remove(selegroupHasAccesory);
                   
           
        groupHasAccesory=tgroupHasAccesoryFacade.find_term_groups(seletermgroup);
         
                   
             Messages.addInfoMessage("removed "+selegroupHasAccesory.getAccessoryGroupID().getGroupname(),1);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasAccesory.getAccessoryGroupID().getGroupname()+" return to Admin",2);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose Accessory Group",2);
   
              }
         
     
     }      
    public void ADDA(ActionEvent actionEvent){
              if(selectAcessorygroup != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {
             
             
                for(int i=0;i<selectAcessorygroup.size();i++){
               
               TgroupHasAccesory a=new TgroupHasAccesory();
               a.setAaccessory("0");
              a.setTerminalGroupID(seletermgroup);
              a.setAccessoryGroupID(selectAcessorygroup.get(i));
              a.setCreateDate(date);
            a.setUpdateDate(date);
              tgroupHasAccesoryFacade.create(a);
           Messages.addInfoMessage("ADD "+selectAcessorygroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1);
         
          }
               
   
  
              groupHasAccesory=tgroupHasAccesoryFacade.find_term_groups(seletermgroup);
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin",2);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2);
   
              }
         
     
     }
      
    


    private String xmlPath = "D:\\TMS\\app\\XML";
    private String applicationPath = "D:\\TMS\\app\\application";

    
      public void onRowEditP(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //  selegroupHasparameter=((TgroupHasParameter) event.getObject());
        //  selegroupHasparameter.setUpdateDate(date);
       //   tgroupHasParameterFacade.edit(selegroupHasparameter);
       //   selegroupHasparameter.getParameterID().setUpdateDate(date);
     //     parameterFacade.edit(selegroupHasparameter.getParameterID());
     //     Messages.addInfoMessage("Edited "+((TgroupHasParameter) event.getObject()).getParameterID().getDisplayName(),1);
    }
    public void onRowCancelP(RowEditEvent event) {
     //     Messages.addInfoMessage("Cancelled "+((TgroupHasParameter) event.getObject()).getParameterID().getDisplayName(),1);
    }
    public void removeP(ActionEvent actionEvent){
//              if(selegroupHasparameter != null){  
//          // please add remove group
//         try {
//                   tgroupHasParameterFacade.remove(selegroupHasparameter);
//                   
//           
//      groupHasparameter=tgroupHasParameterFacade.find_term_groups(seletermgroup);
//         
//                   
//             Messages.addInfoMessage("removed "+selegroupHasparameter.getParameterID().getDisplayName(),1);
//         } catch (Exception e) {
//              Messages.addInfoMessage("Not removed "+selegroupHasparameter.getParameterID().getDisplayName()+" return to Admin",2);
//        e.printStackTrace();
//         }
//              }else{
//                         Messages.addInfoMessage("Please choose Accessory Group",2);
//   
//              }
         
     
     }      
    public void ADDP(ActionEvent actionEvent){
              if(selectparagroup != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {

                for(int i=0;i<selectparagroup.size();i++){
               
            TgroupHasGparameter a=new TgroupHasGparameter();
            a.setTerminalGroupID(seletermgroup);
            a.setParameterGroupID(selectparagroup.get(i));
            a.setCreateDate(date);
            a.setUpdateDate(date);
            tgroupHasGparameterFacade.create(a);
           Messages.addInfoMessage("ADD "+selectparagroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1);
       List<GroupHasParameter> para_list= groupHasParameterFacade.get_para_group(selectparagroup.get(i));
           for(GroupHasParameter b:para_list){
          //  TgroupHasParameter v=new TgroupHasParameter();
         //    v.setCreateDate(date);
        //     v.setUpdateDate(date);
        //     v.setParameterID(b.getParameterID());
       //      v.setTerminalGroupID(seletermgroup);
       //      v.setParmetervalue("0");
         //    tgroupHasParameterFacade.create(v);
            //   Pchildparent pc=pchildparentFacade.find_parameter(b.getParameterID().getParametertypeID());
            //   if(pc.getRoot() == 1){
             //      Pgchildparent cd=new Pgchildparent();
           //        cd.setRoot(1);
           //        cd.setChildNo(0);
           //        cd.setTgrouphasparameterID(v);
          //         cd.setTgrouphasparameterID1(v);
          //         pgchildparentFacade.create(cd);
           //    }else{
               
               
           //    }
              
              
             
             
           }
                   
          }
               
   
  
            //    groupHasparameter=tgroupHasParameterFacade.find_term_groups(seletermgroup);
           
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin",2);
         }
              }
              
              
                          if(selectpara != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {

                for(int i=0;i<selectpara.size();i++){
               
      //     TgroupHasParameter v=new TgroupHasParameter();
     //        v.setCreateDate(date);
     //        v.setUpdateDate(date);
      //       v.setParameterID(selectpara.get(i));
      //       v.setTerminalGroupID(seletermgroup);
         //    v.setParmetervalue("0");
        //     tgroupHasParameterFacade.create(v);      
          }
               
   
  
           //    groupHasparameter=tgroupHasParameterFacade.find_term_groups(seletermgroup);
           
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin",2);
         }
              }
         
     
     }
    
     public void onDragDrop(TreeDragDropEvent event) {
           date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        int dropIndex = event.getDropIndex();
       
        PGroup_tree xa=(PGroup_tree)dragNode.getData();
        PGroup_tree xb=(PGroup_tree)dropNode.getData();
        
         System.out.println("onDragDrop() "+xa.getParameterGroup()+" "+xa.getId());
          System.out.println("onDragDrop1() "+xb.getParameterGroup()+" "+xb.getId());
       
        ParameterGroup a1=parameterGroupFacade.find(xa.getId());
        ParameterGroup b1=parameterGroupFacade.find(xb.getId());
        
        
       //  System.out.println("onDragDrop() "+a1.getGroupname()+" "+a1.getParametertypeID().getType());
     //     System.out.println("onDragDrop() "+b1.getGroupname()+" "+b1.getParametertypeID().getType());
        
    if(xb.getId() == 0  && (a1.getParametertypeID().getId() == 1 || a1.getParametertypeID().getId() > 4) ){
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setCreateDate(date);
            tg.setUpdateDate(date);
            tgroupHasGparameterFacade.create(tg);
            xa.setCount(tg.getId());
            Pgchild tg1=new Pgchild();
            tg1.setTgrouphasGparameterID(tg);
            tg1.setTgrouphasGparameterID1(tg);
            tg1.setRoot(1);
            tg1.setChild(0);
            pgchildFacade.create(tg1);
            List<GroupHasParameter> tg2=groupHasParameterFacade.get_para_group(a1);
            for(GroupHasParameter cd:tg2){
                ParameterValues tg3=new ParameterValues();
                tg3.setTgrouphasGparameterID(tg);
                tg3.setParameterID(cd.getParameterID());
                tg3.setValue(cd.getParameterID().getDefaultvalue());
                parameterValuesFacade.create(tg3);
            }
            
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + a1.getParametertypeID().getType(), "Dropped on " + xb.getId() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            try {
                
          
        
        if(a1.getParametertypeID().getId()== 2 && b1.getParametertypeID().getId()== 1){
            
             TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setCreateDate(date);
            tg.setUpdateDate(date);
            tgroupHasGparameterFacade.create(tg);
            
           TgroupHasGparameter ss= tgroupHasGparameterFacade.find(xb.getCount()); 
             Pgchild tg1=new Pgchild();
            tg1.setTgrouphasGparameterID(tg);
            tg1.setTgrouphasGparameterID1(ss);
            tg1.setRoot(0);
            tg1.setChild(1);
            pgchildFacade.create(tg1);
            xa.setCount(tg.getId());
            List<GroupHasParameter> tg2=groupHasParameterFacade.get_para_group(a1);
            for(GroupHasParameter cd:tg2){
                ParameterValues tg3=new ParameterValues();
                tg3.setTgrouphasGparameterID(tg);
                tg3.setParameterID(cd.getParameterID());
                tg3.setValue("0");
                parameterValuesFacade.create(tg3);
            }
            
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged 2 " + a1.getParametertypeID().getType(), "Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }else if(a1.getParametertypeID().getId()== 3 && b1.getParametertypeID().getId()== 2){
        
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setCreateDate(date);
            tg.setUpdateDate(date);
            tgroupHasGparameterFacade.create(tg);
            
           TgroupHasGparameter ss= tgroupHasGparameterFacade.find(xb.getCount()); 
             Pgchild tg1=new Pgchild();
            tg1.setTgrouphasGparameterID(tg);
            tg1.setTgrouphasGparameterID1(ss);
            tg1.setRoot(0);
            tg1.setChild(2);
            pgchildFacade.create(tg1);
            xa.setCount(tg.getId());
            List<GroupHasParameter> tg2=groupHasParameterFacade.get_para_group(a1);
            for(GroupHasParameter cd:tg2){
                ParameterValues tg3=new ParameterValues();
                tg3.setTgrouphasGparameterID(tg);
                tg3.setParameterID(cd.getParameterID());
                tg3.setValue("0");
                parameterValuesFacade.create(tg3);
            }
            
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged 2 " + a1.getParametertypeID().getType(), "Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        }else if(a1.getParametertypeID().getId()== 4 && b1.getParametertypeID().getId()== 3){
        
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setCreateDate(date);
            tg.setUpdateDate(date);
            tgroupHasGparameterFacade.create(tg);
            
           TgroupHasGparameter ss= tgroupHasGparameterFacade.find(xb.getCount()); 
             Pgchild tg1=new Pgchild();
            tg1.setTgrouphasGparameterID(tg);
            tg1.setTgrouphasGparameterID1(ss);
            tg1.setRoot(0);
            tg1.setChild(3);
            pgchildFacade.create(tg1);
            xa.setCount(tg.getId());
            List<GroupHasParameter> tg2=groupHasParameterFacade.get_para_group(a1);
            for(GroupHasParameter cd:tg2){
                ParameterValues tg3=new ParameterValues();
                tg3.setTgrouphasGparameterID(tg);
                tg3.setParameterID(cd.getParameterID());
                tg3.setValue("0");
                parameterValuesFacade.create(tg3);
            }
            
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged 2 " + a1.getParametertypeID().getType(), "Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        }else{
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "no Dragged " + a1.getParametertypeID().getType(), "no Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        }
        
          } catch (Exception e) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "no Dragged 2 " + a1.getParametertypeID().getType(), "no Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
            }
        }
        
                
               paragroup=parameterGroupFacade.findAll();
            // System.out.println("hamed "+groupHasGparameter.size());
             
             root1 = new DefaultTreeNode(new PGroup_tree("Groups",0,0,"root"), null);
             for(ParameterGroup b:paragroup){
         new DefaultTreeNode(new PGroup_tree(b.getGroupname(),0,b.getId(),b.getParametertypeID().getType()), root1);
        
             }
      

       groupHasGparameter=tgroupHasGparameterFacade.find_term_groups(seletermgroup);
        root2 = new DefaultTreeNode(new PGroup_tree("Groups",0,0,"root"), null);
         root2.setExpanded(true);
        TreeNode item0 = new DefaultTreeNode(new PGroup_tree("XML root",0,0,"root"), root2);
        item0.setExpanded(true);
         List<TreeNode> roots=new ArrayList<TreeNode>();
         List<TreeNode> child1=new ArrayList<TreeNode>();
       
        for(TgroupHasGparameter sl:groupHasGparameter){
             try {
                 List<Pgchild> ad= pgchildFacade.childs_find(sl);
                 
                 for(Pgchild pa:ad){
                  if(pa.getRoot()==1){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(sl.getParameterGroupID().getGroupname(),sl.getId(),sl.getParameterGroupID().getId(),sl.getParameterGroupID().getParametertypeID().getType()), item0);
                  roots.add(f);
                    f.setExpanded(true);
                  }
                  }

                 
                   } catch (Exception e) {
                   }
        }
        
        if(!roots.isEmpty()){
            for(TreeNode f1:roots){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
            System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 1){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                  child1.add(f);     
                   f.setExpanded(true);
                     }
                  }
            
            }
            
            
            roots.clear();
             if(!child1.isEmpty()){
            for(TreeNode f1:child1){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
            System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 2){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                  roots.add(f);   
                   f.setExpanded(true);
                     }
                  }
            
            }
            
            
          child1.clear();
             if(!roots.isEmpty()){
            for(TreeNode f1:roots){
            PGroup_tree a=(PGroup_tree) f1.getData();
            TgroupHasGparameter b=tgroupHasGparameterFacade.find(a.getCount());
                
            List<Pgchild> ad= pgchildFacade.childs_find(b); 
            
         //   System.out.println("hamed "+ad);
                for(Pgchild pa:ad){ 
                     if(pa.getRoot()== 0 && pa.getChild() == 3){
                  TreeNode f = new DefaultTreeNode(new PGroup_tree(pa.getTgrouphasGparameterID().getParameterGroupID().getGroupname(),pa.getTgrouphasGparameterID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getId(),pa.getTgrouphasGparameterID().getParameterGroupID().getParametertypeID().getType()), f1);
                     f.setExpanded(true);
                     }
                  }
            
            }
            
            
            
            
        
        }   
            
        
        }
            
        
        }
          

      
         
      
    }
     
     
       public void onNodeSelect(NodeSelectEvent event) {
           PGroup_tree xa=(PGroup_tree)event.getTreeNode().getData();
         TgroupHasGparameter xb=  tgroupHasGparameterFacade.find(xa.getCount());
           TParameterValues=parameterValuesFacade.ParameterValues_find(xb);

    }
       
       
            public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          seletParameterValues=((ParameterValues) event.getObject());
           // seletParameterValues.setUpdateDate(date);
          parameterValuesFacade.edit(seletParameterValues);
          
          Messages.addInfoMessage("Edited "+((ParameterValues) event.getObject()).getParameterID().getFieldName(),1);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ParameterValues) event.getObject()).getParameterID().getFieldName(),1);
    }
    
    
    
    
    
        
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static String ftpHost;
	private static int ftpPort;

        // TODO Auto-generated catch block
        static {
    ftpHost = "localhost";
    ftpPort = 990;
    System.out.println("ftpHost=" + ftpHost);
    System.out.println("ftpPort=" + ftpPort);
	}
    
    
    public void ExportP(RowEditEvent event) {
            groupHasTerminal=tgroupHasTerminalFacade.find_term_groups(seletermgroup);
            for(TgroupHasTerminal d:groupHasTerminal){
              getXML(d);
            }
             
             Messages.addInfoMessage("Exported "+seletermgroup.getGroupname(),1);
       
    }
    
    
    
    
    public static String getXML(TgroupHasTerminal terminals){
    
        
        
        try {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            dbfac.setValidating(true);
            
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element root = doc.createElement("TerminalXML"); 
            
            Element e = doc.createElement("terminalId");
	    e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getId())));
             root.appendChild(e);
             
            e = doc.createElement("tid");
			e.appendChild(doc.createTextNode(terminals.getTerminalID().getTid()));
			root.appendChild(e);


			e = doc.createElement("detailAddress");
			e.appendChild(doc.createTextNode(terminals.getTerminalID().getAddress()));
			root.appendChild(e);

			
			e = doc.createElement("merchantName");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getMerchantName())));
			root.appendChild(e);

			e = doc.createElement("officeContact");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOwnerName())));
			root.appendChild(e);

			e = doc.createElement("officeTelNo");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOfficeTelNo())));
			root.appendChild(e);

			e = doc.createElement("ownerName");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOwnerName())));
			root.appendChild(e);

			e = doc.createElement("posSerialNo");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getPOSSerialNo())));
			root.appendChild(e);

			e = doc.createElement("recordNo");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getId())));
			root.appendChild(e);

			e = doc.createElement("shopContact");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getContactperson())));
			root.appendChild(e);

			e = doc.createElement("shopName");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getShopName())));
			root.appendChild(e);

			e = doc.createElement("shopTelNo");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTelNo())));
			root.appendChild(e);

			e = doc.createElement("status");
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTerminalstatusID().getTstatus())));
			root.appendChild(e);

			
                        
                        
                        
            doc.appendChild(root);
                        
                        
            TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();

			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString().replaceAll("\n", "\r\n");
			 FileUtils.write(new File("D:\\ahmed.txt"), xmlString);

			return xmlString;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
}
