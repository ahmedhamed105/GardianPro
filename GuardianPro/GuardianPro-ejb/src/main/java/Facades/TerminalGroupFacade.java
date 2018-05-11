/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class TerminalGroupFacade extends AbstractFacade<TerminalGroup> implements TerminalGroupFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalGroupFacade() {
        super(TerminalGroup.class);
    }
    
    
        @Override
        public  boolean group_find(String group){
    
        Query para_find = em.createNamedQuery("TerminalGroup.findByGroupname");
        para_find.setParameter("groupname", group);
        try {
         Entities.TerminalGroup  parah = (Entities.TerminalGroup) para_find.getSingleResult(); 
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
