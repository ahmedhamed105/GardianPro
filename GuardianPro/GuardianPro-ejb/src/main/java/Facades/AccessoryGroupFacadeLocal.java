/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.AccessoryGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface AccessoryGroupFacadeLocal {

    void create(AccessoryGroup accessoryGroup);

    void edit(AccessoryGroup accessoryGroup);

    void remove(AccessoryGroup accessoryGroup);

    AccessoryGroup find(Object id);

    List<AccessoryGroup> findAll();

    List<AccessoryGroup> findRange(int[] range);

    int count();
    
}
