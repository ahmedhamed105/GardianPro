/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class ParameterGroupFacade extends AbstractFacade<ParameterGroup> implements ParameterGroupFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterGroupFacade() {
        super(ParameterGroup.class);
    }

    @Override
    public boolean Pgroup_find(String groupname) {
 
         Query para_find = em.createNamedQuery("ParameterGroup.findByGroupname");
        para_find.setParameter("groupname", groupname);
        try {
         Entities.ParameterGroup  parah = (Entities.ParameterGroup) para_find.getSingleResult(); 
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
