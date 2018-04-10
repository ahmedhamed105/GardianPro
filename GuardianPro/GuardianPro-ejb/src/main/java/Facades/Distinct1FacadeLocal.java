/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Distinct1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface Distinct1FacadeLocal {

    void create(Distinct1 distinct1);

    void edit(Distinct1 distinct1);

    void remove(Distinct1 distinct1);

    Distinct1 find(Object id);

    List<Distinct1> findAll();

    List<Distinct1> findRange(int[] range);

    int count();
    
}
