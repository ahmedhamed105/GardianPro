/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Parameter;
import Entities.ParamterDefault;
import Entities.User;
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
public class ParamterDefaultFacade extends AbstractFacade<ParamterDefault> implements ParamterDefaultFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParamterDefaultFacade() {
        super(ParamterDefault.class);
    }

    @Override
    public List<ParamterDefault> get_default(Parameter para) {
  
        Query def = em.createNamedQuery("ParamterDefault.findBypara");
        def.setParameter("id", para);
        try {
                List<ParamterDefault>  deflist = def.getResultList();     
                return deflist;
        } catch (Exception e) {
            return null;
        }
    
    }
    
}
