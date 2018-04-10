/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import Entity.LoginType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface LoginTypeFacadeLocal {

    void create(LoginType loginType);

    void edit(LoginType loginType);

    void remove(LoginType loginType);

    LoginType find(Object id);

    List<LoginType> findAll();

    List<LoginType> findRange(int[] range);

    int count();
    
}
