/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Accessory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class AccessoryFacade extends AbstractFacade<Accessory> implements AccessoryFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccessoryFacade() {
        super(Accessory.class);
    }
    
    
      @Override
    public boolean access_find(String acess) {
          Query para_find = em.createNamedQuery("Accessory.findByAccName");
        para_find.setParameter("accName", acess);
        try {
         Entities.Accessory  parah = (Entities.Accessory) para_find.getSingleResult(); 
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
