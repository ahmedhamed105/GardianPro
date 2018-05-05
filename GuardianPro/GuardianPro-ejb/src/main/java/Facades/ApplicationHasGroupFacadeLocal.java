/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ApplicationGroup;
import Entities.ApplicationHasGroup;
import Entities.GroupHasParameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ApplicationHasGroupFacadeLocal {

    void create(ApplicationHasGroup applicationHasGroup);

    void edit(ApplicationHasGroup applicationHasGroup);

    void remove(ApplicationHasGroup applicationHasGroup);

    ApplicationHasGroup find(Object id);

    List<ApplicationHasGroup> findAll();

    List<ApplicationHasGroup> findRange(int[] range);

    int count();
    
    List<ApplicationHasGroup> get_app_group(ApplicationGroup gp);
    
}
