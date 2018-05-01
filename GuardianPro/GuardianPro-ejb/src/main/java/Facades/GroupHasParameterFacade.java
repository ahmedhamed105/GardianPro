/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.GroupHasParameter;
import Entities.Parameter;
import Entities.ParameterGroup;
import Entities.UserStatus;
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
public class GroupHasParameterFacade extends AbstractFacade<GroupHasParameter> implements GroupHasParameterFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupHasParameterFacade() {
        super(GroupHasParameter.class);
    }

    @Override
    public List<GroupHasParameter> get_para_group(ParameterGroup gp) {
  
      Query para = em.createNamedQuery("GroupHasParameter.findByGroup");
        para.setParameter("id", gp);
        try {
              return  para.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
