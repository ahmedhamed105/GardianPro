/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Menu;
import Entities.MenuSub;
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
public class MenuSubFacade extends AbstractFacade<MenuSub> implements MenuSubFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuSubFacade() {
        super(MenuSub.class);
    }
    
     @Override
    public List<MenuSub> sub_menulist(Menu b) {
 
         Query para_find = em.createNamedQuery("MenuSub.findByMenu");
        para_find.setParameter("id", b);
        try {
         List<MenuSub>   parah =  para_find.getResultList(); 
           // System.out.println("ahmed hamed  "+parah.getType());
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
