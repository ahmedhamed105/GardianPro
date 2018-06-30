/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.Component;
import Entities.Menu;
import Entities.MenuSub;
import Facades.ComponentFacadeLocal;
import Facades.MenuFacadeLocal;
import Facades.MenuSubFacadeLocal;
import Facades.PagesFacadeLocal;
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
    private PagesFacadeLocal pagesFacade;

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
//             System.out.println(Login.login.getUsername());
        try {
        if(Login.login==null || Login.login.getId() == 0){
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//            
//    ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");

        }else{
         menus  = menuFacade.findAll();
        
        }
        
        } catch (Exception e) {
            /*start mohammed.ayad*/
            Messages.addInfoMessage(e.getMessage(), 3, 23);
            /*end mohammed.ayad*/
//            try {
//                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//               // System.out.println(ec.getRequestContextPath()+ "/faces/index.xhtml");
//                ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
//            } catch (IOException ex) {
//                Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
//                /*start mohammed.ayad*/
//                Messages.addInfoMessage(ex.getMessage(), 3, 23);
//                /*end mohammed.ayad*/
//            }
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
              /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 23);
              /*end mohammed.ayad*/
              return "Main";
          }
     
      
      }
      public String tittle(int page){
 
      String pageName=pagesFacade.find(page).getPageName();
          System.out.println("pageName "+pageName);
      
      return pageName;
      }
    
    
    
    
    
}
