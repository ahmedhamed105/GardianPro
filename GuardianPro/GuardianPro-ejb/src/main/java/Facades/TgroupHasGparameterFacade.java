/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterGroup;
import Entities.Terminal;
import Entities.TerminalGroup;
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
public class TgroupHasGparameterFacade extends AbstractFacade<TgroupHasGparameter> implements TgroupHasGparameterFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TgroupHasGparameterFacade() {
        super(TgroupHasGparameter.class);
    }
    
    
      @Override
        public  List<Entities.TgroupHasGparameter> find_group(ParameterGroup group){ 
           Query para_find = em.createNamedQuery("TgroupHasGparameter.findByGroup");
        para_find.setParameter("id", group);
        try {
         List<Entities.TgroupHasGparameter>  parah =  para_find.getResultList(); 
          //  System.out.println("ahmed hamed  "+parah.getGroupname());
         if(parah==null){
         return null;
         }else{
         return parah;
         }
                
        } catch (Exception e) {
            return null;
        }
        }
        
        
      @Override
        public   List<Entities.TgroupHasGparameter> find_term_groups(TerminalGroup group){ 
           Query para_find = em.createNamedQuery("TgroupHasGparameter.findByTGroup");
        para_find.setParameter("id", group);
        try {
         List<Entities.TgroupHasGparameter>  parah =  para_find.getResultList();
          //  System.out.println("ahmed hamed  "+parah.getGroupname());
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
