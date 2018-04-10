/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.LoginWay;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface LoginWayFacadeLocal {

    void create(LoginWay loginWay);

    void edit(LoginWay loginWay);

    void remove(LoginWay loginWay);

    LoginWay find(Object id);

    List<LoginWay> findAll();

    List<LoginWay> findRange(int[] range);

    int count();
    
}
