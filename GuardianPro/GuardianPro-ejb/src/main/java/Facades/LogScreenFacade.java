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
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void createLogScreenObject(User user,int pageId,int transactionId,String messageLog) {
        System.out.println("start logging>>>>>>>>>>>>>>");
        if(user.getId()==null){
            System.out.println("user is not exist");
            user=userFacade.find(1);
//            user=em.find(User.class, 1);
            System.out.println("user name "+user.getFirstName());
        }
        Pages page=em.find(Pages.class,pageId );
        TrxType transactionType=em.find(TrxType.class, transactionId);
        LogScreen log=new LogScreen();
        log.setCreateDate(new Date());
        log.setUpdateDate(new Date());
        log.setPageId(page);
        log.setTRXTypeID(transactionType);
        log.setTRXdesc(messageLog);
        log.setUserID(user);
        create(log);
    }
    
}
