/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Parameter;
import Entities.ParamterDefault;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParamterDefaultFacadeLocal {

    void create(ParamterDefault paramterDefault);

    void edit(ParamterDefault paramterDefault);

    void remove(ParamterDefault paramterDefault);

    ParamterDefault find(Object id);

    List<ParamterDefault> findAll();

    List<ParamterDefault> findRange(int[] range);

    int count();
    
    
    List<ParamterDefault> get_default(Parameter para);
    
}
