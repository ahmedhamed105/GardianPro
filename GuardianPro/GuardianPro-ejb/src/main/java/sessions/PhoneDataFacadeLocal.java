/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.PhoneData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface PhoneDataFacadeLocal {

    void create(PhoneData phoneData);

    void edit(PhoneData phoneData);

    void remove(PhoneData phoneData);

    PhoneData find(Object id);

    List<PhoneData> findAll();

    List<PhoneData> findRange(int[] range);

    int count();
    
}
