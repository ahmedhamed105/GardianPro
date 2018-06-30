/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.Application;
import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Entities.DownloadMethod;
import Entities.Parts;
import Entities.TerminalHasParts;
import Entities.TerminalTemplate;
import Facades.DownloadMethodFacadeLocal;
import Facades.PartsFacadeLocal;
import Facades.TerminalHasPartsFacadeLocal;
import Facades.TerminalTemplateFacadeLocal;
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
public class TerminalTemp {

    @EJB
    private DownloadMethodFacadeLocal downloadMethodFacade;

    @EJB
    private TerminalTemplateFacadeLocal terminalTemplateFacade;

    @EJB
    private TerminalHasPartsFacadeLocal terminalHasPartsFacade;

    @EJB
    private PartsFacadeLocal partsFacade;
     @EJB
    private UserFacadeLocal userFacade;
     
     


    
    
           private TreeNode root;
    
     Entities.TerminalTemplate terminal= new TerminalTemplate();
     
     List<TerminalTemplate> Terminals= new ArrayList<TerminalTemplate>();
     
      List<TerminalHasParts> ter_parts= new ArrayList<TerminalHasParts>();
      
        List<DownloadMethod> downloads= new ArrayList<DownloadMethod>();
      
       List<Parts> Parts= new ArrayList<Parts>();
       
        List<Parts> selparts= new ArrayList<Parts>();
        
        TerminalTemplate selectgroup=new TerminalTemplate();
        
        DownloadMethod seledownload=new DownloadMethod();
     
      java.sql.Date date ;
      
      private TreeNode selectdelte;
      
      
          /**
     * Creates a new instance of TerminalTemp
     */
    public TerminalTemp() {
    }
    
    
    
