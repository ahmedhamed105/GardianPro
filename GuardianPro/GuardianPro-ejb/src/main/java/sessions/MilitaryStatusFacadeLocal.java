/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.MilitaryStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface MilitaryStatusFacadeLocal {

    void create(MilitaryStatus militaryStatus);

    void edit(MilitaryStatus militaryStatus);

    void remove(MilitaryStatus militaryStatus);

    MilitaryStatus find(Object id);

    List<MilitaryStatus> findAll();

    List<MilitaryStatus> findRange(int[] range);

    int count();
    
}
