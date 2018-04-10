/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.NationalId;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface NationalIdFacadeLocal {

    void create(NationalId nationalId);

    void edit(NationalId nationalId);

    void remove(NationalId nationalId);

    NationalId find(Object id);

    List<NationalId> findAll();

    List<NationalId> findRange(int[] range);

    int count();
    
}
