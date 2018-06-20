/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Reports;
import com.mysql.jdbc.ResultSetMetaData;
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
public class ReportsFacade extends AbstractFacade<Reports> implements ReportsFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportsFacade() {
        super(Reports.class);
    }
    
     @Override
        public  List<Object[]> find_parameter(String jpl){ 
           Query para_find = em.createNativeQuery(jpl);
        try {
         List<Object[]>  parah =  para_find.getResultList();
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
        
        @Override
        public  List<Object> find_parameter_col(String jpl){ 
           Query para_find = em.createNativeQuery(jpl);
        try {
         //   ResultSetMetaData rsmd=pa
         List<Object>  parah = (List<Object>)  para_find.getResultList();
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
