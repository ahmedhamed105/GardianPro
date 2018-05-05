/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Entities.GroupHasParameter;
import Entities.ParameterGroup;
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
public class ApplicationHasGroupFacade extends AbstractFacade<ApplicationHasGroup> implements ApplicationHasGroupFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicationHasGroupFacade() {
        super(ApplicationHasGroup.class);
    }
    
    
    
     @Override
    public List<ApplicationHasGroup> get_app_group(ApplicationGroup gp) {
  
      Query para = em.createNamedQuery("ApplicationHasGroup.findByGroup");
        para.setParameter("id", gp);
        try {
              return  para.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
