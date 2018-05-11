/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TgroupHasSoftware;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasSoftwareFacadeLocal {

    void create(TgroupHasSoftware tgroupHasSoftware);

    void edit(TgroupHasSoftware tgroupHasSoftware);

    void remove(TgroupHasSoftware tgroupHasSoftware);

    TgroupHasSoftware find(Object id);

    List<TgroupHasSoftware> findAll();

    List<TgroupHasSoftware> findRange(int[] range);

    int count();
    
}
