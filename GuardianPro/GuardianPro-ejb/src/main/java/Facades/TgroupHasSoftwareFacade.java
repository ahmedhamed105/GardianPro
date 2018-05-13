/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalGroup;
import Entities.TgroupHasSoftware;
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
public class TgroupHasSoftwareFacade extends AbstractFacade<TgroupHasSoftware> implements TgroupHasSoftwareFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TgroupHasSoftwareFacade() {
        super(TgroupHasSoftware.class);
    }
    
    
         @Override
        public   List<Entities.TgroupHasSoftware> find_term_groups(TerminalGroup group){ 
           Query para_find = em.createNamedQuery("TgroupHasSoftware.findBygroup");
        para_find.setParameter("id", group);
        try {
         List<Entities.TgroupHasSoftware>  parah =  para_find.getResultList();
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