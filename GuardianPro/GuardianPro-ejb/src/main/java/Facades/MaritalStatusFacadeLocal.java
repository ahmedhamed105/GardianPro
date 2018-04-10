/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.MaritalStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface MaritalStatusFacadeLocal {

    void create(MaritalStatus maritalStatus);

    void edit(MaritalStatus maritalStatus);

    void remove(MaritalStatus maritalStatus);

    MaritalStatus find(Object id);

    List<MaritalStatus> findAll();

    List<MaritalStatus> findRange(int[] range);

    int count();
    
}
