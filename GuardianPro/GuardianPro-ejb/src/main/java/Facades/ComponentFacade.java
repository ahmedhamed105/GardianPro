/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Component;
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
    
    
    @Override
      public Component getname(String name){
          try {
               Query component_find = em.createNamedQuery("Component.findByName");
       component_find.setParameter("name", name);
      Component components = (Component) component_find.getSingleResult();
      
        if (components == null) {
                return null;
            } else {
                return components;
            }
          } catch (Exception e) {
              return null;
          }
      
      
      }

    @Override
    public List<Component> getChild(Integer PID) {

        Query component_find = em.createNamedQuery("Component.findByParentID");
        if (PID == -1) {
            component_find.setParameter("parentID", null);
        } else {
            component_find.setParameter("parentID", PID);
        }
        try {
            List<Component> components = (List<Component>) component_find.getResultList();

            if (components == null) {
                return null;
            } else {
                return components;
            }

        } catch (Exception e) {
            return null;
        }
    }

}
