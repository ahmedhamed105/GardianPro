/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Application;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ApplicationFacadeLocal {

    void create(Application application);

    void edit(Application application);

    void remove(Application application);

    Application find(Object id);

    List<Application> findAll();

    List<Application> findRange(int[] range);

    int count();
    
}
