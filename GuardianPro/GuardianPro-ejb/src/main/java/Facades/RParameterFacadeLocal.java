/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.RParameter;
import Entities.Reports;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface RParameterFacadeLocal {

    void create(RParameter rParameter);

    void edit(RParameter rParameter);

    void remove(RParameter rParameter);

    RParameter find(Object id);

    List<RParameter> findAll();

    List<RParameter> findRange(int[] range);

    int count();
    
    List<Entities.RParameter> find_parameter(Reports rep);
    
}
