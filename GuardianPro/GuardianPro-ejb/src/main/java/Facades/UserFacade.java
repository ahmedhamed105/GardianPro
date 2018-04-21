/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Groups;
import Entities.PasswordHistory;
import Entities.ProfileData;
import Entities.Role;
import Entities.User;
import Entities.UserStatus;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
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
                return status.getId();
        } catch (Exception e) {
            return 0;
        }
    }
        
    @Override
    public  String password_username(String Username){      
       Query password_username = em.createNamedQuery("User.findByUsername");
        password_username.setParameter("username", Username);
        try {
                User users = (User) password_username.getSingleResult();     
                return users.getUserPasswordID().getPassword();
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     *
     * @param Username
     * @return
     */
    @Override
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

    @Override
     public  Collection<ProfileData> userProfile_username(String Username){      
       Query userProfile_username = em.createNamedQuery("User.findByUsername");
        userProfile_username.setParameter("username", Username);
        try {
                User user = (User) userProfile_username.getSingleResult();    
                Query userProfiles = em.createNamedQuery("ProfileData.findByUserID");
                userProfiles.setParameter("userID", user.getId());
                return userProfiles.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
     
     @Override
     public Collection<Groups> groupsByUser(String Username){      
       Query password_username = em.createNamedQuery("User.findByUsername");
        password_username.setParameter("username", Username);
        try {
                User user = (User) password_username.getSingleResult();     
                return user.getGroupsCollection();
        } catch (Exception e) {
            return null;
        }
    }
     
    public Collection<Role> rolesOfUser(String Username){
        
        Collection<Groups> groups = groupsByUser(Username);
        Collection<Role> roles = new Collection<Role>() {
            @Override
            public Spliterator<Role> spliterator() {
                return Collection.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Iterator<Role> iterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <T> T[] toArray(T[] a) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean add(Role e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(Collection<? extends Role> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        for (Groups group : groups) {
           roles.addAll(group.getRoleCollection());
        }
        try {     
                return roles;
        } catch (Exception e) {
            return null;
        }
    }
}
