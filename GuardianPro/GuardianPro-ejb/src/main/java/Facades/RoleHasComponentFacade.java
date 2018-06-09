/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Component;
import Entities.Role;
import Entities.RoleHasComponent;
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
public class RoleHasComponentFacade extends AbstractFacade<RoleHasComponent> implements RoleHasComponentFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleHasComponentFacade() {
        super(RoleHasComponent.class);
    }

    @Override
    public List<RoleHasComponent> find_component_by_role(Role role) {
        Query component_find = em.createNamedQuery("RoleHasComponent.findByRole");
        component_find.setParameter("id", role);
        try {
            List<RoleHasComponent> components = component_find.getResultList();
            //  System.out.println("ahmed hamed  "+parah.getGroupname());
            if (components == null) {
                return null;
            } else {
                return components;
            }

        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
     public RoleHasComponent find_component_by_role_component(Role role, Component component) {
        Query component_find = em.createNamedQuery("RoleHasComponent.findByRoleAndComponent");
        component_find.setParameter("id", role);
        component_find.setParameter("component", component);
        try {
            RoleHasComponent roleHascomponent = (RoleHasComponent)component_find.getSingleResult();
            //  System.out.println("ahmed hamed  "+parah.getGroupname());
            if (roleHascomponent == null) {
                return null;
            } else {
                return roleHascomponent;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
