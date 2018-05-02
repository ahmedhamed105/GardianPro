/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Parameter;
import Entities.User;
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
public class ParameterFacade extends AbstractFacade<Parameter> implements ParameterFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterFacade() {
        super(Parameter.class);
    }

    @Override
    public boolean para_find(String displayname) {
          Query para_find = em.createNamedQuery("Parameter.findByDisplayName");
        para_find.setParameter("displayName", displayname);
        try {
         Entities.Parameter  parah = (Entities.Parameter) para_find.getSingleResult(); 
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
