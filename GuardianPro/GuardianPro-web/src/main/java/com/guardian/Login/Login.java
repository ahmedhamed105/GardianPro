/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ahmed.elemam
 */
@ManagedBean
public class Login {
    
    boolean remeber;
    String username;
    String password;

    /**
     * Creates a new instance of Login
     */
    public Login() {
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
        
        if("admin".equals(username) && "admin".equals(password)){
        addInfoMessage("Login ok!!");
        }else{
         addInfoMessage("Login Error!!");
        }
        
     
    return null;
    }
    
    
    
     public void addInfoMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
