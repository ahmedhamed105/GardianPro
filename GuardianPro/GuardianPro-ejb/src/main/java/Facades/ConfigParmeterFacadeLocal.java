/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigParmeter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ConfigParmeterFacadeLocal {

    void create(ConfigParmeter configParmeter);

    void edit(ConfigParmeter configParmeter);

    void remove(ConfigParmeter configParmeter);

    ConfigParmeter find(Object id);

    List<ConfigParmeter> findAll();

    List<ConfigParmeter> findRange(int[] range);

    int count();
    
    ConfigParmeter getparameter(String para);
    
}
