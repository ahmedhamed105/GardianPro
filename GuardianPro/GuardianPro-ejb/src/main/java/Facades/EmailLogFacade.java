/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Email.EmailUtils;
import Entities.EmailLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public boolean send_email(EmailLog em) {
        try {
           EmailUtils.send(em);  
           return true;
        } catch (Exception e) {
            e.printStackTrace();
                return false;
        }
       
    }
    
}
