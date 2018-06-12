/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Groups;
import Entities.Role;
import Entities.RoleHasGroups;
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
public class RoleHasGroupsFacade extends AbstractFacade<RoleHasGroups> implements RoleHasGroupsFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleHasGroupsFacade() {
        super(RoleHasGroups.class);
    }

    @Override
    public List<RoleHasGroups> find_role_by_group(Groups group) {
        Query role_find = em.createNamedQuery("RoleHasGroups.findByGroupsid");
        role_find.setParameter("id", group);
        try {
            List<RoleHasGroups> roles = role_find.getResultList();
            //  System.out.println("ahmed hamed  "+parah.getGroupname());
            if (roles == null) {
                return null;
            } else {
                return roles;
            }

        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public RoleHasGroups findByGroupRole(Groups group,Role role){
        Query groupRole=em.createNamedQuery("RoleHasGroups.findByGroupsidRoleid");
        groupRole.setParameter("groupId", group);
        groupRole.setParameter("roleId", role);
        try {
                    return (RoleHasGroups) groupRole.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
    
}
