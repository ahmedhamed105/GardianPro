/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Groups;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> implements GroupsFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }
    
    
    public boolean input_find(String description) {
  
       Query para_find = em.createNamedQuery("Groups.findByDescription");
        para_find.setParameter("description", description);
        try {
         Entities.Groups  groups = (Entities.Groups) para_find.getSingleResult(); 
         //   System.out.println("ahmed hamed  "+inputtype.getType());
         if(groups==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
    }
}
