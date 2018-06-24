/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;


import Entities.EmailLog;
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
public class EmailLogFacade extends AbstractFacade<EmailLog> implements EmailLogFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmailLogFacade() {
        super(EmailLog.class);
    }
    

    
    
     @Override
        public  List<EmailLog> FindALL_notsend(){
    
            
       Query user_username = em.createNamedQuery("EmailLog.findAllN");
        try {
                List<EmailLog>  EmailLog = user_username.getResultList();     
                return EmailLog;
        } catch (Exception e) {
            return null;
        }
    }
    
}
