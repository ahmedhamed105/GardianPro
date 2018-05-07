/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.AccessoryHasGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface AccessoryHasGroupFacadeLocal {

    void create(AccessoryHasGroup accessoryHasGroup);

    void edit(AccessoryHasGroup accessoryHasGroup);

    void remove(AccessoryHasGroup accessoryHasGroup);

    AccessoryHasGroup find(Object id);

    List<AccessoryHasGroup> findAll();

    List<AccessoryHasGroup> findRange(int[] range);

    int count();
    
    List<Entities.AccessoryHasGroup> get_app_group(Entities.AccessoryGroup gp);
    
}
