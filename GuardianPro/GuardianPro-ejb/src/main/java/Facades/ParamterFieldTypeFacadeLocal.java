/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParamterFieldType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParamterFieldTypeFacadeLocal {

    void create(ParamterFieldType paramterFieldType);

    void edit(ParamterFieldType paramterFieldType);

    void remove(ParamterFieldType paramterFieldType);

    ParamterFieldType find(Object id);

    List<ParamterFieldType> findAll();

    List<ParamterFieldType> findRange(int[] range);

    int count();
    
}
