/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TerminalGroup;
import Entities.TgroupHasGparameter;
import Entities.TgroupHasParameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface TgroupHasParameterFacadeLocal {

    void create(TgroupHasParameter tgroupHasParameter);

    void edit(TgroupHasParameter tgroupHasParameter);

    void remove(TgroupHasParameter tgroupHasParameter);

    TgroupHasParameter find(Object id);

    List<TgroupHasParameter> findAll();

    List<TgroupHasParameter> findRange(int[] range);

    int count();
    
    List<Entities.TgroupHasParameter> find_term_groups(TerminalGroup group);
    
}
