/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Reports;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ReportsFacadeLocal {

    void create(Reports reports);

    void edit(Reports reports);

    void remove(Reports reports);

    Reports find(Object id);

    List<Reports> findAll();

    List<Reports> findRange(int[] range);

    int count();
    
    List<Object> find_parameter(String jpl);
    
     List<Object> find_parameter_col(String jpl);
    
}
