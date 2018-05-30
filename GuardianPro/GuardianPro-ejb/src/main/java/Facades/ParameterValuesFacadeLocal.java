/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterValues;
import Entities.TgroupHasGparameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParameterValuesFacadeLocal {

    void create(ParameterValues parameterValues);

    void edit(ParameterValues parameterValues);

    void remove(ParameterValues parameterValues);

    ParameterValues find(Object id);

    List<ParameterValues> findAll();

    List<ParameterValues> findRange(int[] range);

    int count();
    
    List<ParameterValues> ParameterValues_find(TgroupHasGparameter parent);
    
}
