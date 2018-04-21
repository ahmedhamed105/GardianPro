/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Component;
import Entities.Groups;
import Entities.Role;
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
public class RoleFacade extends AbstractFacade<Role> implements RoleFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }
    
    public Collection<Component> componentByRole(String roleName){      
       Query componentByRole = em.createNamedQuery("Role.findByName");
        componentByRole.setParameter("name", roleName);
        try {
                Role role = (Role) componentByRole.getSingleResult();     
                return role.getComponentCollection();
        } catch (Exception e) {
            return null;
        }
    }
}
