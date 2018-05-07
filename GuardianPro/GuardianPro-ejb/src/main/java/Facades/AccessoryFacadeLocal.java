/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Accessory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface AccessoryFacadeLocal {

    void create(Accessory accessory);

    void edit(Accessory accessory);

    void remove(Accessory accessory);

    Accessory find(Object id);

    List<Accessory> findAll();

    List<Accessory> findRange(int[] range);

    int count();
    
    boolean access_find(String acess);
    
}
