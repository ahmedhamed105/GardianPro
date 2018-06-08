/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.Menu;
import Entities.MenuSub;
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

/**
 *
 * @author ahmed.elemam
 */
public class menu {

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
    
    
    
    
    
}
