/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterGroup;
import Entities.TerminalGroup;
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
    
    List<Entities.TgroupHasGparameter> find_group(ParameterGroup group);
    
    List<Entities.TgroupHasGparameter> find_term_groups(TerminalGroup group);
    
    List<Entities.TgroupHasGparameter> find_term_para(TerminalGroup group,ParameterGroup g2);
    
}
