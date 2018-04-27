/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ahmed.elemam
 */
public class Messages {

    /**
     * Creates a new instance of Messages
     */
    public Messages() {
    }
    
    
             public static void addInfoMessage(String summary,int type) {
             if(type == 1){
                  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
             }else if(type == 2){
                  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
             }
       
    }
    
}
