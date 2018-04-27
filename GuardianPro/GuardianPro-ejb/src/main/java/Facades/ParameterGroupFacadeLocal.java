/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParameterGroupFacadeLocal {

    void create(ParameterGroup parameterGroup);

    void edit(ParameterGroup parameterGroup);

    void remove(ParameterGroup parameterGroup);

    ParameterGroup find(Object id);

    List<ParameterGroup> findAll();

    List<ParameterGroup> findRange(int[] range);

    int count();
    
}
