/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.NearPlaces;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface NearPlacesFacadeLocal {

    void create(NearPlaces nearPlaces);

    void edit(NearPlaces nearPlaces);

    void remove(NearPlaces nearPlaces);

    NearPlaces find(Object id);

    List<NearPlaces> findAll();

    List<NearPlaces> findRange(int[] range);

    int count();
    
}
