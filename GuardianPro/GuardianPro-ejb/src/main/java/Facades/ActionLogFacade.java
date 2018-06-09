/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ActionLog;
import Entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mohamed.sobhi
 */
@Stateless
public class ActionLogFacade extends AbstractFacade<ActionLog> implements ActionLogFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActionLogFacade() {
        super(ActionLog.class);
    }
    
    
    @Override
      public List<ActionLog> getListofLogs(User user , String pagename) {
  
          List <ActionLog> logList = null ;
       Query para_find = em.createNamedQuery("ActionLog.findByUserIdandPageName");
        para_find.setParameter("pagename", pagename);
        para_find.setParameter("userID", user);
        try {
          logList =  para_find.getResultList(); 
         //   System.out.println("ahmed hamed  "+inputtype.getType());
         
                
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return logList;
    }
}