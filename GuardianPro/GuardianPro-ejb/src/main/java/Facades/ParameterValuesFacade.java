/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterValues;
import Entities.Pgchild;
import Entities.TgroupHasGparameter;
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
public class ParameterValuesFacade extends AbstractFacade<ParameterValues> implements ParameterValuesFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterValuesFacade() {
        super(ParameterValues.class);
    }
    
    
      @Override
   public List<ParameterValues> ParameterValues_find(TgroupHasGparameter parent){
     Query para_find = em.createNamedQuery("ParameterValues.findByGroup");
        para_find.setParameter("id", parent);
        try {
         List<ParameterValues> parah =  para_find.getResultList(); 
           // System.out.println("ahmed hamed  "+parah.getType());
         if(parah==null){
         return null;
         }else{
         return parah;
         }
                
        } catch (Exception e) {
            return null;
        }
   
   }
    
}
