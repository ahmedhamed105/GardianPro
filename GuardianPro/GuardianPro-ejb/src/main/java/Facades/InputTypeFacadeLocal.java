/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.InputType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface InputTypeFacadeLocal {

    void create(InputType inputType);

    void edit(InputType inputType);

    void remove(InputType inputType);

    InputType find(Object id);

    List<InputType> findAll();

    List<InputType> findRange(int[] range);

    int count();
    
    boolean input_find(String input);
    
}
