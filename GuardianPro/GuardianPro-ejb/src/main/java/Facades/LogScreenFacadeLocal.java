/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.LogScreen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface LogScreenFacadeLocal {

    void create(LogScreen logScreen);

    void edit(LogScreen logScreen);

    void remove(LogScreen logScreen);

    LogScreen find(Object id);

    List<LogScreen> findAll();

    List<LogScreen> findRange(int[] range);

    int count();
    
}
