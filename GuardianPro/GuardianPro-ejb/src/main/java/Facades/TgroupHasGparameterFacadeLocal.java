/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TgroupHasGparameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasGparameterFacadeLocal {

    void create(TgroupHasGparameter tgroupHasGparameter);

    void edit(TgroupHasGparameter tgroupHasGparameter);

    void remove(TgroupHasGparameter tgroupHasGparameter);

    TgroupHasGparameter find(Object id);

    List<TgroupHasGparameter> findAll();

    List<TgroupHasGparameter> findRange(int[] range);

    int count();
    
}
