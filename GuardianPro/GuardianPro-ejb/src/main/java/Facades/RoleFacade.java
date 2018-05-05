/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Role;
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
    
    
    public  boolean Role_find(String roleDes){
    
        Query role_find = em.createNamedQuery("Role.findByDescription");
        role_find.setParameter("description", roleDes);
        try {
         Entities.Role  role = (Entities.Role) role_find.getSingleResult(); 
            System.out.println("ahmed Mahmoud  "+role.getDescription());
         if(role==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
    }
}
