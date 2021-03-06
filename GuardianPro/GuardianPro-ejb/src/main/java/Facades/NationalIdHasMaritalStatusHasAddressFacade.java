/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.NationalIdHasMaritalStatusHasAddress;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class NationalIdHasMaritalStatusHasAddressFacade extends AbstractFacade<NationalIdHasMaritalStatusHasAddress> implements NationalIdHasMaritalStatusHasAddressFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NationalIdHasMaritalStatusHasAddressFacade() {
        super(NationalIdHasMaritalStatusHasAddress.class);
    }
    
}
