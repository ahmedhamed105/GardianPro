/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Component;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class ComponentFacade extends AbstractFacade<Component> implements ComponentFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponentFacade() {
        super(Component.class);
    }
    
    public  boolean Component_find(String description){
    
        Query para_find = em.createNamedQuery("Component.findByDescription");
        para_find.setParameter("description", description);
        try {
         Entities.Component  compo = (Entities.Component) para_find.getSingleResult(); 
            System.out.println("ahmed Mahmoud  "+compo.getDescription());
         if(compo==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
    }
    
}
