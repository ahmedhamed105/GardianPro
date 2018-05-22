/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.GroupsHasUser;
import Entities.User;
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
public class GroupsHasUserFacade extends AbstractFacade<GroupsHasUser> implements GroupsHasUserFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsHasUserFacade() {
        super(GroupsHasUser.class);
    }
    
    @Override
    public   List<GroupsHasUser> find_groups_by_user(User user){ 
           Query groups_find = em.createNamedQuery("GroupsHasUser.findByUserid");
        groups_find.setParameter("id", user);
        try {
         List<GroupsHasUser>  groups =  groups_find.getResultList();
          //  System.out.println("ahmed hamed  "+parah.getGroupname());
         if(groups==null){
         return null;
         }else{
         return groups;
         }
                
        } catch (Exception e) {
            return null;
        }
        }  
    
}
