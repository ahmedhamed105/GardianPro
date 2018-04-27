/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import Entities.User;
import Facades.UserFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ahmed.elemam
 */
@ManagedBean
@SessionScoped
public class Login {

    @EJB
    private UserFacadeLocal userFacade;
    
    
    
    boolean remeber;
    String username;
    String password;
    static User login = new User();

    /**
     * Creates a new instance of Login
     */
    public Login() {
        
    }

    public User getLogin() {
        return login;
    }

    public void setLogin(User login) {
        Login.login = login;
    }
    
    

    public boolean isRemeber() {
        return remeber;
    }

    public void setRemeber(boolean remeber) {
        this.remeber = remeber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String Login_submit(ActionEvent actionEvent){
         
        try{
            User u1=userFacade.search_username(username).get(0);
       if(u1.getUserPasswordID().getPassword().equals(password)){
                switch (userFacade.user_status(u1)) {
                    case 1:
                        Messages.addInfoMessage("Login ok!!",1);
                        login=u1;
                       return "Login";
                    case 2:
                        Messages.addInfoMessage("Login Error User Closed !!",2);
                       return "Error";
                    case 3:
                        Messages.addInfoMessage("Login Error User Locked !!",2);
                       return "Error";
                    case 4:
                        Messages.addInfoMessage("Login Error User not Have Email Activation !!",2);
                        return "Error";
                    default:
                        Messages.addInfoMessage("Login Error Check status !!",2);
                        return "Error";
                }
       
       }else{
           Messages.addInfoMessage("Login Error Wrong password!!",2);
       return "Error";
       }
        }catch(Exception e){
            e.printStackTrace();
         Messages.addInfoMessage("Login Error!!",2);
         return "Error";
        }

   
    }
    
    
    

}
