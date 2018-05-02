/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.RoleHasComponent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface RoleHasComponentFacadeLocal {

    void create(RoleHasComponent roleHasComponent);

    void edit(RoleHasComponent roleHasComponent);

    void remove(RoleHasComponent roleHasComponent);

    RoleHasComponent find(Object id);

    List<RoleHasComponent> findAll();

    List<RoleHasComponent> findRange(int[] range);

    int count();
    
}