       public void init(){ FacesContext facesContext = FacesContext.getCurrentInstance();
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
             //Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/index.xhtml");

        }else{
            selectgroup=new TerminalTemplate();
            selparts= new ArrayList<Parts>();
             Terminals=terminalTemplateFacade.findAll();
             downloads=downloadMethodFacade.findAll();
             Parts=partsFacade.findAll();
     
       root = new DefaultTreeNode(new PGroup_tree("Groups",Terminals.size(),0,"root"), null);
      for(int i=0;i<Terminals.size();i++){
          try {
              ter_parts  = terminalHasPartsFacade.get_part_group(Terminals.get(i));
              
              System.out.println("group "+Terminals.get(i).getTName()+ter_parts.size());
              DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Terminals.get(i).getTName(),ter_parts.size(),Terminals.get(i).getId(),"GROUP"), root);
         
              for(int j=0;j<ter_parts.size();j++){
                   System.out.println("para "+ter_parts.get(j).getPartsID().getPName());
             DefaultTreeNode documentss = new DefaultTreeNode(new PGroup_tree(ter_parts.get(j).getPartsID().getPName(),1,ter_parts.get(j).getId(),"Part"), documents);
        
              }
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Terminals.get(i).getTName(),0,Terminals.get(i).getId(),"GROUP"), root);
                 /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 13);
                /*end mohammed.ayad*/
          }
         
      
      }
      
    
      
      
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 13);
            /*end mohammed.ayad*/
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                
                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                /*start mohammed.ayad*/
                Messages.addInfoMessage(ex.getMessage(), 3, 13);
                /*end mohammed.ayad*/
            }
}
   
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TerminalTemplate getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalTemplate terminal) {
        this.terminal = terminal;
    }



    public List<TerminalHasParts> getTer_parts() {
        return ter_parts;
    }

    public void setTer_parts(List<TerminalHasParts> ter_parts) {
        this.ter_parts = ter_parts;
    }

    public List<DownloadMethod> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<DownloadMethod> downloads) {
        this.downloads = downloads;
    }

    public List<Parts> getParts() {
        return Parts;
    }

    public void setParts(List<Parts> Parts) {
        this.Parts = Parts;
    }

    public List<Parts> getSelparts() {
        return selparts;
    }

    public void setSelparts(List<Parts> selparts) {
        this.selparts = selparts;
    }

    public TerminalTemplate getSelectgroup() {
        return selectgroup;
    }

    public void setSelectgroup(TerminalTemplate selectgroup) {
        this.selectgroup = selectgroup;
    }

    public DownloadMethod getSeledownload() {
        return seledownload;
    }

    public void setSeledownload(DownloadMethod seledownload) {
        this.seledownload = seledownload;
    }

    public TreeNode getSelectdelte() {
        return selectdelte;
    }

    public void setSelectdelte(TreeNode selectdelte) {
        this.selectdelte = selectdelte;
    }

    public List<TerminalTemplate> getTerminals() {
        return Terminals;
    }

    public void setTerminals(List<TerminalTemplate> Terminals) {
        this.Terminals = Terminals;
    }
    
    
      
      
         public String ADD(ActionEvent actionEvent){
         
      if(terminalTemplateFacade.Pterminal_find(terminal.getTName())){
              Messages.addInfoMessage("Duplicated",2,13);
     }else{
             Messages.addInfoMessage("ADDED",1,13);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            terminal.setUserID(Login.login);
            terminal.setCreateDate(date);
            terminal.setUpdateDate(date);
          terminalTemplateFacade.create(terminal);
       }
      
        Terminals=terminalTemplateFacade.findAll();
             Parts=partsFacade.findAll();
         downloads=downloadMethodFacade.findAll();
      return "Login";
     }
      
      
      
         public String joingroup(ActionEvent actionEvent){
         for(int i=0;i<selparts.size();i++){
             TerminalHasParts a=new TerminalHasParts();
            a.setTerminaltemplateID(selectgroup);
            a.setDownloadmethodID(seledownload);
             Messages.addInfoMessage("ADDED",1,13);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            a.setCreateDate(date);
            a.setUpdateDate(date);
            a.setPartsID(selparts.get(i));
          terminalHasPartsFacade.create(a);
         }
                     Terminals=terminalTemplateFacade.findAll();
             Parts=partsFacade.findAll();
         downloads=downloadMethodFacade.findAll();
      return "Login";
     }
         
         
         
         
         
         public void removeGroup(ActionEvent actionEvent){
      if(((PGroup_tree)selectdelte.getData()).getType().toUpperCase().equals("GROUP")){
          try {
              TerminalTemplate a=   terminalTemplateFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                    List<TerminalHasParts> b=  terminalHasPartsFacade.get_part_group(a);
                        for (TerminalHasParts terminalHasParts : b) {
                            try {
                            terminalHasPartsFacade.remove(terminalHasParts);
                            Messages.addInfoMessage("removed "+terminalHasParts.getPartsID().getPName()+" from "+terminalHasParts.getTerminaltemplateID().getTName(),1,13);
       
                            } catch (Exception e) {
                                  Messages.addInfoMessage("NO parts Linked "+e.getMessage(),3,13);
                            }
                
                        //    Messages.addInfoMessage("all para"+groupHasParameter.getId()+" group  removed",1);
                        } 
                        
                        terminalTemplateFacade.remove(a);
                          Messages.addInfoMessage("removed "+a.getTName(),1,13);
       
                           
                        
          } catch (Exception e) {
               Messages.addInfoMessage("Problem in system "+e.getMessage(),3,13);
          }
                    
                   
                    }
    
}
       
       
public void remove(ActionEvent actionEvent){
                    
                    if(((PGroup_tree)selectdelte.getData()).getType().toUpperCase().equals("GROUP")){
                        try{
                     TerminalTemplate a=   terminalTemplateFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                    List<TerminalHasParts> b=  terminalHasPartsFacade.get_part_group(a);
                        for (TerminalHasParts terminalHasParts : b) {
                            
                       terminalHasPartsFacade.remove(terminalHasParts);
                     Messages.addInfoMessage("removed "+terminalHasParts.getPartsID().getPName()+" from "+terminalHasParts.getTerminaltemplateID().getTName(),1,13);
    
                        //    Messages.addInfoMessage("all para"+groupHasParameter.getId()+" group  removed",1);
                        }
                           } catch (Exception e) {
               Messages.addInfoMessage("Problem in system "+e.getMessage(),3,13);
          }
                   
                    }else{
                           try {
                  
                 TerminalHasParts a=terminalHasPartsFacade.find(((PGroup_tree)selectdelte.getData()).getId());
                               
                   terminalHasPartsFacade.remove(a);
             Messages.addInfoMessage("removed "+a.getPartsID().getPName()+" from "+a.getTerminaltemplateID().getTName(),1,13);
         } catch (Exception e) {
                 Messages.addInfoMessage("not removed "+e.getMessage(),3,13);
    }
                    }
  
         
     
     } 
      
      
      
      
      
      
      
      
      
    
}
