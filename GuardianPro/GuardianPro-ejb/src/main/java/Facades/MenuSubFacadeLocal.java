/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Menu;
import Entities.MenuSub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface MenuSubFacadeLocal {

    void create(MenuSub menuSub);

    void edit(MenuSub menuSub);

    void remove(MenuSub menuSub);

    MenuSub find(Object id);

    List<MenuSub> findAll();

    List<MenuSub> findRange(int[] range);

    int count();
    
    List<MenuSub> sub_menulist(Menu b);
    
}
