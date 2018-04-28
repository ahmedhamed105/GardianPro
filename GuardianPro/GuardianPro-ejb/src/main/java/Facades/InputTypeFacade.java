/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.InputType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.elemam
 */
@Stateless
public class InputTypeFacade extends AbstractFacade<InputType> implements InputTypeFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InputTypeFacade() {
        super(InputType.class);
    }

    @Override
    public boolean input_find(String input) {
  
       Query para_find = em.createNamedQuery("InputType.findByType");
        para_find.setParameter("type", input);
        try {
         Entities.InputType  inputtype = (Entities.InputType) para_find.getSingleResult(); 
         //   System.out.println("ahmed hamed  "+inputtype.getType());
         if(inputtype==null){
         return false;
         }else{
         return true;
         }
                
        } catch (Exception e) {
            return false;
        }
    }
    
}
