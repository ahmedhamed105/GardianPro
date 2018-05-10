/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Parts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface PartsFacadeLocal {

    void create(Parts parts);

    void edit(Parts parts);

    void remove(Parts parts);

    Parts find(Object id);

    List<Parts> findAll();

    List<Parts> findRange(int[] range);

    int count();
    
    boolean par_find(String displayname);
    
}
