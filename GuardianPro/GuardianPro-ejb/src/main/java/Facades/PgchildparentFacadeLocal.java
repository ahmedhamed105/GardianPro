/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Pgchildparent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface PgchildparentFacadeLocal {

    void create(Pgchildparent pgchildparent);

    void edit(Pgchildparent pgchildparent);

    void remove(Pgchildparent pgchildparent);

    Pgchildparent find(Object id);

    List<Pgchildparent> findAll();

    List<Pgchildparent> findRange(int[] range);

    int count();
    
}
