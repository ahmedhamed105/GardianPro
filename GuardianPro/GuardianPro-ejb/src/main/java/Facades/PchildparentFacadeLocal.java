/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Pchildparent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface PchildparentFacadeLocal {

    void create(Pchildparent pchildparent);

    void edit(Pchildparent pchildparent);

    void remove(Pchildparent pchildparent);

    Pchildparent find(Object id);

    List<Pchildparent> findAll();

    List<Pchildparent> findRange(int[] range);

    int count();
    
}
