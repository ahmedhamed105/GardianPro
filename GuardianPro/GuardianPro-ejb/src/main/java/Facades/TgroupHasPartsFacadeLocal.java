/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TgroupHasParts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasPartsFacadeLocal {

    void create(TgroupHasParts tgroupHasParts);

    void edit(TgroupHasParts tgroupHasParts);

    void remove(TgroupHasParts tgroupHasParts);

    TgroupHasParts find(Object id);

    List<TgroupHasParts> findAll();

    List<TgroupHasParts> findRange(int[] range);

    int count();
    
}
