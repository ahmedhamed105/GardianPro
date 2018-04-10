/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.UserPassword;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface UserPasswordFacadeLocal {

    void create(UserPassword userPassword);

    void edit(UserPassword userPassword);

    void remove(UserPassword userPassword);

    UserPassword find(Object id);

    List<UserPassword> findAll();

    List<UserPassword> findRange(int[] range);

    int count();
    
}
