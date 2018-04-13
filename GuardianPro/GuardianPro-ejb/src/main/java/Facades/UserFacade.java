/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.PasswordHistory;
import Entities.User;
import Entities.UserStatus;
import java.util.Collection;
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
    @Override
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
        
        
    @Override
    public  int user_status(User User1){      
       Query user_status = em.createNamedQuery("UserStatus.findByuser");
        user_status.setParameter("id", User1);
        try {
                UserStatus  status = (UserStatus) user_status.getSingleResult();     
                return status.getStatusID().getId();
        } catch (Exception e) {
            return 0;
        }
    }
        
    @Override
    public  User password_username(String Username){      
       Query password_username = em.createNamedQuery("User.findByUsername");
        password_username.setParameter("username", Username);
        try {
                User  users = (User) password_username.getSingleResult();     
                return users;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     *
     * @param Username
     * @return
     */
    public  Collection<PasswordHistory> passwordHistory_username(String Username){      
       Query passwordHistory_username = em.createNamedQuery("User.findByUsername");
        passwordHistory_username.setParameter("username", Username);
        try {
                User  users = (User) passwordHistory_username.getSingleResult();     
                return users.getPasswordHistoryCollection();
        } catch (Exception e) {
            return null;
        }
    }

}
