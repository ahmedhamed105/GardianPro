/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Component;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface ComponentFacadeLocal {

    void create(Component component);

    void edit(Component component);

    void remove(Component component);

    Component find(Object id);

    List<Component> findAll();

    List<Component> findRange(int[] range);

    int count();
    
}
