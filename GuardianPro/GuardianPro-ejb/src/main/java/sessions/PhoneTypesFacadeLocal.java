/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.PhoneTypes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface PhoneTypesFacadeLocal {

    void create(PhoneTypes phoneTypes);

    void edit(PhoneTypes phoneTypes);

    void remove(PhoneTypes phoneTypes);

    PhoneTypes find(Object id);

    List<PhoneTypes> findAll();

    List<PhoneTypes> findRange(int[] range);

    int count();
    
}
