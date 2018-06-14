/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ComponentName;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface ComponentNameFacadeLocal {

    void create(ComponentName componentName);

    void edit(ComponentName componentName);

    void remove(ComponentName componentName);

    ComponentName find(Object id);

    List<ComponentName> findAll();

    List<ComponentName> findRange(int[] range);

    int count();
    
}
