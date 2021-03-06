/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Terminal;
import Entities.TerminalGroup;
import Entities.TgroupHasTerminal;
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
public class TgroupHasTerminalFacade extends AbstractFacade<TgroupHasTerminal> implements TgroupHasTerminalFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TgroupHasTerminalFacade() {
        super(TgroupHasTerminal.class);
    }
    
    
    
    @Override
        public  boolean find_term(Terminal term){ 
           Query para_find = em.createNamedQuery("TgroupHasTerminal.findByterminal");
        para_find.setParameter("id", term);
        try {
         Entities.TgroupHasTerminal  parah = (Entities.TgroupHasTerminal) para_find.getSingleResult(); 
          //  System.out.println("ahmed hamed  "+parah.getGroupname());
         if(parah==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
        }
        
        
        
        
      @Override
        public   List<Entities.TgroupHasTerminal> find_term_groups(TerminalGroup group){ 
           Query para_find = em.createNamedQuery("TgroupHasTerminal.findBygroup");
        para_find.setParameter("id", group);
        try {
         List<Entities.TgroupHasTerminal>  parah =  para_find.getResultList();
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
