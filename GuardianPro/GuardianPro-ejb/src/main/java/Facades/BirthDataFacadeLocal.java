/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.BirthData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface BirthDataFacadeLocal {

    void create(BirthData birthData);

    void edit(BirthData birthData);

    void remove(BirthData birthData);

    BirthData find(Object id);

    List<BirthData> findAll();

    List<BirthData> findRange(int[] range);

    int count();
    
}
