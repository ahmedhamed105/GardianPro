/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TgroupHasAccesory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasAccesoryFacadeLocal {

    void create(TgroupHasAccesory tgroupHasAccesory);

    void edit(TgroupHasAccesory tgroupHasAccesory);

    void remove(TgroupHasAccesory tgroupHasAccesory);

    TgroupHasAccesory find(Object id);

    List<TgroupHasAccesory> findAll();

    List<TgroupHasAccesory> findRange(int[] range);

    int count();
    
}
