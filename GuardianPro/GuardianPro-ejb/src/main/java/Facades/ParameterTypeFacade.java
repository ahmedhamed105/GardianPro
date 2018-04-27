/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class ParameterTypeFacade extends AbstractFacade<ParameterType> implements ParameterTypeFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterTypeFacade() {
        super(ParameterType.class);
    }
    
    
     @Override
        public  boolean Paremter_find(String para){
    
        Query para_find = em.createNamedQuery("ParameterType.findByType");
        para_find.setParameter("type", para);
        try {
         Entities.ParameterType  parah = (Entities.ParameterType) para_find.getSingleResult(); 
            System.out.println("ahmed hamed  "+parah.getType());
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
