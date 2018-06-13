/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Component;
import Entities.Menu;
import Entities.MenuSub;
import Facades.ComponentFacadeLocal;
import Facades.MenuFacadeLocal;
import Facades.MenuSubFacadeLocal;
import Facades.UserFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ahmed.elemam
 */
public class menu {

    @EJB
    private ComponentFacadeLocal componentFacade;

    @EJB
    private MenuSubFacadeLocal menuSubFacade;

    @EJB
    private MenuFacadeLocal menuFacade;
    
       @EJB
    private UserFacadeLocal userFacade;
    
    
    
    
    List<Entities.Menu> menus =new ArrayList<>();
    
    List<Entities.Menu> sub =new ArrayList<>();

    /**
     * Creates a new instance of menu
     */
    public menu() {
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getSub() {
        return sub;
    }

    public void setSub(List<Menu> sub) {
        this.sub = sub;
    }
    
      public void init(){
             Login.login = userFacade.find(1);
        try {
        if(Login.login==null || Login.login.getId() == 0){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    ec.redirect(ec.getRequestContextPath()
            + "/faces/login.xhtml");

        }else{
         menus  = menuFacade.findAll();
        
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
      
      
    public List<MenuSub> sub_menu(Menu a){
     return menuSubFacade.sub_menulist(a);
      }
    
    
      public String comname(String name){
          try {
                 Component a= componentFacade.getname(name);
                 if(a==null){
                  return "Main";
                 }else{
                  return a.getCname();      
                 }
 
          } catch (Exception e) {
              return "Main";
          }
     
      
      }
      public String tittle(){
        //  FacesContext ctx = FacesContext.getCurrentInstance();
String path = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI();

          String result="main";
          String a=path.split("/")[path.split("/").length-1];
          System.out.println("com.guardian.Login.menu.tittle() "+a);
          
          if ( menuFacade.get_name(a)==null) {
              try {
                  
                    if ( menuSubFacade.get_name(a)==null) {
                    result="main";
                    }else{
                    result=menuSubFacade.get_name(a);
                    }
              } catch (Exception e) {
                  result="main";
              }
           
          }else{
          result= menuFacade.get_name(a);
          }

     return result;
      }
    
    
    
    
    
}
