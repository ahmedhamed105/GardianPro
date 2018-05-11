/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalTemplate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class TerminalTemplateFacade extends AbstractFacade<TerminalTemplate> implements TerminalTemplateFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalTemplateFacade() {
        super(TerminalTemplate.class);
    }
    
    
      @Override
    public boolean Pterminal_find(String terminal_name) {
 
         Query para_find = em.createNamedQuery("TerminalTemplate.findByTName");
        para_find.setParameter("tName", terminal_name);
        try {
         Entities.ApplicationGroup  parah = (Entities.ApplicationGroup) para_find.getSingleResult(); 
           // System.out.println("ahmed hamed  "+parah.getType());
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
