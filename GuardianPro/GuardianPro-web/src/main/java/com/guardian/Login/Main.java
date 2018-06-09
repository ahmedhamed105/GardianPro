/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.AccessoryGroup;
import Entities.Parameter;
import Entities.ParameterGroup;
import Entities.Terminal;
import Entities.TerminalGroup;
import Facades.AccessoryGroupFacadeLocal;
import Facades.ParameterFacadeLocal;
import Facades.ParameterGroupFacadeLocal;
import Facades.TerminalFacadeLocal;
import Facades.TerminalGroupFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed.elemam
 */
public class Main {

    @EJB
    private AccessoryGroupFacadeLocal accessoryGroupFacade;

    @EJB
    private ParameterGroupFacadeLocal parameterGroupFacade;

    @EJB
    private ParameterFacadeLocal parameterFacade;

    @EJB
    private TerminalFacadeLocal terminalFacade;

    @EJB
    private TerminalGroupFacadeLocal terminalGroupFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      
      
      
      
      
      
      
      
      
    List<Entities.TerminalGroup> TerminalGroup = new ArrayList<Entities.TerminalGroup>();

    List<Entities.Terminal> Terminals = new ArrayList<Entities.Terminal>();
    
    List<Entities.Parameter> parmeters = new ArrayList<Entities.Parameter>();
    
    List<Entities.ParameterGroup> parmetersGroup = new ArrayList<Entities.ParameterGroup>();
    
    List<Entities.AccessoryGroup> accessoryGroup = new ArrayList<Entities.AccessoryGroup>();
    
    int year=0;
    
    /**
     * Creates a new instance of Main
     */
    public Main() {
    }

    public List<AccessoryGroup> getAccessoryGroup() {
        return accessoryGroup;
    }

    public void setAccessoryGroup(List<AccessoryGroup> accessoryGroup) {
        this.accessoryGroup = accessoryGroup;
    }
    
    

    public List<TerminalGroup> getTerminalGroup() {
        return TerminalGroup;
    }

    public void setTerminalGroup(List<TerminalGroup> TerminalGroup) {
        this.TerminalGroup = TerminalGroup;
    }

    public List<Terminal> getTerminals() {
        return Terminals;
    }

    public void setTerminals(List<Terminal> Terminals) {
        this.Terminals = Terminals;
    }

    public List<Parameter> getParmeters() {
        return parmeters;
    }

    public void setParmeters(List<Parameter> parmeters) {
        this.parmeters = parmeters;
    }

    public List<ParameterGroup> getParmetersGroup() {
        return parmetersGroup;
    }

    public void setParmetersGroup(List<ParameterGroup> parmetersGroup) {
        this.parmetersGroup = parmetersGroup;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    
    public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
        year = Calendar.getInstance().get(Calendar.YEAR);
        TerminalGroup  = terminalGroupFacade.findAll();
         Terminals=terminalFacade.findAll();
        parmeters=parameterFacade.findAll();
        parmetersGroup=parameterGroupFacade.findAll();
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
    
    
    public int getgroup_month(int mon){
        int count=0;
        
        
        for (Iterator<TerminalGroup> iterator = TerminalGroup.iterator(); iterator.hasNext();) {
            TerminalGroup next = iterator.next();
                LocalDate localDate = next.getCreateDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           int Cmonth = localDate.getMonthValue();
           int Cyear = localDate.getYear();
           if(Cmonth==mon && Cyear==year){
           count++;
           }
           // System.out.println(month);

        }
        
    
        
       // TerminalGroup.get(0).getCreateDate()
    
    return count;
    }
    
    
     public int get_size(String mon){
         int cout=0;
         
        switch (mon) {
            case "Terminal Group":
                cout=TerminalGroup.size();
                break;
            case "Parmeter Group":
                cout=parmetersGroup.size();
                break;
            case "Parameter":
                cout=parmeters.size();
                break;
            case "Terminal":
                cout=Terminals.size();
                break;
            default:
                cout=0;
                break;
        }
         
         return cout;
         
     }
    
    
}
