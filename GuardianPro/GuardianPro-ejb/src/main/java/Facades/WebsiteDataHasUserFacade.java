/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.User;
import Entities.WebsiteDataHasUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class WebsiteDataHasUserFacade extends AbstractFacade<WebsiteDataHasUser> implements WebsiteDataHasUserFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebsiteDataHasUserFacade() {
        super(WebsiteDataHasUser.class);
    }
    
    @Override
    public  List<WebsiteDataHasUser> websiteData_username(String Username){      
       Query idByUser = em.createNamedQuery("User.findByUsername");
       idByUser.setParameter("username", Username);
        try {
                User users = (User) idByUser.getSingleResult();     
                Query websiteData = em.createNamedQuery("WebsiteDataHasUser.findByUserID");
                idByUser.setParameter("userID", users.getId());
                List<WebsiteDataHasUser> websiteUserdata = websiteData.getResultList();
                return websiteUserdata;
        } catch (Exception e) {
            return null;
        }
    }
    
}
