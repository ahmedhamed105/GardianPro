/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;import javax.servlet.http.HttpSession;

import Entities.InputType;
import Entities.User;
import Entities.UserPassword;
import Facades.UserFacadeLocal;
import Facades.UserPasswordFacadeLocal;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ahmed.elemam
 */
public class Profile {

    @EJB
    private UserPasswordFacadeLocal userPasswordFacade;
    
      @EJB
    private UserFacadeLocal userFacade;
      
      
       List<User> input_User = new ArrayList<User>();
    java.sql.Date date ;
     List<User> filteredUser = new ArrayList<User>();
     User User=new User();
     User selectUser=new User();
     String password;
     String conpassword;
      
      

    /**
     * Creates a new instance of Profile
     */
    public Profile() {
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public List<User> getInput_User() {
        return input_User;
    }

    public void setInput_User(List<User> input_User) {
        this.input_User = input_User;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<User> getFilteredUser() {
        return filteredUser;
    }

    public void setFilteredUser(List<User> filteredUser) {
        this.filteredUser = filteredUser;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public User getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(User selectUser) {
        this.selectUser = selectUser;
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
            input_User  = userFacade.findAll();

           }

           } catch (Exception e) {
               /*start mohammed.ayad*/
                Messages.addInfoMessage(e.getMessage(), 3, 10);
                /*end mohammed.ayad*/
               try {
                   ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

                   ec.redirect(ec.getRequestContextPath()+ "/faces/index.xhtml");
               } catch (IOException ex) {
                   Logger.getLogger(parmetertype.class.getName()).log(Level.SEVERE, null, ex);
                   /*start mohammed.ayad*/
                    Messages.addInfoMessage(ex.getMessage(), 3, 10);
                    /*end mohammed.ayad*/
               }
   }

       }
    
       public void reset(ActionEvent actionEvent){
           
           if(password.equals(conpassword) & selectUser !=null){
            try {
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        UserPassword paa=selectUser.getUserPasswordID();
         String encrypted = Encryption.encrypt(password);
        paa.setPassword(encrypted);
        paa.setUpdateDate(date);
        userPasswordFacade.edit(paa);
              /*start mohammed.ayad*/
             Messages.addInfoMessage("reset password for "+selectUser.getUsername(),1,10);
             /*end mohammed.ayad*/
         } catch (Exception e) {
             /*start mohammed.ayad*/
              Messages.addInfoMessage("Not reset "+selectUser.getUsername()+" return to Admin "+e.getMessage(),3,10);
              /*start mohammed.ayad*/
         }
           }else{
           /*start mohammed.ayad*/
            Messages.addInfoMessage("please sure that two passord is same or select User First",2,10);
            /*end mohammed.ayad*/
           }
        
         
     
     }
      
       
       
        public void remove(ActionEvent actionEvent){
         try {
   
            
                   userFacade.remove(selectUser);
                   
                    userPasswordFacade.remove(selectUser.getUserPasswordID());
             Messages.addInfoMessage("removed "+selectUser.getUsername(),1,10);
         } catch (Exception e) {
              Messages.addInfoMessage("Not removed "+selectUser.getUsername()+" return to Admin "+e.getMessage(),3,10);
         }
         
     
     }
    


    public void onRowEdit(RowEditEvent event) {
          date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
          User=((User) event.getObject());
            User.setUpdateDate(date);
          userFacade.edit(User);
          
          Messages.addInfoMessage("Edited "+((User) event.getObject()).getUsername(),1,10);
    }
     
    public void onRowCancel(RowEditEvent event) {
        
          Messages.addInfoMessage("Cancelled "+" "+((User) event.getObject()).getUsername(),1,10);
    }
    
    
    
     public String ADD(ActionEvent actionEvent){
          if(password.equals(conpassword)){
        if(userFacade.user_find(User.getUsername())){
               Messages.addInfoMessage("Duplicated",2,10);
        }else{
            
            date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            User.setCreateDate(date);
            User.setUpdateDate(date);
            UserPassword paa=new UserPassword();
             String encrypted = Encryption.encrypt(password);
            paa.setPassword(encrypted);
            paa.setCreateDate(date);
            paa.setUpdateDate(date);
            userPasswordFacade.create(paa);
            User.setUserPasswordID(paa);
          userFacade.create(User);     
          Messages.addInfoMessage("ADDED ",1,10);
             

        }
          }else{
                Messages.addInfoMessage("please sure that two passord is same",2,10);
      
          }
      return "Login";
     }
     
          
}
