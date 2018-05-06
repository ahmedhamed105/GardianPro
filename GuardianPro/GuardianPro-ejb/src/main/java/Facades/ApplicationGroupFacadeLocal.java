/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ApplicationGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ApplicationGroupFacadeLocal {

    void create(ApplicationGroup applicationGroup);

    void edit(ApplicationGroup applicationGroup);

    void remove(ApplicationGroup applicationGroup);

    ApplicationGroup find(Object id);

    List<ApplicationGroup> findAll();

    List<ApplicationGroup> findRange(int[] range);

    int count();
    
    public boolean Pgroup_find(String groupname);
    
}
