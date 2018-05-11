/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Terminal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class TerminalFacade extends AbstractFacade<Terminal> implements TerminalFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalFacade() {
        super(Terminal.class);
    }
    
    
     @Override
        public  boolean term_find(String term){
    
        Query para_find = em.createNamedQuery("Terminal.findByTid");
        para_find.setParameter("tid", term);
        try {
         Entities.Terminal  parah = (Entities.Terminal) para_find.getSingleResult(); 
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
}
