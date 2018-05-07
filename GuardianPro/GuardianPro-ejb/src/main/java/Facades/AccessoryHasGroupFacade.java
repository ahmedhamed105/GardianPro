/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.AccessoryHasGroup;
import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class AccessoryHasGroupFacade extends AbstractFacade<AccessoryHasGroup> implements AccessoryHasGroupFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccessoryHasGroupFacade() {
        super(AccessoryHasGroup.class);
    }
    
    
      @Override
    public List<Entities.AccessoryHasGroup> get_app_group(Entities.AccessoryGroup gp) {
  
      Query para = em.createNamedQuery("AccessoryHasGroup.findByGroup");
        para.setParameter("id", gp);
        try {
              return  para.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
