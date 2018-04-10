/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.City;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface CityFacadeLocal {

    void create(City city);

    void edit(City city);

    void remove(City city);

    City find(Object id);

    List<City> findAll();

    List<City> findRange(int[] range);

    int count();
    
}
