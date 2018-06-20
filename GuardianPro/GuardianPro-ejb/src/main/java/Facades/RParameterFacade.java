/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.RParameter;
import Entities.Reports;
import Entities.TerminalGroup;
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
public class RParameterFacade extends AbstractFacade<RParameter> implements RParameterFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RParameterFacade() {
        super(RParameter.class);
    }
    
     @Override
        public   List<Entities.RParameter> find_parameter(Reports rep){ 
           Query para_find = em.createNamedQuery("RParameter.findByreport");
        para_find.setParameter("id", rep);
        try {
         List<Entities.RParameter>  parah =  para_find.getResultList();
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
