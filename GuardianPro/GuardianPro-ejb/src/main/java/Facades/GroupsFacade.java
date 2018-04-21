/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Groups;
import Entities.Role;
import Entities.User;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> implements GroupsFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }
    
    public Collection<User> usersByGroup(String groupname){      
       Query usersByGroup = em.createNamedQuery("Groups.findByName");
        usersByGroup.setParameter("name", groupname);
        try {
                Groups group = (Groups) usersByGroup.getSingleResult();     
                return group.getUserCollection();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Collection<Role> rolesByGroup(String groupname){      
       Query rolesByGroup = em.createNamedQuery("Groups.findByName");
        rolesByGroup.setParameter("name", groupname);
        try {
                Groups group = (Groups) rolesByGroup.getSingleResult();     
                return group.getRoleCollection();
        } catch (Exception e) {
            return null;
        }
    }
}
