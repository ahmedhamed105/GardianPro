/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.User;
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
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
        public  List<User> search_username(String Username){
    
            
       Query user_username = em.createNamedQuery("User.findByUsername");
        user_username.setParameter("username", Username);
        try {
                List<User>  users = user_username.getResultList();     
                return users;
        } catch (Exception e) {
            return null;
        }
    }
        
    public  String password_username(String Username){      
       Query password_username = em.createNamedQuery("User.findByUsername");
        password_username.setParameter("username", Username);
        try {
                User  users = (User) password_username.getSingleResult();     
                return users.getUserPasswordID().getPassword();
        } catch (Exception e) {
            return null;
        }
    }

}
