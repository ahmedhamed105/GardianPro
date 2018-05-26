/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Parameter;
import Entities.ParameterType;
import Entities.Pchildparent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class PchildparentFacade extends AbstractFacade<Pchildparent> implements PchildparentFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PchildparentFacade() {
        super(Pchildparent.class);
    }

    @Override
    public Pchildparent find_parameter(ParameterType par) {
   Query para_find = em.createNamedQuery("Pchildparent.findBypara");
        para_find.setParameter("id", par);
        try {
         Entities.Pchildparent  parah = (Entities.Pchildparent) para_find.getSingleResult(); 
           // System.out.println("ahmed hamed  "+parah.getType());
         if(parah==null){
         return null;
         }else{
         return parah;
         }
                
        } catch (Exception e) {
            return null;
        }   }
    
}
