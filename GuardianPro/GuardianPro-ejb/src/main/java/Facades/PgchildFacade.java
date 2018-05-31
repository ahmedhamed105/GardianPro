/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

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
public class PgchildFacade extends AbstractFacade<Pgchild> implements PgchildFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PgchildFacade() {
        super(Pgchild.class);
    }
    
    
    @Override
   public List<Pgchild> childs_find(TgroupHasGparameter parent){
     Query para_find = em.createNamedQuery("Pgchild.findByparent");
        para_find.setParameter("id", parent);
        try {
         List<Pgchild> parah =  para_find.getResultList(); 
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
   
   
    @Override
   public Pgchild Pchild_find(TgroupHasGparameter parent,TgroupHasGparameter child){
     Query para_find = em.createNamedQuery("Pgchild.findByparentchild");
        para_find.setParameter("id", parent);
        para_find.setParameter("id1", child);
        try {
         Pgchild parah =  (Pgchild) para_find.getSingleResult();
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
