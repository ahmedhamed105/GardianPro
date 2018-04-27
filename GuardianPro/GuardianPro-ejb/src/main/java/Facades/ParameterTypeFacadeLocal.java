/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParameterType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParameterTypeFacadeLocal {

    void create(ParameterType parameterType);

    void edit(ParameterType parameterType);

    void remove(ParameterType parameterType);

    ParameterType find(Object id);

    List<ParameterType> findAll();

    List<ParameterType> findRange(int[] range);

    int count();
    
    public  boolean Paremter_find(String para);
    
}
