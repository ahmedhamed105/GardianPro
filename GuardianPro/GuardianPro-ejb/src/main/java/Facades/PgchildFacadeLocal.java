/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Pgchild;
import Entities.TgroupHasGparameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface PgchildFacadeLocal {

    void create(Pgchild pgchild);

    void edit(Pgchild pgchild);

    void remove(Pgchild pgchild);

    Pgchild find(Object id);

    List<Pgchild> findAll();

    List<Pgchild> findRange(int[] range);

    int count();
    
    List<Pgchild> childs_find(TgroupHasGparameter parent);
    
    Pgchild Pchild_find(TgroupHasGparameter parent,TgroupHasGparameter child);
    
}
