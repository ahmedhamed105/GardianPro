/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigParmeter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class ConfigParmeterFacade extends AbstractFacade<ConfigParmeter> implements ConfigParmeterFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigParmeterFacade() {
        super(ConfigParmeter.class);
    }
    
       @Override
    public  ConfigParmeter getparameter(String para){      
       Query user_status = em.createNamedQuery("ConfigParmeter.findByParameter");
        user_status.setParameter("parameter", para);
        try {
                ConfigParmeter pa = (ConfigParmeter) user_status.getSingleResult();     
                return pa;
        } catch (Exception e) {
            return null;
        }
    }
    
}
