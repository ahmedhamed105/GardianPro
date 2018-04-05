/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.SocialData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface SocialDataFacadeLocal {

    void create(SocialData socialData);

    void edit(SocialData socialData);

    void remove(SocialData socialData);

    SocialData find(Object id);

    List<SocialData> findAll();

    List<SocialData> findRange(int[] range);

    int count();
    
}
