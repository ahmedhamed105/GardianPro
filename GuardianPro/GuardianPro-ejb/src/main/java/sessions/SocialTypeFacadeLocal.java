/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.SocialType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface SocialTypeFacadeLocal {

    void create(SocialType socialType);

    void edit(SocialType socialType);

    void remove(SocialType socialType);

    SocialType find(Object id);

    List<SocialType> findAll();

    List<SocialType> findRange(int[] range);

    int count();
    
}
