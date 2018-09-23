/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.Accessory;
import Entities.AccessoryGroup;
import Entities.AccessoryHasGroup;
import Entities.Application;
import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Entities.Application_;
import Entities.EmailLog;

import Entities.GroupHasParameter;
import Entities.Parameter;
import Entities.ParameterGroup;
import Entities.ParameterValues;
import Entities.ParamterDefault;
import Entities.Pgchild;
import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TerminalHasParts;
import Entities.TerminalTemplate;
import Entities.TgroupHasAccesory;
import Entities.TgroupHasGparameter;
import Entities.TgroupHasSoftware;
import Entities.TgroupHasTerminal;
import Facades.AccessoryGroupFacadeLocal;
import Facades.AccessoryHasGroupFacadeLocal;
import Facades.ApplicationGroupFacadeLocal;
import Facades.ApplicationHasGroupFacadeLocal;
import Facades.EmailLogFacadeLocal;
import Facades.FtpMessagesFacadeLocal;
import Facades.GroupHasParameterFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
import Facades.ParameterValuesFacadeLocal;
import Facades.ParamterDefaultFacadeLocal;
import Facades.PgchildFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.TerminalHasPartsFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
import Facades.TgroupHasAccesoryFacadeLocal;
import Facades.TgroupHasGparameterFacadeLocal;
import Facades.TgroupHasSoftwareFacadeLocal;
import Facades.TgroupHasTerminalFacadeLocal;
import Facades.UserFacadeLocal;
import com.timer.schedual.business;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private business businessfacade;

    @EJB
    private TerminalHasPartsFacadeLocal terminalHasPartsFacade;

    @EJB
    private AccessoryHasGroupFacadeLocal accessoryHasGroupFacade;
    
    

    @EJB
    private ApplicationHasGroupFacadeLocal applicationHasGroupFacade;

    @EJB
    private FtpMessagesFacadeLocal ftpMessagesFacade;

   
    
           @EJB
    private ParamterDefaultFacadeLocal ParamterDefaultFacade;
    

    @EJB
    private EmailLogFacadeLocal emailLogFacade;

  
    
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
          
          
          
          
          String eportedxml;
          
         String defvalue =new String() ;
          
          boolean defvalue1 = false ;
          
          
             private TreeNode root1;
     
    private TreeNode root2;
     
    private TreeNode selectedNode1;
     
    private TreeNode selectedNode2;
    
    PGroup_tree selectxa;
    PGroup_tree selectparent;
    List<TreeNode> childs;
    
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

      public String getDefvalue() {
        return defvalue;
    }

    public void setDefvalue(String defvalue) {
        this.defvalue = defvalue;
    }

    public boolean isDefvalue1() {
        return defvalue1;
    }

    public void setDefvalue1(boolean defvalue1) {
        this.defvalue1 = defvalue1;
    }
    
    
    

    public String getEportedxml() {
        return eportedxml;
    }

    public void setEportedxml(String eportedxml) {
        this.eportedxml = eportedxml;
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
             //Login.login=userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

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
           
        //    email("open Terminal Group", "SPECTRA TMS APP");     
           
           
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
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 15);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 15);
                /*end mohammed.ayad*/
            }
}
   
    }

    
          public String Addgroup(ActionEvent actionEvent){
         
        if(terminalGroupFacade.group_find(termgroup.getGroupname())){
               Messages.addInfoMessage("Duplicated",2,15);
        }else{
             Messages.addInfoMessage("ADDED",1,15);
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
              refresh();
     
            
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
          
          Messages.addInfoMessage("Edited "+((TerminalGroup) event.getObject()).getGroupname(),1,15);
    }  
    public void onRowCancelTGroup(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TerminalGroup) event.getObject()).getGroupname(),1,15);
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
                   
                   
             Messages.addInfoMessage("removed "+seletermgroup.getGroupname(),1,15);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+seletermgroup.getGroupname()+" return to Admin "+e.getMessage(),3,15);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2,15);
   
              }
         
     
     }
      
      
      
      
    public void onRowEditT(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasTerminal=((TgroupHasTerminal) event.getObject());
           selegroupHasTerminal.setUpdateDate(date);
          tgroupHasTerminalFacade.edit(selegroupHasTerminal);
          selegroupHasTerminal.getTerminalID().setUpdateDate(date);
          terminalFacade.edit(selegroupHasTerminal.getTerminalID());
          Messages.addInfoMessage("Edited "+((TgroupHasTerminal) event.getObject()).getTerminalID().getTid(),1,15);
    } 
    public void onRowCancelT(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasTerminal) event.getObject()).getTerminalID().getTid(),1,15);
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
             
                   
                   
             Messages.addInfoMessage("removed "+selegroupHasTerminal.getTerminalID().getTid(),1,15);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasTerminal.getTerminalID().getTid()+" return to Admin "+e.getMessage(),3,15);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal",2,15);
   
              }
         
     
     }      
    public void ADDT(ActionEvent actionEvent){
              if(selectTerminals != null && seletermgroup !=null){  
                   date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          // please add remove group
         try {
               
                 for(int i=0;i<selectTerminals.size();i++){
                     Terminal terms= selectTerminals.get(i);
              TgroupHasTerminal a=new TgroupHasTerminal();
              a.setTerminalGroupID(seletermgroup);
              a.setTerminalID(selectTerminals.get(i)); 
              a.setCreateDate(date);
              a.setUpdateDate(date);
              a.setXMLupdate(1);
              tgroupHasTerminalFacade.create(a);
               Messages.addInfoMessage("ADD "+selectTerminals.get(i).getTid()+" to "+seletermgroup.getGroupname(),1,15);
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
              Messages.addInfoMessage("return to Admin "+e.getMessage(),3,15);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2,15);
   
              }
         
     
     }
    
    
    
    public void onRowEditTS(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasSoftware=((TgroupHasSoftware) event.getObject());
          selegroupHasSoftware.setUpdateDate(date);
          tgroupHasSoftwareFacade.edit(selegroupHasSoftware);
          selegroupHasSoftware.getApplicationGroupID().setUpdateDate(date);
          applicationGroupFacade.edit(selegroupHasSoftware.getApplicationGroupID());
          Messages.addInfoMessage("Edited "+((TgroupHasSoftware) event.getObject()).getApplicationGroupID().getGroupname(),1,15);
    }
    public void onRowCancelTS(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasSoftware) event.getObject()).getApplicationGroupID().getGroupname(),1,15);
    }
    public void removeTS(ActionEvent actionEvent){
              if(selegroupHasSoftware != null){  
          // please add remove group
         try {
                   tgroupHasSoftwareFacade.remove(selegroupHasSoftware);
                   
           
        groupHasSoftware=tgroupHasSoftwareFacade.find_term_groups(seletermgroup);
         
                   
             Messages.addInfoMessage("removed "+selegroupHasSoftware.getApplicationGroupID().getGroupname(),1,15);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasSoftware.getApplicationGroupID().getGroupname()+" return to Admin "+e.getMessage(),3,15);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose APP Group",2,15);
   
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
              a.setXMLupdate(1);
              tgroupHasSoftwareFacade.create(a);
                   Messages.addInfoMessage("ADD "+selectAppgroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1,15);
         
              } catch (Exception e) {
                  e.printStackTrace();
              }
                    
          }
  
              groupHasSoftware=tgroupHasSoftwareFacade.find_term_groups(seletermgroup);
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin "+e.getMessage(),3,15);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2,15);
   
              }
         
     
     }
    
    
    
    public void onRowEditA(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          selegroupHasAccesory=((TgroupHasAccesory) event.getObject());
          selegroupHasAccesory.setUpdateDate(date);
          tgroupHasAccesoryFacade.edit(selegroupHasAccesory);
          selegroupHasAccesory.getAccessoryGroupID().setUpdateDate(date);
          accessoryGroupFacade.edit(selegroupHasAccesory.getAccessoryGroupID());
          Messages.addInfoMessage("Edited "+((TgroupHasAccesory) event.getObject()).getAccessoryGroupID().getGroupname(),1,15);
    }
    public void onRowCancelA(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((TgroupHasAccesory) event.getObject()).getAccessoryGroupID().getGroupname(),1,15);
    }
    public void removeA(ActionEvent actionEvent){
              if(selegroupHasAccesory != null){  
          // please add remove group
         try {
                   tgroupHasAccesoryFacade.remove(selegroupHasAccesory);
                   
           
        groupHasAccesory=tgroupHasAccesoryFacade.find_term_groups(seletermgroup);
         
                   
             Messages.addInfoMessage("removed "+selegroupHasAccesory.getAccessoryGroupID().getGroupname(),1,15);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selegroupHasAccesory.getAccessoryGroupID().getGroupname()+" return to Admin "+e.getMessage(),3,15);
        e.printStackTrace();
         }
              }else{
                         Messages.addInfoMessage("Please choose Accessory Group",2,15);
   
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
              a.setXMLupdate(1);
              tgroupHasAccesoryFacade.create(a);
           Messages.addInfoMessage("ADD "+selectAcessorygroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1,15);
         
          }
               
   
  
              groupHasAccesory=tgroupHasAccesoryFacade.find_term_groups(seletermgroup);
         } catch (Exception e) {
              Messages.addInfoMessage("return to Admin "+e.getMessage(),3,15);
         }
              }else{
                         Messages.addInfoMessage("Please choose terminal Group",2,15);
   
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
            a.setXMLupdate(1);
            a.setCreateDate(date);
            a.setUpdateDate(date);
            tgroupHasGparameterFacade.create(a);
           Messages.addInfoMessage("ADD "+selectparagroup.get(i).getGroupname()+" to "+seletermgroup.getGroupname(),1,15);
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
              Messages.addInfoMessage("return to Admin "+e.getMessage(),3,15);
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
              Messages.addInfoMessage("return to Admin "+e.getMessage(),3,15);
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
        
        
         System.out.println("onDragDrop() "+a1.getGroupname()+" "+a1.getParametertypeID().getType());
     //     System.out.println("onDragDrop() "+b1.getGroupname()+" "+b1.getParametertypeID().getType());
        
    if(xb.getId() == 0  && (a1.getParametertypeID().getId() == 1 || a1.getParametertypeID().getId() > 4) ){
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setXMLupdate(1);
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
            tg.setXMLupdate(1);
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
                tg3.setValue(cd.getParameterID().getDefaultvalue());
                parameterValuesFacade.create(tg3);
            }
            
           
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged 2 " + a1.getParametertypeID().getType(), "Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }else if(a1.getParametertypeID().getId()== 3 && b1.getParametertypeID().getId()== 2){
        
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setXMLupdate(1);
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
                tg3.setValue(cd.getParameterID().getDefaultvalue());
                parameterValuesFacade.create(tg3);
            }
            
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged 2 " + a1.getParametertypeID().getType(), "Dropped on " + b1.getParametertypeID().getType() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        }else if(a1.getParametertypeID().getId()== 4 && b1.getParametertypeID().getId()== 3){
        
            TgroupHasGparameter tg=new TgroupHasGparameter();
            tg.setParameterGroupID(a1);
            tg.setTerminalGroupID(seletermgroup);
            tg.setXMLupdate(1);
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
               tg3.setValue(cd.getParameterID().getDefaultvalue());
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
        Messages.addInfoMessage(e.getMessage(), 3, 15);
        
            }
        }
        
 
         refresh();
    }
     
     
     
    void refresh(){
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
                       Messages.addInfoMessage(e.getMessage(), 3, 15);
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
    
    
     public List<String> getdefval(Parameter para) {
         
         List<String> defval=new ArrayList<>();
         
              List<ParamterDefault>  def= ParamterDefaultFacade.get_default(para);
              //  System.out.println("com.guardian.Login.Terminalgroup.onNodeSelect() "+def.size());
                for(ParamterDefault f:def){
                    defval.add(f.getPvalues());
                } 
                
                return defval;
     }
     
     
       public void onNodeSelect(NodeSelectEvent event) {
           
                  System.out.println("onNodeSelect");
           PGroup_tree xa=(PGroup_tree)event.getTreeNode().getData();
            selectxa=xa;   
            selectparent=(PGroup_tree)event.getTreeNode().getParent().getData();  
            childs=event.getTreeNode().getChildren();
         TgroupHasGparameter xb=  tgroupHasGparameterFacade.find(xa.getCount());
           TParameterValues=parameterValuesFacade.ParameterValues_find(xb);


    }
       
       
        public void removenode(ActionEvent actionEvent){
            
             System.out.println("onNodeRemove");
             System.out.println("onNodeRemove "+selectxa);
            if(selectxa !=null){
                
                 
                 if(!childs.isEmpty()){
                         Messages.addInfoMessage("please remove Child First",2,15); 
                    }else{
                     
              
                    
                     TgroupHasGparameter parent=  tgroupHasGparameterFacade.find(selectparent.getCount());
                    TgroupHasGparameter child=  tgroupHasGparameterFacade.find(selectxa.getCount());
                    try {
                      
                    Pgchild xb=pgchildFacade.Pchild_find(parent, child); 
                   //  System.out.println("hamed "+xb.getId());
                     if(xb!=null){
                    pgchildFacade.remove(xb);
                    List<ParameterValues> j=parameterValuesFacade.ParameterValues_find(child);
                    for(ParameterValues k:j){
                    parameterValuesFacade.remove(k);
                    }
                    tgroupHasGparameterFacade.remove(child);
                     }
                   
                    
                    
                         refresh();
                } catch (Exception e) {
                    Messages.addInfoMessage(e.getMessage(), 3, 15);
                }
               
                    }
                    childs.clear();
                 
                   refresh();
                
            }
       }
       
       
            public void onRowEdit(RowEditEvent event) {
                
                  System.out.println("edit ");
               
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          seletParameterValues=((ParameterValues) event.getObject());
          if(null== seletParameterValues.getParameterID().getParamtertypeID().getId()){
              seletParameterValues.setValue(String.valueOf(defvalue));
          }else switch (seletParameterValues.getParameterID().getParamtertypeID().getId()) {
            case 2:
                seletParameterValues.setValue(String.valueOf(defvalue1));
                break;
            case 3:
              
                  seletParameterValues.setValue(String.valueOf(defvalue));
                break;
            default:
                seletParameterValues.setValue(String.valueOf(defvalue));
                break;
        }
          
         
          
           // seletParameterValues.setUpdateDate(date);
          parameterValuesFacade.edit(seletParameterValues);
          
          Messages.addInfoMessage("Edited "+((ParameterValues) event.getObject()).getParameterID().getFieldName(),1,15);
    }
     
    public void onRowCancel(RowEditEvent event) {
          Messages.addInfoMessage("Cancelled "+((ParameterValues) event.getObject()).getParameterID().getFieldName(),1,15);
    }
    
 
    
    public void ExportP(RowEditEvent event) {
        if(seletermgroup == null){
           Messages.addInfoMessage("Please select Terminal Group ",2,15);
           eportedxml="NO XML";
        }else{
            
           
        StringBuffer m=new StringBuffer();
            groupHasTerminal=tgroupHasTerminalFacade.findAll();   
            for(TgroupHasTerminal d:groupHasTerminal){
                try {
                       businessfacade.execute(d);
                    m.append(getXML(d));
                      m.append("\n");
                } catch (Exception e) {
                    email("Error : XML Not exported", "SPOECTRA TMS APP");     
                    e.printStackTrace();
                    Messages.addInfoMessage(e.getMessage(), 3, 15);
                }
           
            }
            
            eportedxml=m.toString();    
             Messages.addInfoMessage("XML View For "+seletermgroup.getGroupname(),1,15);
        }
    }
    
    
    
    
       public  String getXML(TgroupHasTerminal terminals){ 
        
        if(terminals.getTerminalGroupID() == null){
        
        }else{
        
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
            if(terminals.getTerminalID().getTid()!=null){
            e.appendChild(doc.createTextNode(terminals.getTerminalID().getTid()));
            }
	    root.appendChild(e);


			e = doc.createElement("detailAddress");
                         if(terminals.getTerminalID().getAddress()!=null){
          e.appendChild(doc.createTextNode(terminals.getTerminalID().getAddress()));
            }
	
			root.appendChild(e);

			
			e = doc.createElement("merchantName");
                         if(terminals.getTerminalID().getMerchantName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getMerchantName())));
                         }
                        root.appendChild(e);

			e = doc.createElement("officeContact");
                         if(terminals.getTerminalID().getOfficeContact()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOfficeContact())));
                         }
                        root.appendChild(e);

			e = doc.createElement("officeTelNo");
                         if(terminals.getTerminalID().getOfficeTelNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOfficeTelNo())));
                         }
                        root.appendChild(e);

			e = doc.createElement("ownerName");
                         if(terminals.getTerminalID().getOwnerName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getOwnerName())));
                         }
                        root.appendChild(e);

			e = doc.createElement("posSerialNo");
                         if(terminals.getTerminalID().getPOSSerialNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getPOSSerialNo())));
                         }
                        root.appendChild(e);

			e = doc.createElement("recordNo");
                         if(terminals.getTerminalID().getId()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getId())));
                         }
			root.appendChild(e);

			e = doc.createElement("shopContact");
                         if(terminals.getTerminalID().getContactperson()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getContactperson())));
                         }
                        root.appendChild(e);

			e = doc.createElement("shopName");
                         if(terminals.getTerminalID().getShopName()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getShopName())));
                         }
			root.appendChild(e);

			e = doc.createElement("shopTelNo");
                         if(terminals.getTerminalID().getTelNo()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTelNo())));
                         }
			root.appendChild(e);

			e = doc.createElement("status");
                         if(terminals.getTerminalID().getTerminalstatusID()!=null){
			e.appendChild(doc.createTextNode(String.valueOf(terminals.getTerminalID().getTerminalstatusID().getTstatus())));
                         }
                         root.appendChild(e);
                         
                         
              	
                        if ((terminals.getTerminalID().getTerminaltemplateID() != null)) {
				
                                
                         List<TerminalHasParts> ter=terminalHasPartsFacade.get_part_group(terminals.getTerminalID().getTerminaltemplateID());
				if( ter !=null || ter.size()>0){
                         Element posTerminalTag = doc.createElement("PosTerminal");

				root.appendChild(posTerminalTag);
                         
				 for (TerminalHasParts ag : ter) {
                                   
					Element e2 = doc.createElement("Part");
					posTerminalTag.appendChild(e2);
					Element e3 = doc.createElement("partId");
					e3.appendChild(doc.createTextNode(String.valueOf(ag.getPartsID().getId())));
					e2.appendChild(e3);
					e3 = doc.createElement("qty");
					e3.appendChild(doc.createTextNode(String.valueOf(ag.getPartsID().getPName())));
					e2.appendChild(e3);
                                      
				}
                                 
                                }
			}     
                     
                         
                         
                        List<TgroupHasAccesory> groupacess = tgroupHasAccesoryFacade.find_term_groups(terminals.getTerminalGroupID());
                  	
                        if ((groupacess != null) && (!groupacess.isEmpty())) {
				Element accessoryTag = doc.createElement("Accessory");

				root.appendChild(accessoryTag);
				 for (TgroupHasAccesory ag : groupacess) {
                                        List<AccessoryHasGroup> acess=accessoryHasGroupFacade.get_app_group(ag.getAccessoryGroupID());
				
                                      for (AccessoryHasGroup as : acess) {
					Element e2 = doc.createElement("Accessory");

					accessoryTag.appendChild(e2);
					Element e3 = doc.createElement("accessoryId");
					e3.appendChild(doc.createTextNode(String.valueOf(as.getAccessoryID().getId())));
					e2.appendChild(e3);
					e3 = doc.createElement("qty");
					e3.appendChild(doc.createTextNode(String.valueOf(as.getAccessoryID().getAccName())));
					e2.appendChild(e3);
                                      }
				}
			}     
                         
                         
                         
                         
                       List<TgroupHasSoftware> groupApp = tgroupHasSoftwareFacade.find_term_groups(terminals.getTerminalGroupID());
                      //   System.out.println("com.guardian.Login.Terminalgroup.getXML() "+groupApp.size());
                         if ((groupApp != null) && (!groupApp.isEmpty())) {
				Element applicationTag = doc.createElement("ApplicationGroup");
                                root.appendChild(applicationTag);
                                for (TgroupHasSoftware ag : groupApp) {
                                    List<ApplicationHasGroup> appss=applicationHasGroupFacade.get_app_group(ag.getApplicationGroupID());
					for (ApplicationHasGroup app : appss) {
                                            
                                     
						Element e2 = doc.createElement("Application");

						applicationTag.appendChild(e2);

						Element e3 = doc.createElement("applicationId");
						e3.appendChild(doc.createTextNode(String.valueOf(app.getApplicationID().getId())));
						e2.appendChild(e3);
						e3 = doc.createElement("name");
						e3.appendChild(doc.createTextNode(app.getApplicationID().getAppName()));
						e2.appendChild(e3);
						e3 = doc.createElement("fieldName");
						e3.appendChild(doc.createTextNode(app.getApplicationID().getFilename()));
						e2.appendChild(e3);
						e3 = doc.createElement("fileSize");
						e3.appendChild(doc.createTextNode(String.valueOf(app.getApplicationID().getAppSize())));
						e2.appendChild(e3);

					}
				}
                                
                         }
                         
                         
                        
                        
                             List<TgroupHasGparameter> group= tgroupHasGparameterFacade.find_term_groups(terminals.getTerminalGroupID());
                        List<TgroupHasGparameter> group1=new ArrayList<>();
                         List<TgroupHasGparameter> group2=new ArrayList<>();
                        group2.addAll(group);
                        
                      //  System.out.println("gy "+group);
                         
                         for(int i=1;i<5;i++){
                             
                                for(TgroupHasGparameter gg:group){
                             
                                 if(null!=gg.getParameterGroupID().getParametertypeID().getId()){
                                     
                      if (gg.getParameterGroupID().getParametertypeID().getId() == i) {
                        //  System.out.println("group "+gg.getParameterGroupID().getParametertypeID().getId());
                             group1.add(gg);
                             group2.remove(gg);
                      }
                                 } 
                             }
                         
                         }
                     
                          //   System.out.println("gy1 "+group1);
                         //    System.out.println("gy2 "+group2);
                            if (((group1 != null) && (!group1.isEmpty())) || ((group2 != null) && (!group2.isEmpty())) ) {  
                              Element groupTag = doc.createElement("ParameterGroup");
                          if ((group1 != null) && (!group1.isEmpty())) {
                            
                            Pgchild pg = null;
                            Pgchild pg1 = null;
                            Pgchild pg2=null;
                            List<TgroupHasGparameter> terminal_pg = new ArrayList<>();
                            List<TgroupHasGparameter> Accq_pg = new ArrayList<>();
                            List<TgroupHasGparameter> Issuer_pg = new ArrayList<>();
                            
                            int terminal_count=0;
                            int Accq_count=0;
                            int Issuer_count=0;
                            int Card_count=0;
                             int select=0;
                             
                        // System.out.println("sd "+group1);     
                    for(TgroupHasGparameter gg:group1){
                        
                          List<ParameterValues> v=parameterValuesFacade.ParameterValues_find(gg);
                        
                      //  System.out.println("group "+gg);
                      
                      
    
                            Element groupName = doc.createElement(gg.getParameterGroupID().getParametertypeID().getXMLheader());
                        
                        groupName.setAttribute("ID", gg.getParameterGroupID().getId().toString());
						groupName.setIdAttribute("ID", true);

						if (groupName.getTagName().equals("Terminal"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Acquirer"))
							groupName.setAttribute("Level", "2");
						else if (groupName.getTagName().equals("Issuer"))
							groupName.setAttribute("Level", "3");
						else if (groupName.getTagName().equals("CardRange"))
							groupName.setAttribute("Level", "4");
						else if (groupName.getTagName().equals("EMVLevel2Key"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVLevel2App"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVCtlApp"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Other"))
							groupName.setAttribute("Level", "1");
                                                
                            
                              
                               e = doc.createElement("ID");
                               e.appendChild(doc.createTextNode(gg.getParameterGroupID().getId().toString()));
                         
			            groupName.appendChild(e);
                                    
                        if (groupName.getTagName().equals("Terminal")){
                        //    System.out.println("Terminal");
                             terminal_pg.add(gg);
                             terminal_count++;
                        }else if (groupName.getTagName().equals("Acquirer")&& terminal_pg != null)
                        {
                         //    System.out.println("Acquirer");
                        pg=  pgchildFacade.Pchild_find(terminal_pg.get(terminal_count-1),terminal_pg.get(terminal_count-1));                                  
                        e = doc.createElement("TerminalID");
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString())); 
			groupName.appendChild(e);
                        Accq_pg.add(gg);
                        Accq_count++;
                                                 
                        }
			else if (groupName.getTagName().equals("Issuer") && pg !=null && Accq_pg !=null )
                         {              
                      //  System.out.println("Issuer");
                         e = doc.createElement("TerminalID");
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString()));  
			groupName.appendChild(e);
                        // System.out.println("acc "+Accq_pg);
                               
                        e = doc.createElement("AcquirerID");  
                          for(int y=0;y<Accq_pg.size();y++){
                        // System.out.println("A "+Accq_pg.get(y)+" "+gg);
                             
                              try {
                                    pg1=  pgchildFacade.Pchild_find(Accq_pg.get(y),gg);
                                    if(pg1==null){
                                    continue;
                                    }
                                   select=y;
                                //           System.out.println("OK1");
                       
		                  break;
                              } catch (Exception em) {
                              //     System.out.println("Error1");
                              }
                            
                          }
                    	e.appendChild(doc.createTextNode(pg1.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
			groupName.appendChild(e);
                        
                        Issuer_pg.add(gg);
                        Issuer_count++;
                                               
                                                }
			else if (groupName.getTagName().equals("CardRange")&& pg !=null && pg1 !=null && Accq_pg !=null && Issuer_pg != null)
                                                {
                                                    
                     
                         //  System.out.println("Issuer "+Issuer_pg);
                                                
                                 //     System.out.println("CardRange");               
                         e = doc.createElement("TerminalID");       
			e.appendChild(doc.createTextNode(pg.getTgrouphasGparameterID().getParameterGroupID().getId().toString()));
			groupName.appendChild(e);
                                                
                    e = doc.createElement("AcquirerID");
                     e.appendChild(doc.createTextNode(pg1.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
                    groupName.appendChild(e);
                        
                    e = doc.createElement("IssuerID");
                    for(int y=0;y<Issuer_pg.size();y++){
                       //  System.out.println("getXML() "+Issuer_pg.get(y)+" "+gg);
                               
                        try {
                      
                            pg2=  pgchildFacade.Pchild_find(Issuer_pg.get(y),gg);
                             if(pg2==null){
                                    continue;
                                    }
                         //     System.out.println("OK");
                               break;
                        } catch (Exception ec) {
                         //    System.out.println("error");
                        }
                     
                    }
                     e.appendChild(doc.createTextNode(pg2.getTgrouphasGparameterID1().getParameterGroupID().getId().toString()));
                    groupName.appendChild(e); 
                    
                   
                    
                    Card_count++;    
                                                }
                        
                        
                      
                       		
					
                              
                              
                 for(ParameterValues val:v){
                          e = doc.createElement(val.getParameterID().getFieldName());
                         if(val.getValue() !=null){
			e.appendChild(doc.createTextNode(String.valueOf(val.getValue())));
                         }
			groupName.appendChild(e);
                                                }
                                
                        
                        groupTag.appendChild(groupName);
                    }
                     }
                                        
                     if ((group2 != null) && (!group2.isEmpty())) {
                         
                         System.out.println("com.guardian.Login.Terminalgroup.getXML()");
                    
                       for(TgroupHasGparameter gg:group2){
                        
                          List<ParameterValues> v=parameterValuesFacade.ParameterValues_find(gg);
                        
                      //  System.out.println("group "+gg);
                      
                      
    
                            Element groupName = doc.createElement(gg.getParameterGroupID().getParametertypeID().getXMLheader());
                        
                        groupName.setAttribute("ID", gg.getParameterGroupID().getId().toString());
						groupName.setIdAttribute("ID", true);

						if (groupName.getTagName().equals("Terminal"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Acquirer"))
							groupName.setAttribute("Level", "2");
						else if (groupName.getTagName().equals("Issuer"))
							groupName.setAttribute("Level", "3");
						else if (groupName.getTagName().equals("CardRange"))
							groupName.setAttribute("Level", "4");
						else if (groupName.getTagName().equals("EMVLevel2Key"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVLevel2App"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("EMVCtlApp"))
							groupName.setAttribute("Level", "1");
						else if (groupName.getTagName().equals("Other"))
							groupName.setAttribute("Level", "1");
                                                
                            
                              
                               e = doc.createElement("ID");
                               e.appendChild(doc.createTextNode(gg.getParameterGroupID().getId().toString()));
                         
			            groupName.appendChild(e);
                                    
                                    
                                       for(ParameterValues val:v){
                          e = doc.createElement(val.getParameterID().getFieldName());
                         if(val.getValue() !=null){
			e.appendChild(doc.createTextNode(String.valueOf(val.getValue())));
                         }
			groupName.appendChild(e);
                                                }
                                       
                                       
                                       groupTag.appendChild(groupName);
                                    
                       }
                       
                     }
                       
                    
                     root.appendChild(groupTag);    
                            }              
                         
                         

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
			// FileUtils.write(new File("D:\\ahmed.txt"), xmlString);

			return xmlString;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
            Messages.addInfoMessage(ex.getMessage(), 3, 15);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
            Messages.addInfoMessage(ex.getMessage(), 3, 15);
        } catch (TransformerException ex) {
            Logger.getLogger(Terminalgroup.class.getName()).log(Level.SEVERE, null, ex);
            Messages.addInfoMessage(ex.getMessage(), 3, 15);
        }
        }
        return "";
    }
    
    
  public  void email(String text,String subject){
         Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        	EmailLog email=new EmailLog();
                email.setEsubject(text);
                email.setEtext(subject);
                email.setUserID(Login.login);
                email.setUpdateDate(date);
                email.setCreateDate(date);
                emailLogFacade.create(email);
      }     
    
}
