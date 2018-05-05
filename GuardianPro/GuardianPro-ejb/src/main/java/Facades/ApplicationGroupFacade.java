/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ApplicationGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class ApplicationGroupFacade extends AbstractFacade<ApplicationGroup> implements ApplicationGroupFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicationGroupFacade() {
        super(ApplicationGroup.class);
    }
    
    
     @Override
    public boolean Pgroup_find(String groupname) {
 
         Query para_find = em.createNamedQuery("ApplicationGroup.findByGroupname");
        para_find.setParameter("groupname", groupname);
        try {
         Entities.ApplicationGroup  parah = (Entities.ApplicationGroup) para_find.getSingleResult(); 
           // System.out.println("ahmed hamed  "+parah.getType());
         if(parah==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
    }
    
}
