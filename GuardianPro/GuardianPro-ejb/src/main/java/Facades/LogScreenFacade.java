/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.LogScreen;
import Entities.Pages;
import Entities.TrxType;
import Entities.User;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class LogScreenFacade extends AbstractFacade<LogScreen> implements LogScreenFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    @EJB
    private UserFacadeLocal userFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogScreenFacade() {
        super(LogScreen.class);
    }
    


    
    
    @Override
    public List<LogScreen> Select_log_User(User user,int pageId) {
        
           Pages page=em.find(Pages.class,pageId );
        Query para_find = em.createNamedQuery("LogScreen.findBypageuser");
        para_find.setParameter("id", page);
        para_find.setParameter("id1", user);
        try {
         List<LogScreen>  inputtype =  para_find.getResultList(); 
         //   System.out.println("ahmed hamed  "+inputtype.getType());
         if(inputtype==null){
         return null;
         }else{
         return inputtype;
         }
                
        } catch (Exception e) {
            return null;
        }
     
    }
    
    
    
    
}
