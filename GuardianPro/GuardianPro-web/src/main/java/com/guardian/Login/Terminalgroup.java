/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.TerminalGroup;
import Facades.TerminalGroupFacadeLocal;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ahmed.elemam
 */
public class Terminalgroup {
    
      @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
      
      
       private TerminalGroup termgroup=new TerminalGroup();
       
        java.sql.Date date ;

    /**
     * Creates a new instance of Terminalgroup
     */
    public Terminalgroup() {
    }

    
          public String Addgroup(ActionEvent actionEvent){
         
        if(terminalGroupFacade.group_find(termgroup.getGroupname())){
               Messages.addInfoMessage("Duplicated",2);
        }else{
             Messages.addInfoMessage("ADDED",1);
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            termgroup.setCreateDate(date);
            termgroup.setUpdateDate(date);
          terminalGroupFacade.create(termgroup);
        }
         
      return "Login";
     }
    
}
