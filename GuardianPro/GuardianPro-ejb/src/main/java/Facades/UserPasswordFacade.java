/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.UserPassword;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class UserPasswordFacade extends AbstractFacade<UserPassword> implements UserPasswordFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPasswordFacade() {
        super(UserPassword.class);
    }
    
        public  String getPasswordById(String PasswordId){
    
            
       Query PasswordById = em.createNamedQuery("UserPassword.findById");
        PasswordById.setParameter("id", PasswordId);
        try {
                UserPassword  Password = (UserPassword)PasswordById.getSingleResult();     
                return Password.getPassword();
        } catch (Exception e) {
            return null;
        }
    }
        
        
   
}
