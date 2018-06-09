/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ActionBar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ActionBarFacadeLocal {

    void create(ActionBar actionBar);

    void edit(ActionBar actionBar);

    void remove(ActionBar actionBar);

    ActionBar find(Object id);

    List<ActionBar> findAll();

    List<ActionBar> findRange(int[] range);

    int count();
    
}
