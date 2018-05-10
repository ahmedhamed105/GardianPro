/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

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
     
     List<TerminalTemplate> Terminal= new ArrayList<TerminalTemplate>();
     
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
    
    
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
            selectgroup=new TerminalTemplate();
            selparts= new ArrayList<Parts>();
             Terminal=terminalTemplateFacade.findAll();
             Parts=partsFacade.findAll();
     
       root = new DefaultTreeNode(new PGroup_tree("Groups",Terminal.size(),0,"root"), null);
      for(int i=0;i<Terminal.size();i++){
          try {
              ter_parts  = terminalHasPartsFacade.get_part_group(Terminal.get(i));
              
              System.out.println("group "+Terminal.get(i).getTName()+ter_parts.size());
              DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Terminal.get(i).getTName(),ter_parts.size(),Terminal.get(i).getId(),"GROUP"), root);
         
              for(int j=0;j<ter_parts.size();j++){
                   System.out.println("para "+ter_parts.get(j).getPartsID().getPName());
             DefaultTreeNode documentss = new DefaultTreeNode(new PGroup_tree(ter_parts.get(j).getPartsID().getPName(),1,ter_parts.get(j).getId(),"APP"), documents);
        
              }
          } catch (Exception e) {
              e.printStackTrace();
               System.out.println("error");
                 DefaultTreeNode documents = new DefaultTreeNode(new PGroup_tree(Terminal.get(i).getTName(),0,Terminal.get(i).getId(),"GROUP"), root);
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
      
      
      
      
      
      
      
      
      
      
      
      
    
}
